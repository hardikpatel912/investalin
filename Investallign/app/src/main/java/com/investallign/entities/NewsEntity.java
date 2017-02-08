package com.investallign.entities;


public class NewsEntity {

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private String newsTitle, countryName, duration, description, imgUrl;

    public NewsEntity(String newsTitle, String countryName, String duration, String description, String imgUrl) {
        this.newsTitle = newsTitle;
        this.countryName = countryName;
        this.duration = duration;
        this.description = description;
        this.imgUrl = imgUrl;
    }

}
