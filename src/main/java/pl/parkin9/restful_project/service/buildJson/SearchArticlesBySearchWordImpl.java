package pl.parkin9.restful_project.service.buildJson;

import org.springframework.stereotype.Component;
import pl.parkin9.restful_project.model.Article;
import pl.parkin9.restful_project.model.Response;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchArticlesBySearchWordImpl implements SearchArticlesBySearchWord {

    @Override
    public List<Article> buildArticleListContainsSearchWord(String searchWord, Response responseFrom) {

        List<Article> articleList = responseFrom.getArticles();
        List<Article> articleListSelected = new ArrayList<>();

        for (Article article : articleList) {

            if (article.toString().toLowerCase().contains(searchWord.toLowerCase())) {

                articleListSelected.add(article);
            }
        }

        return articleListSelected;
    }
}
