package bg.jug.website.cms.controller

import bg.jug.website.cms.model.Page
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Dmitry Alexandrov on 09.01.2018.
 */

@RestController
@RequestMapping("/api/pages")
class PageController{

    private val pages = listOf(Page(1,"Title1","Some content"),Page(1,"Title2","Something"));

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAllPages():List<Page>{
        return pages
    }
}