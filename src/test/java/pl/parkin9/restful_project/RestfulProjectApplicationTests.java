package pl.parkin9.restful_project;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.parkin9.restful_project.controller.RestApiController;
import pl.parkin9.restful_project.service.BuildJsonService;
import pl.parkin9.restful_project.service.GetJsonService;

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

        Assert.assertNotNull(restApiController);
    }

	@Test
    public void getJsonServiceTest() {

	    Assert.assertEquals("ok", getJsonService.listArticles("pl").getStatus());

	    Assert.assertEquals("https://newsapi.org/v2/top-headlines", getJsonService.getRestServerUri());
        Assert.assertEquals("apiKey=06d5ed0dc471463898148d34dd489b70", getJsonService.getApiKey());
    }

    @Test
    public void buildJsonServiceTest() {

	    Assert.assertNotNull(buildJsonService);
    }

}
