package com.example.test_database;

public class cart_model {

    int cart_image;
    String quantity;
    String title;
    String pref;
    String price;

    public cart_model(int cart_image, String quantity, String title, String pref, String price) {
        this.cart_image = cart_image;
        this.quantity = quantity;
        this.title = title;
        this.pref = pref;
        this.price = price;
    }

    public int getCart_image() {
        return cart_image;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getPref() {
        return pref;
    }

    public String getPrice() {
        return price;
    }
}
