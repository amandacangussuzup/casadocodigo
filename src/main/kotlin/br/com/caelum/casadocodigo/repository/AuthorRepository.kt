package br.com.caelum.casadocodigo.repository

import br.com.caelum.casadocodigo.model.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : CrudRepository<Author?, Long?>{
}