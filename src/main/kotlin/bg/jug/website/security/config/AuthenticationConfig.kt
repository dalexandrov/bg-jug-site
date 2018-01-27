package bg.jug.website.security.config

import bg.jug.website.security.PropertiesUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
open class AuthenticationConfig : GlobalAuthenticationConfigurerAdapter() {
	@Autowired
	private lateinit var detailsService: PropertiesUserDetailsService

	@Bean
	open fun passwordEncoder() = BCryptPasswordEncoder()

	override fun init(auth: AuthenticationManagerBuilder) {
		auth.userDetailsService(detailsService)
			.passwordEncoder(passwordEncoder())
	}
}
