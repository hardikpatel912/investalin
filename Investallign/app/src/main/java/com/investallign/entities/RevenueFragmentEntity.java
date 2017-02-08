package com.investallign.entities;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RevenueFragmentEntity {

   private String title, leftSideImage, rightSideImage, subTitle;

    public RevenueFragmentEntity() {
    }

    public String getRightSideImage() {
        return rightSideImage;
    }

    public void setRightSideImage(String rightSideImage) {
        this.rightSideImage = rightSideImage;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public RevenueFragmentEntity(String name, String leftSideImage, String rightSideImage, String subTitle) {
        this.title = name;
        this.leftSideImage = leftSideImage;
        this.rightSideImage = rightSideImage;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getLeftSideImage() {
        return leftSideImage;
    }

    public void setLeftSideImage(String leftSideImage) {
        this.leftSideImage = leftSideImage;
    }
}
