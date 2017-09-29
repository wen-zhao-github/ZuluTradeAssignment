package dev.app.koutsodimakisgeo.zulutradeassignment.Model;

/**
 * Created by koutsodimakisgeo on 28-Sep-17.
 */

public class ProductModel {


    int    currencyId;
    float  buy;
    float  sell;
    String name;
    int  pipMultiplier;

    public int getPipMultiplier() {return pipMultiplier;}

    public void setPipMultiplier(int pipMultiplier) { this.pipMultiplier = pipMultiplier; }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public float getSell() {
        return sell;
    }

    public void setSell(float sell) {
        this.sell = sell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

