package com.example.android.jindalfresh;

/**
 * Created by Jindal on 8/23/2017.
 */

public class Home_Items {
    private int mIamgeId;
    private String mEngName;

    public Home_Items(int image, String engName) {
        mIamgeId = image;
        mEngName = engName;
    }

    public int getmIamge() {
        return mIamgeId;
    }

    public String getmEngName() {
        return mEngName;
    }
}