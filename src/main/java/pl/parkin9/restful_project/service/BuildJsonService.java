package pl.parkin9.restful_project.service;

import pl.parkin9.restful_project.model.MyResponse;
import pl.parkin9.restful_project.model.Response;

public interface BuildJsonService {

    MyResponse buildMyResponseByCategory(String country, String category, Response responseFrom);

    MyResponse buildMyResponseBySearchWord(String country, String searchWord, Response responseFrom);
}
