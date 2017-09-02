package com.example.android.jindalfresh;

import java.util.ArrayList;


public class Product {

    private String productEnglishName;
    private String productHindiName;
    private String productImageUrl;
    private String productRate;
    private ArrayList<Integer> productQuantityTypes;
    private String productUnit;

    public String getProductEnglishName() {
        return productEnglishName;
    }

    public void setProductEnglishName(String productEnglishName) {
        this.productEnglishName = productEnglishName;
    }

    public String getProductHindiName() {
        return productHindiName;
    }

    public void setProductHindiName(String productHindiName) {
        this.productHindiName = productHindiName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = "http://lit-dusk-68336.herokuapp.com" + productImageUrl;
    }

    public String getProductRate() {
        return productRate;
    }

    public void setProductRate(String productRate) {
        this.productRate = productRate;
    }

    public ArrayList<Integer> getProductQuantityTypes() {
        return productQuantityTypes;
    }

    public void setProductQuantityTypes(ArrayList<Integer> productQuantityTypes) {
        this.productQuantityTypes = productQuantityTypes;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }


}
