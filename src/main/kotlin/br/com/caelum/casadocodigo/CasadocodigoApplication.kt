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
import java.util.*

@SpringBootApplication
class CasadocodigoApplication{
	@Bean
	fun run(publiserService: CrudPublisher, authorService : CrudAuthor, bookService: CrudBook ) = ApplicationRunner {
		bookService.inicial()
	}
}


fun main(args: Array<String>) {
	runApplication<CasadocodigoApplication>(*args)

}
