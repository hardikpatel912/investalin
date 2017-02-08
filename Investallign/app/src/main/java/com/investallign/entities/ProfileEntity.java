package com.investallign.entities;

/**
 * Created by root on 2/12/16.
 */
public class ProfileEntity {

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    private String month;
    private String rate;

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    private String bgColor;
    public ProfileEntity(String month, String rate,String bgColor) {
        this.month = month;
        this.rate = rate;
        this.bgColor = bgColor;

    }
}
