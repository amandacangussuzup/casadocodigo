package br.com.caelum.casadocodigo.repository

import br.com.caelum.casadocodigo.model.Publisher
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PublisherRepository : CrudRepository<Publisher?, Long?> {
}