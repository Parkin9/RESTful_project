package pl.parkin9.restful_project.service;

import org.springframework.stereotype.Service;
import pl.parkin9.restful_project.model.MyResponse;
import pl.parkin9.restful_project.model.Response;

@Service
public class BuildJsonServiceImpl implements BuildJsonService{

    public MyResponse buildMyResponse(String country, String category, Response responseFrom) {

        // I used ".getTotalResults()" here, to properly display "MyResponse" in a front-end app. I need it for a loop.
        return new MyResponse(country, category, responseFrom.getTotalResults(), responseFrom.getArticles());
    }
}
