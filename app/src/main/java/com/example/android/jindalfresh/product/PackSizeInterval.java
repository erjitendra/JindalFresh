package com.example.android.jindalfresh.product;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;


public class PackSizeInterval implements Serializable {
    @SerializedName("pack_size_types")
    private ArrayList<String> packSizeTypes;
    @SerializedName("pack_size_rates")
    private ArrayList<Integer> packSizeRates;

    public ArrayList<String> getPackSizeTypes() {
        return packSizeTypes;
    }

    public void setPackSizeTypes(ArrayList<String> packSizeTypes) {
        this.packSizeTypes = packSizeTypes;
    }

    public ArrayList<Integer> getPackSizeRates() {
        return packSizeRates;
    }

    public void setPackSizeRates(ArrayList<Integer> packSizeRates) {
        this.packSizeRates = packSizeRates;
    }
}
