package br.com.caelum.casadocodigo.model

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="AUTHOR")
class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long? = null
    var name: @NotBlank String? = null

    @ManyToMany(mappedBy = "author", fetch = FetchType.EAGER)
    var book: List<Book>? = null
    override fun toString(): String {
        return "Author(id=$id, name=$name, book=$book)"
    }


}