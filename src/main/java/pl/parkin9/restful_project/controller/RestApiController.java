package pl.parkin9.restful_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.parkin9.restful_project.model.Response;
import pl.parkin9.restful_project.service.ArticleService;

@RestController
@RequestMapping("/api")
public class RestApiController {

    private final ArticleService articleService;

    @Autowired
    public RestApiController(ArticleService articleService) {
        this.articleService = articleService;
    }

//////////////////////////////////////////////////////////////////////////

    @GetMapping("/news/{country}/{category}")
    public Response showArticlesList(@PathVariable String country,
                                     @PathVariable String category) {

        return articleService.listArticles(country, category);
    }
}
