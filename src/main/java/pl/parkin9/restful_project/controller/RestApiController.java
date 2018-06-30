package pl.parkin9.restful_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.parkin9.restful_project.model.MyResponse;
import pl.parkin9.restful_project.model.Response;
import pl.parkin9.restful_project.service.buildJson.BuildJsonService;
import pl.parkin9.restful_project.service.getJson.GetJsonService;

import java.io.IOException;

@RestController
@RequestMapping("/api/news")
public class RestApiController {

    private final GetJsonService getJsonService;
    private final BuildJsonService buildJsonService;

    @Autowired
    public RestApiController(GetJsonService getJsonService, BuildJsonService buildJsonService) {
        this.getJsonService = getJsonService;
        this.buildJsonService = buildJsonService;
    }

//////////////////////////////////////////////////////////////////////////

    @GetMapping("/{country}/{category}")
    public MyResponse showAllArticlesByCategory(@PathVariable String country,
                                                @PathVariable String category) throws IOException {

        // downloading Json from "newsapi.org"
        Response responseFrom = getJsonService.listArticles(country, category);

        // creating my Json's response
        MyResponse myResponse = buildJsonService.buildMyResponseByCategory(country, category, responseFrom);

        return myResponse;
    }

    @PostMapping("/{country}/{searchWord}")
    public MyResponse showArticlesBySearchWord(@PathVariable String country,
                                               @PathVariable String searchWord) throws IOException {

        // downloading Json from "newsapi.org"
        Response responseFrom = getJsonService.listArticles(country);

        // creating my Json's response
        MyResponse myResponse = buildJsonService.buildMyResponseBySearchWord(country, searchWord, responseFrom);

        return myResponse;
    }
}
