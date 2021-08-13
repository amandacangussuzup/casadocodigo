package br.com.caelum.casadocodigo.repository


import br.com.caelum.casadocodigo.model.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CrudRepository<Book?, Long ?> {

}