package br.com.caelum.casadocodigo.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="PUBLISHER")
class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var name: @NotBlank String? = null

    override fun toString(): String {
        return "Publisher(id=$id, name=$name)"
    }


}