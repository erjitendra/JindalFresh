package com.example.android.jindalfresh;

import android.app.LauncherActivity.ListItem;

/**
 * Created by Jindal on 9/1/2017.
 */

public class Rec_ListItem extends ListItem {
    private String head;
    private String desc;
    private int totalQuantity;
    private String imageUrl;

    private int initialQuantity = 1;

    public Rec_ListItem(String head, String desc, String imageUrl) {

        this.head = head;
        this.desc = desc;
        this.imageUrl = imageUrl;
        setTotalQuantity(initialQuantity);
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int quantityValue) {
        this.totalQuantity = quantityValue;
    }

    public void doIncrement() {
        totalQuantity += 1;
    }

//    public int totalPrice() {
//        return totalQuantity*
//    }

    public void doDecrement() {
        totalQuantity -= 1;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}
