package bg.jug.website.cms.controller

import bg.jug.website.cms.model.Article
import bg.jug.website.cms.repository.ArticlesRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Dmitry Alexandrov on 13.01.2018.
 */
@RestController
@RequestMapping("/api/v1/articles")
class ArticlesController {

    @Autowired
    lateinit var articlesRepo: ArticlesRepo

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAllArticles(): List<Article> {
        return articlesRepo.getAllArticles()
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET),value = "/{id}")
    fun getAllArticleById(@RequestParam(value = "id", defaultValue = "1" )id:String): Article? {
        return articlesRepo.getArticleById(id.toLong())
    }
}