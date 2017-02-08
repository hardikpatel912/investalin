package com.investallign.entities;


public class AccountBalanceEntity {

    public String getRoundUpAmount() {
        return roundUpAmount;
    }

    public void setRoundUpAmount(String roundUpAmount) {
        this.roundUpAmount = roundUpAmount;
    }

    public String getSpendAmount() {
        return spendAmount;
    }

    public void setSpendAmount(String spendAmount) {
        this.spendAmount = spendAmount;
    }

    public String getInvest() {
        return invest;
    }

    public void setInvest(String invest) {
        this.invest = invest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    private String roundUpAmount, spendAmount, invest, date, bgcolor;

    public AccountBalanceEntity(String roundUpAmount, String spendAmount, String invest, String date, String bgcolor) {
        this.roundUpAmount = roundUpAmount;
        this.spendAmount = spendAmount;
        this.invest = invest;
        this.date = date;
        this.bgcolor = bgcolor;
    }

}
