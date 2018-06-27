package pl.parkin9.restful_project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.parkin9.restful_project.controller.RestApiController;
import pl.parkin9.restful_project.model.Article;
import pl.parkin9.restful_project.model.MyResponse;
import pl.parkin9.restful_project.model.Response;
import pl.parkin9.restful_project.model.Source;
import pl.parkin9.restful_project.service.BuildJsonService;
import pl.parkin9.restful_project.service.GetJsonService;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulProjectApplicationTests {

    @Autowired
    private RestApiController restApiController;
    @Autowired
    private GetJsonService getJsonService;
    @Autowired
    private BuildJsonService buildJsonService;

/////////////////////////////////////////////////////////////////////////////////

	@Test
	public void contextLoads() {

        assertNotNull(restApiController);
    }


	@Test
    public void getJsonServiceTest() {

	    assertEquals("ok", getJsonService.listArticles("pl").getStatus());

	    assertEquals("https://newsapi.org/v2/top-headlines", getJsonService.getRestServerUri());
        assertEquals("apiKey=06d5ed0dc471463898148d34dd489b70", getJsonService.getApiKey());
    }


    @Test
    public void buildJsonServiceTest() {

        assertNotNull(buildJsonService);


        // building a fake response from external REST api
        Source sourceTest = new Source("idSrc", "nameSrc");
        Article articleTest = new Article(sourceTest, "authorArt", "titleArt", "descArt", "urlArt", "imageArt", "publishArt");
        ArrayList<Article> artList= new ArrayList<>();
        artList.add(articleTest);

        Response fakeResponse = new Response("ok", 1, artList);


        MyResponse myResponseExpected = new MyResponse();

        MyResponse myResponseActual = buildJsonService.buildMyResponseByCategory("pl", "technology", fakeResponse);

        if(myResponseExpected.getClass() != myResponseActual.getClass()) {
            fail();
        }
    }
}
