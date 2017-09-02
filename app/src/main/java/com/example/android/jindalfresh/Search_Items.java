package com.example.android.jindalfresh;

/**
 * Created by Jindal on 8/24/2017.
 */

public class Search_Items {

    /**
     * Magnitude of the earthquake
     */
    private String mMagnitude;

    /**
     * Location of the earthquake
     */
    private String mLocation;

    /**
     * Date of the earthquake
     */
    private Long mTimeInMIliSeconds;

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location  is the city location of the earthquake
     * @param date      is the date the earthquake happened
     */
    public Search_Items(String magnitude, String location, Long timeInMIliSeconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMIliSeconds = timeInMIliSeconds;
    }

    /**
     * Returns the magnitude of the earthquake.
     */
    public String getMagnitude() {
        return mMagnitude;
    }

    /**
     * Returns the location of the earthquake.
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Returns the date of the earthquake.
     */
    public Long getTimeInMIliSeconds() {
        return mTimeInMIliSeconds;
    }
}
