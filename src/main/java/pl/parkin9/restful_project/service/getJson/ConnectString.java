package pl.parkin9.restful_project.service.getJson;

import java.io.IOException;
import java.util.Map;

public interface ConnectString {

    Map<String, String> getConnectStrMap() throws IOException;
}
