package bg.jug.website.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

@Configuration
@EnableWebSecurity
open class SecurityConfig : WebSecurityConfigurerAdapter() {


	override fun configure(web: WebSecurity) {
		web.ignoring()
				.antMatchers(HttpMethod.GET, "/")
				.antMatchers(HttpMethod.GET, "/ui/**")
				.antMatchers(HttpMethod.GET, "/health")
	}

	override fun configure(http: HttpSecurity) {
		// @formatter:off
		http
				.requestMatchers()
				.antMatchers("/oauth/authorize")
				.regexMatchers("/(?!oauth)", "/(?!api)")
				.antMatchers("/*")
				.and()
				.authorizeRequests()
				.antMatchers("/oauth/authorize").hasRole("USER")
				.anyRequest().denyAll()
				.and()
				.formLogin()
				.loginPage("/#/login")
				.permitAll()
				.and()
				.httpBasic().disable()
				.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository())
		// @formatter:on
	}

	@Bean
	@Throws(Exception::class)
	override fun authenticationManagerBean(): AuthenticationManager {
		return super.authenticationManagerBean()
	}


}
