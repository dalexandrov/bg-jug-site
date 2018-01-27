package li.barlog.app.security

import bg.jug.website.security.PropertiesUserDetailsService
import bg.jug.website.security.UserDetailsEx
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class AuthenticationLoggerFilter(
	private val userDetailsService: PropertiesUserDetailsService
) : OncePerRequestFilter() {
	override fun doFilterInternal(req: HttpServletRequest,
								  res: HttpServletResponse,
								  chain: FilterChain) {
		val auth = SecurityContextHolder.getContext().authentication
		val userName = auth.principal as String
		val user = userDetailsService.loadUserByUsername(userName) as UserDetailsEx

		logger.info("user: ${user.name}")

		chain.doFilter(req, res)
	}
}
