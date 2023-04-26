package com.example.myfood.models;

public class HomeVerModel {

    int image;
    String name;
    String rating;
    String pricing;
    String timing;

    public HomeVerModel(int image, String name, String rating, String pricing, String timing) {
        this.image = image;
        this.name = name;
        this.rating = rating;
        this.pricing = pricing;
        this.timing = timing;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
