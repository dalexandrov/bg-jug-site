package bg.jug.website.user

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by Dmitry Alexandrov on 09.01.2018.
 */
@Entity
data class User(
        @Id var id: Long? = null,
        @NotNull var nickname: String,
        @NotNull var firstName: String,
        @NotNull var lastName: String,
        @NotNull var email:String,
        @Lob var photo:ByteArray?,
        @Size(min = 1, max = 1000) var bio: String,
        @NotNull var password: String

)