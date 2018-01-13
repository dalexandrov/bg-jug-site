package bg.jug.website.cms.model

import bg.jug.website.user.User
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by Dmitry Alexandrov on 09.01.2018.
 */
@Entity
data class Article(
        @Id var id: Long? = null,
        @NotNull @Size(min = 1, max = 150) var title: String,
        @NotNull @Size(min = 1, max = 100000) @Column(length = 100000) var content: String,
        @NotNull @Temporal(TemporalType.TIMESTAMP) var createdDate: Date? = null,
        @NotNull @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "AUTHOR_ID") var author: User? = null) {

}