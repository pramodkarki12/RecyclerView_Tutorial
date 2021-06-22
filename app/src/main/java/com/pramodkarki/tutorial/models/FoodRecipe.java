package com.pramodkarki.tutorial.models;

public class FoodRecipe {
    int pic;
    String title;

    public FoodRecipe() {
    }

    public FoodRecipe(int pic, String title) {
        this.pic = pic;
        this.title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
