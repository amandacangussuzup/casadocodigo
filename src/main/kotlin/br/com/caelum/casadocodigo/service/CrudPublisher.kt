package br.com.caelum.casadocodigo.service

import br.com.caelum.casadocodigo.model.Publisher
import br.com.caelum.casadocodigo.repository.PublisherRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Consumer


@Service
class CrudPublisher(private val publisherRepository: PublisherRepository) {
    val scanner = Scanner(System.`in`)
    private var system = true
    fun inicial() {
        while(system) {

            println("Digite o autor: ")
            println("0 - Sair")
            println("1 - Cadastrar")
            println("2 - Visualizar")
            val action = scanner.nextInt()
            when(action){
                1 -> cadastrar()
                2 -> visualizar()
                else -> system = false

            }
        }
    }


    private fun cadastrar(){
        println("Publisher name: ")
        scanner.nextLine()
        val name = scanner.nextLine()
        val publisher = Publisher()
        publisher.name = name
        publisherRepository.save(publisher)
        println("Salvo")

    }

    private fun visualizar(){
        val cargos = publisherRepository.findAll()
        cargos.forEach(Consumer { publisher: Publisher? -> println(publisher) })
    }
}