package com.example.Restaurant.exception;

public class ErrorDetails {

   private String massage ;
   private String url ;


    public ErrorDetails(String massage, String url) {

        this.massage = massage;
        this.url = url;

    }


    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
