package bg.jug.website.security.config

import li.barlog.app.security.AuthenticationLoggerFilter
import bg.jug.website.security.PropertiesUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

@Configuration
@EnableResourceServer
open class ResourceServerConfig : ResourceServerConfigurerAdapter() {
	@Autowired
	private lateinit var tokenServices: DefaultTokenServices

	@Autowired
	private lateinit var userDetailsService: PropertiesUserDetailsService

	override fun configure(http: HttpSecurity) {
		http
			.addFilterAfter(AuthenticationLoggerFilter(userDetailsService),
				FilterSecurityInterceptor::class.java)
			.requestMatchers().antMatchers("/api/dashboard/**")
			.and()
				.authorizeRequests()
					.antMatchers("/api/dashboard/**").hasRole("USER")
					.anyRequest().denyAll()
			.and()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.csrf()
					.csrfTokenRepository(
						CookieCsrfTokenRepository.withHttpOnlyFalse())

	}

	override fun configure(resources: ResourceServerSecurityConfigurer) {
		resources.tokenServices(tokenServices)
	}
}
