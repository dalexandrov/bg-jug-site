package bg.jug.website.security.config

import bg.jug.website.security.AuthenticationSettings
import bg.jug.website.security.CustomJwtTokenEnhancer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore

@Configuration
@EnableAuthorizationServer
open class AuthorizationServerConfig : AuthorizationServerConfigurerAdapter() {
	@Autowired
	private lateinit var authenticationManager: AuthenticationManager

	@Autowired
	private lateinit var authenticationSettings: AuthenticationSettings

	@Bean
	open fun tokenStore(
			authenticationSettings: AuthenticationSettings
	) = JwtTokenStore(accessTokenConverter(authenticationSettings))

	@Bean
	open fun accessTokenConverter(
			authenticationSettings: AuthenticationSettings
	): JwtAccessTokenConverter {
		val jwtAccessTokenConverter = JwtAccessTokenConverter()
		jwtAccessTokenConverter.setSigningKey(authenticationSettings.key)
		return jwtAccessTokenConverter
	}

	@Bean
	@Primary
	open fun tokenServices(
			authenticationSettings: AuthenticationSettings
	): DefaultTokenServices {
		val defaultTokenServices = DefaultTokenServices()
		defaultTokenServices.setTokenStore(tokenStore(authenticationSettings))
		defaultTokenServices.setSupportRefreshToken(true)
		return defaultTokenServices
	}

	@Bean
	open fun customJwtTokenEnhancer() = CustomJwtTokenEnhancer()

	override fun configure(server: AuthorizationServerSecurityConfigurer) {
		server
				.allowFormAuthenticationForClients()
				.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()")
	}

	override fun configure(clients: ClientDetailsServiceConfigurer) {
		// @formatter:off
		clients
				.inMemory()
				.withClient("ui")
				.scopes("api")
				.secret("d3023223c60ae47a0b8fab5e924e19a13a8d82ac")
				.authorizedGrantTypes("authorization_code",
						"refresh_token", "password")
				.autoApprove(true)
				.accessTokenValiditySeconds(
						authenticationSettings.accessTokenValiditySeconds)
				.refreshTokenValiditySeconds(
						authenticationSettings.refreshTokenValiditySeconds)
		// @formatter:on
	}

	override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
		val tokenEnhancerChain = TokenEnhancerChain()
		tokenEnhancerChain.setTokenEnhancers(
				mutableListOf(
						customJwtTokenEnhancer(),
						accessTokenConverter(authenticationSettings))
		)

		endpoints
				.tokenStore(tokenStore(authenticationSettings))
				.tokenEnhancer(tokenEnhancerChain)
				.authenticationManager(authenticationManager)
	}
}
