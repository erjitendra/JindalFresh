package com.example.android.jindalfresh.app_activities.auth;

public class LoginModel {

    String email;
    String password;

    String CLIENT_ID = "1iNIgULGGwyBSVgveWDYGM9R15cHw76ciny1vV0q";
    String CLIENT_SECRET = "3WDCGYCjvOhNGZzmpWQSXvw6ouoxo6EHqajxJlzawjnHS3IKYMHPSy7GVmza4t3HVcvf7jkKzs75PLQiop4w4IgWF1j30rcmIVgne2UoHfsOhTl2YSA9761Dktgaw4cr";
    String GRANT_TYPE = "password";

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCLIENT_ID() {
        return CLIENT_ID;
    }

    public String getCLIENT_SECRET() {
        return CLIENT_SECRET;
    }

    public String getGRANT_TYPE() {
        return GRANT_TYPE;
    }

}
