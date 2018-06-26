package pl.parkin9.restful_project.model;

import java.util.ArrayList;

public class MyResponse {

    private String country;
    private String category;
    private ArrayList<Article> articles;

    public MyResponse() {
    }

    public MyResponse(String country, String category, ArrayList<Article> articles) {
        this.country = country;
        this.category = category;
        this.articles = articles;
    }

    public MyResponse(String country, ArrayList<Article> articles) {
        this.country = country;
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
                ", articles=" + articles +
                '}';
    }
}
