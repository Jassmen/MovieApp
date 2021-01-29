package com.example.sliderpager.models;

public class Movies {

    private String title,description,rating,studio,link;
    private int urlMovie,urlCover;

    public Movies(int urlMovie, int urlCover, String title) {
        this.title = title;
        this.urlMovie = urlMovie;
        this.urlCover = urlCover;
    }

    public Movies(int url, String title){
        this.urlMovie =url;
        this.title=title;
    }

    public Movies(String title, String description, String rating, String studio, String link, int url) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.studio = studio;
        this.link = link;
        this.urlMovie = url;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setUrlMovie(int urlMovie) {
        this.urlMovie = urlMovie;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public String getStudio() {
        return studio;
    }

    public String getLink() {
        return link;
    }

    public int getUrlMovie() {
        return urlMovie;
    }

    public int getUrlCover() {
        return urlCover;
    }
}
