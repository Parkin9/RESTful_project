package pl.parkin9.restful_project.service.getJson;

import pl.parkin9.restful_project.model.Response;

public interface GetJsonService {

    Response listArticles(String country, String category);

    Response listArticles(String country);
}
