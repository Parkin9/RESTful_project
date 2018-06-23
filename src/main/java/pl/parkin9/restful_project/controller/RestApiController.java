package pl.parkin9.restful_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.parkin9.restful_project.model.Article;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final String REST_SERVER_URI = "https://newsapi.org/v2/top-headlines";
    public static final String API_KEY = "apiKey=06d5ed0dc471463898148d34dd489b70";

    @GetMapping("/news/{country}/{category}")
    public List<Article> showArticlesList(@PathVariable String country, @PathVariable String category) {


        return null;
    }
}
