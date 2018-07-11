package pl.parkin9.restful_project.service.getJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.parkin9.restful_project.model.Response;

import java.io.IOException;
import java.util.Map;

 /*
 * The class gets the JSON's response from a external API.
 */

@Service
public class GetJsonServiceImpl implements GetJsonService {

    private final ConnectString connectString;
    private final RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public GetJsonServiceImpl(ConnectString connectString, RestTemplateBuilder restTemplateBuilder) {
        this.connectString = connectString;
        this.restTemplateBuilder = restTemplateBuilder;
    }

///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Response listArticles(String country, String category) throws IOException {

        Map<String, String> connectStrMap = connectString.getConnectStrMap();

        return restTemplateBuilder.build().getForObject(connectStrMap.get("serverUri")
                                            + "?country="
                                            + country
                                            + "&category="
                                            + category
                                            + "&"
                                            + connectStrMap.get("apiKey"), Response.class);
    }

    @Override
    public Response listArticles(String country) throws IOException {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> connectStrMap = connectString.getConnectStrMap();

        return restTemplate.getForObject(connectStrMap.get("serverUri")
                                            + "?country="
                                            + country
                                            + "&"
                                            + connectStrMap.get("apiKey"), Response.class);
    }
}
