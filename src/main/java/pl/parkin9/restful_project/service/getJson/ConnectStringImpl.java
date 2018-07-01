package pl.parkin9.restful_project.service.getJson;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

 /*
 * The class prepares the ConnectString to external API.
 */

@Component
public class ConnectStringImpl implements ConnectString {

    @Override
    public Map<String, String> getConnectStrMap() throws IOException {

        String filePath = "filesResource/connstring.txt";
        String serverUri;
        String apiKey;
        Map<String, String> connectStrMap = new HashMap<>();

        try (BufferedReader bufferedFile = new BufferedReader(new FileReader(filePath))) {

            serverUri = bufferedFile.readLine();
            apiKey = bufferedFile.readLine();

            connectStrMap.put("serverUri", serverUri);
            connectStrMap.put("apiKey", apiKey);
        }

        return connectStrMap;
    }
}
