package pl.parkin9.restful_project.service.getJson;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConnectStringImpl implements ConnectString {

    @Override
    public Map<String, String> getConnectStrMap() {

        Map<String, String> connectStrMap = new HashMap<>();
        connectStrMap.put("serverUri", "https://newsapi.org/v2/top-headlines");
        connectStrMap.put("apiKey", "apiKey=06d5ed0dc471463898148d34dd489b70");

        return connectStrMap;
    }
}
