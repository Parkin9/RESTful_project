package pl.parkin9.restful_project.model;

import java.util.ArrayList;

public class MyResponse {

    private String country;
    private String category;
    private int totalResults;
    private ArrayList<Article> articles;

    public MyResponse() {
    }

    public MyResponse(String country, String category, int totalResults, ArrayList<Article> articles) {
        this.country = country;
        this.category = category;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "MyResponse{" +
                "country='" + country + '\'' +
                ", category='" + category + '\'' +
                ", totalResults=" + totalResults +
                ", articles=" + articles +
                '}';
    }
}
