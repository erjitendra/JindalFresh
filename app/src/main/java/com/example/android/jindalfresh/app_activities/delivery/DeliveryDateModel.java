package com.example.android.jindalfresh.app_activities.delivery;

/**
 * Created by Djindal on 19-09-2017.
 */

public class DeliveryDateModel {
    private String Date;
    private String Time;

    public DeliveryDateModel(String date, String time) {
        Date = date;
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
