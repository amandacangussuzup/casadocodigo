package br.com.caelum.casadocodigo

import br.com.caelum.casadocodigo.model.Publisher
import br.com.caelum.casadocodigo.repository.PublisherRepository
import br.com.caelum.casadocodigo.service.CrudAuthor
import br.com.caelum.casadocodigo.service.CrudBook
import br.com.caelum.casadocodigo.service.CrudPublisher
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
@EnableJpaRepositories(
	basePackages = ["br.com.caelum.casadocodigo"]
)
@EnableTransactionManagement
@SpringBootApplication
class CasadocodigoApplication{
	@Bean
	fun run(publiserService: CrudPublisher, authorService: CrudAuthor, bookService: CrudBook) = ApplicationRunner {

		val scanner = Scanner(System.`in`)
		var system = true
		while (system) {

			println("Please choose an option ")
			println("0 - Break")
			println("1 - Book")
			println("2 - Publisher")
			println("3 - Author")
			val action = scanner.nextInt()
			when (action) {
				1 -> bookService.inicial()
				2 -> publiserService.inicial()
				3 -> authorService.inicial()
				else -> system = false
			}
		}
	}
}

fun main(args: Array<String>) {
	runApplication<CasadocodigoApplication>(*args)

}
