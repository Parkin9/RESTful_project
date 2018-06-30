package pl.parkin9.restful_project.service.getJson;

import pl.parkin9.restful_project.model.Response;

import java.io.IOException;

public interface GetJsonService {

    Response listArticles(String country, String category) throws IOException;

    Response listArticles(String country) throws IOException;
}
