package pl.parkin9.restful_project.service;

import pl.parkin9.restful_project.model.MyResponse;
import pl.parkin9.restful_project.model.Response;

public interface BuildJsonService {

    MyResponse buildMyResponse(String country, String category, Response responseFrom);
}
