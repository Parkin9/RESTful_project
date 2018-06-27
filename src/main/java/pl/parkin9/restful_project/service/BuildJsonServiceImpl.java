package pl.parkin9.restful_project.service;

import org.springframework.stereotype.Service;
import pl.parkin9.restful_project.model.Article;
import pl.parkin9.restful_project.model.MyResponse;
import pl.parkin9.restful_project.model.Response;

import java.util.ArrayList;

@Service
public class BuildJsonServiceImpl implements BuildJsonService {

    public MyResponse buildMyResponseByCategory(String country, String category, Response responseFrom) {

        return new MyResponse(country, category, responseFrom.getArticles());
    }


    public MyResponse buildMyResponseBySearchWord(String country, String searchWord, Response responseFrom) {

        ArrayList<Article> articleList = responseFrom.getArticles();
        ArrayList<Article> articleListSelection = new ArrayList<>();

        for (Article article : articleList) {

            if (article.toString().toLowerCase().contains(searchWord.toLowerCase())) {

                articleListSelection.add(article);
            }
        }

        return new MyResponse(country, articleListSelection);
    }
}
