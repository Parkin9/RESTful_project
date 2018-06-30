package pl.parkin9.restful_project.service.getJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.parkin9.restful_project.model.Response;

import java.util.Map;

@Service
public class GetJsonServiceImpl implements GetJsonService {

    private final ConnectString connectString;

    @Autowired
    public GetJsonServiceImpl(ConnectString connectString) {
        this.connectString = connectString;
    }

///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Response listArticles(String country, String category) {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> connectStrMap = connectString.getConnectStrMap();

        return restTemplate.getForObject(connectStrMap.get("serverUri")
                                            + "?country="
                                            + country
                                            + "&category="
                                            + category
                                            + "&"
                                            + connectStrMap.get("apiKey"), Response.class);
    }

    @Override
    public Response listArticles(String country) {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> connectStrMap = connectString.getConnectStrMap();

        return restTemplate.getForObject(connectStrMap.get("serverUri")
                                            + "?country="
                                            + country
                                            + "&"
                                            + connectStrMap.get("apiKey"), Response.class);
    }
}
