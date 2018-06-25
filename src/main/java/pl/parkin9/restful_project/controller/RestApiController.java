package pl.parkin9.restful_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.parkin9.restful_project.model.MyResponse;
import pl.parkin9.restful_project.model.Response;
import pl.parkin9.restful_project.service.BuildJsonService;
import pl.parkin9.restful_project.service.GetJsonService;

@RestController
@RequestMapping("/api")
public class RestApiController {

    private final GetJsonService getJsonService;
    private final BuildJsonService buildJsonService;

    @Autowired
    public RestApiController(GetJsonService getJsonService, BuildJsonService buildJsonService) {
        this.getJsonService = getJsonService;
        this.buildJsonService = buildJsonService;
    }

//////////////////////////////////////////////////////////////////////////

    @GetMapping("/news/{country}/{category}")
    public MyResponse showArticlesList(@PathVariable String country,
                                       @PathVariable String category) {

        // download Json
        Response responseFrom = getJsonService.listArticles(country, category);

        // create my Json's response
        MyResponse myResponse = buildJsonService.buildMyResponse(country, category, responseFrom);

        return myResponse;
    }
}
