package br.com.caelum.casadocodigo.service;

import br.com.caelum.casadocodigo.model.Author
import br.com.caelum.casadocodigo.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.*
import java.util.function.Consumer

@Service
class CrudAuthor (private val authorRepository:AuthorRepository) {
    val scanner = Scanner(System.`in`)
    private var system = true
    fun inicial() {
        while(system) {

            println("Please choose an option about author ")
            println("0 - Break")
            println("1 - Insert")
            println("2 - View")
            val action = scanner.nextInt()
            when(action){
                1 -> cadastrar()
                2 -> visualizar()
                else -> system = false

            }
        }
    }


    private fun cadastrar(){
        println("Author name: ")
        scanner.nextLine()
        val name = scanner.nextLine()
        val author = Author()
        author.name = name
        authorRepository.save(author)
        println("Salvo")

    }

    private fun visualizar(){
        val author = authorRepository.findAll()
        author.forEach(Consumer { publisher: Author? -> println(publisher) })
    }
}