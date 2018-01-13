package bg.jug.website.cms.repository

import bg.jug.website.cms.model.Article
import bg.jug.website.user.User
import org.springframework.stereotype.Component
import java.util.*

/**
 * Created by Dmitry Alexandrov on 13.01.2018.
 */
@Component
class ArticlesRepo {

    lateinit var articles: List<Article>

    init {
        var user = User(1L, "nickname", "Joe", "Doe", "mail@example.com", null, "Oh, thats a long story", "unbreakable")
        articles = listOf(
                Article(1L, "Sample Article", "some strange things to happen", Date(), user),
                Article(2L, "Yet another Article", "and some more things to happen", Date(), user),
                Article(3L, "The last Article", "just for today", Date(), user))
    }

    fun getAllArticles(): List<Article> {
        return articles
    }

    fun getArticleById(id: Long?): Article? {
        return articles.find { article -> article.id == id }
    }
}