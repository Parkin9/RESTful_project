package pl.parkin9.restful_project;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.parkin9.restful_project.controller.RestApiController;
import pl.parkin9.restful_project.model.Article;
import pl.parkin9.restful_project.model.Response;
import pl.parkin9.restful_project.model.Source;
import pl.parkin9.restful_project.service.buildJson.BuildJsonService;
import pl.parkin9.restful_project.service.buildJson.SearchArticlesBySearchWord;
import pl.parkin9.restful_project.service.getJson.ConnectString;
import pl.parkin9.restful_project.service.getJson.GetJsonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ConnectString connectString;
    @Autowired
    private SearchArticlesBySearchWord searchArticlesBySearchWord;

    private static Response responseFromTest;

/////////////////////////////////////////////////////////////////////////////////

    @BeforeClass
    public static void mockUpResponseFromExternalServerApi() {

        Source sourceTest = new Source("idTest"
                                , "nameTest");

        Article articleTest = new Article(sourceTest
                                , "AuthorTest"
                                , "TitleTest"
                                , "DescTest"
                                , "UrlTest"
                                , "UrlImageTest"
                                , "publishTest");

        List<Article> articleListTest = new ArrayList<>();
        articleListTest.add(articleTest);

        responseFromTest = new Response("ok", 1, articleListTest);
    }


	@Test
	public void contextLoads() {

        assertNotNull(restApiController);
    }

	@Test
    public void passIfJsonStatusIsOK() {

	    assertEquals("ok", getJsonService.listArticles("pl").getStatus());
    }

    @Test
    public void passIfConnectStringIsRight() {

        Map<String, String> connectStrMap = connectString.getConnectStrMap();
        assertEquals("https://newsapi.org/v2/top-headlines", connectStrMap.get("serverUri"));
        assertEquals("apiKey=06d5ed0dc471463898148d34dd489b70", connectStrMap.get("apiKey"));
    }

    @Test
    public void buildJsonServiceTest() {

        assertNotNull(buildJsonService);
    }

    @Test
    public void passIfFindSearchWordInArticleList() {

        List<Article> articleListContainTest = searchArticlesBySearchWord.buildArticleListContainsSearchWord("TitleTest", responseFromTest);
        List<Article> articleListNotContainTest = searchArticlesBySearchWord.buildArticleListContainsSearchWord("Bum_szaka_laka", responseFromTest);

        assertFalse(articleListContainTest.isEmpty());
        assertTrue(articleListNotContainTest.isEmpty());
    }
}
