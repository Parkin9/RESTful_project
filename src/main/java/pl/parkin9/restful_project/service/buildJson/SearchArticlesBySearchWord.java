package pl.parkin9.restful_project.service.buildJson;

import pl.parkin9.restful_project.model.Article;
import pl.parkin9.restful_project.model.Response;

import java.util.List;

public interface SearchArticlesBySearchWord {

    List<Article> buildArticleListContainsSearchWord(String searchWord, Response responseFrom);
}
