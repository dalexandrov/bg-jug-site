package bg.jug.website

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan(
        basePackages = arrayOf("bg.jug.website")
)
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}