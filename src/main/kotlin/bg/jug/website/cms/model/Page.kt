package bg.jug.website.cms.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by Dmitry Alexandrov on 09.01.2018.
 */
@Entity
data class Page(
        @Id var id: Long? = null,
        @NotNull @Size(min = 1, max = 150) var title: String,
        @NotNull @Size(min = 1, max = 100000) @Column(length = 100000) var content: String
) {


}