package pl.parkin9.restful_project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.parkin9.restful_project.model.Response;

@Service
public class GetJsonServiceImpl implements GetJsonService {

    private static final String REST_SERVER_URI = "https://newsapi.org/v2/top-headlines";
    private static final String API_KEY = "apiKey=06d5ed0dc471463898148d34dd489b70";

    // for tests
    public String getRestServerUri() {
        return REST_SERVER_URI;
    }
    public String getApiKey() {
        return API_KEY;
    }

///////////////////////////////////////////////////////////////////////////////////////

    public Response listArticles(String country, String category) {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(REST_SERVER_URI
                                                + "?country="
                                                + country
                                                + "&category="
                                                + category
                                                + "&"
                                                + API_KEY, Response.class);
    }


    public Response listArticles(String country) {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(REST_SERVER_URI
                + "?country="
                + country
                + "&"
                + API_KEY, Response.class);
    }
}
