package br.com.caelum.casadocodigo.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "BOOK")
class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var title: @NotBlank String? = null
    var isbn: @NotBlank String? = null
    var descripton: @NotBlank String? = null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    var publish_date: LocalDate? = null

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    var publisher: Publisher? = null

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_autor",
        joinColumns = [JoinColumn(name = "fk_book")],
        inverseJoinColumns = [JoinColumn(name = "fk_author")],
    )
    var author: List<Author>? = null
}