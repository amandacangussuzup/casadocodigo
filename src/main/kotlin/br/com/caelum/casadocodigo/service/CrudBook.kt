package br.com.caelum.casadocodigo.service

import br.com.caelum.casadocodigo.model.Author
import br.com.caelum.casadocodigo.model.Book
import br.com.caelum.casadocodigo.model.Publisher
import br.com.caelum.casadocodigo.repository.AuthorRepository
import br.com.caelum.casadocodigo.repository.BookRepository
import br.com.caelum.casadocodigo.repository.PublisherRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.function.Consumer

@Service
class CrudBook (private val bookRepository: BookRepository, private val authorRepository: AuthorRepository, private val publisherRepository: PublisherRepository) {
    val scanner = Scanner(System.`in`)
    private var system = true
    private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    fun inicial() {
        while (system) {
            println("Please choose an option about book")
            println("0 - Break")
            println("1 - Insert")
            println("2 - View")
            val action = scanner.nextInt()
            when (action) {
                1 -> cadastrar()
                2 -> visualizar()
                else -> system = false
            }
        }
    }

    private fun cadastrar(){
        println("Title: ")
        val title = scanner.next()
        println("ISBN: ")
        val isbn = scanner.next()
        println("Description: ")
        val description = scanner.next()
        println("Publish date: ")
        val publishdate = scanner.next()
        println("Publisher Id")
        val publisherId = scanner.nextLong()
        val authors = author()

        val book = Book()
        book.title = title
        book.isbn = isbn
        book.descripton = description
        book.publish_date = LocalDate.parse(publishdate, formatter)
        val publisher = publisherRepository.findById(publisherId)
        book.publisher = publisher.get()
        book.author = authors

        bookRepository.save(book)

        println("Save")

    }

    private fun author(): List<Author> {
        var isTrue = true
        val authors: MutableList<Author> = ArrayList()
        while (isTrue) {
            println("Publisher Id - 0 to break")
            val authorId : Long = scanner.nextLong()
            if (authorId > 0) {
                val author = authorRepository.findById(authorId)
                authors.add(author.get())
            } else {
                isTrue = false
            }
        }
        return authors
    }

    private fun visualizar(){
        val book = bookRepository.findAll()
        book.forEach(Consumer { publisher: Book? -> println(book) })

    }
}