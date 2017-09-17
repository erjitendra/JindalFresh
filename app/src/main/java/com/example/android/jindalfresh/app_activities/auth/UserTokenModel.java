package com.example.android.jindalfresh.app_activities.auth;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class UserTokenModel {

    @SerializedName("access_token")
    String accessToken;

    @SerializedName("token_type")
    String tokenType;

    @SerializedName("expires_in")
    String expiresIn;

    @SerializedName("refresh_token")
    String refreshToken;

    @SerializedName("scope")
    String scope;

    public String getAccessToken() {

        Log.v("APP_Logs", accessToken);
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean hasToken() {
        return accessToken != null;
    }

}
