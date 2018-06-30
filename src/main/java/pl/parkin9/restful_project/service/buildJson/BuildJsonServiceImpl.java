package pl.parkin9.restful_project.service.buildJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parkin9.restful_project.model.Article;
import pl.parkin9.restful_project.model.MyResponse;
import pl.parkin9.restful_project.model.Response;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildJsonServiceImpl implements BuildJsonService {

    private final SearchArticlesBySearchWord searchArticlesBySearchWord;

    @Autowired
    public BuildJsonServiceImpl(SearchArticlesBySearchWord searchArticlesBySearchWord) {
        this.searchArticlesBySearchWord = searchArticlesBySearchWord;
    }

///////////////////////////////////////////////////////////////////////////////////

    @Override
    public MyResponse buildMyResponseByCategory(String country, String category, Response responseFrom) {

        return new MyResponse(country, category, responseFrom.getArticles());
    }

    @Override
    public MyResponse buildMyResponseBySearchWord(String country, String searchWord, Response responseFrom) {

        List<Article> articleListSelected = searchArticlesBySearchWord.buildArticleListContainsSearchWord(searchWord, responseFrom);

        return new MyResponse(country, articleListSelected);
    }
}
