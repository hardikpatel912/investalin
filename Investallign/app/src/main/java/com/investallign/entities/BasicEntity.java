package com.investallign.entities;


public class BasicEntity {

   private String title, views, videourl;

    public BasicEntity() {
    }


    public BasicEntity(String title, String views, String videourl) {
        this.title = title;
        this.views = views;
        this.videourl = videourl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }
}
