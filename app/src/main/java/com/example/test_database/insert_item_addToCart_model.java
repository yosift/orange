package com.example.test_database;

public class insert_item_addToCart_model {


     int cart_image ;
     String cart_name;
     String cart_price ;
     String cart_pref ;
     String Email ;
     String cart_quntity ;


    public insert_item_addToCart_model(int cart_image, String cart_name, String cart_price, String cart_pref, String email, String cart_quntity) {
        this.cart_image = cart_image;
        this.cart_name = cart_name;
        this.cart_price = cart_price;
        this.cart_pref = cart_pref;
        Email = email;
        this.cart_quntity = cart_quntity;
    }


    public int getCart_image() {
        return cart_image;
    }

    public String getCart_name() {
        return cart_name;
    }

    public String getCart_price() {
        return cart_price;
    }

    public String getCart_pref() {
        return cart_pref;
    }

    public String getEmail() {
        return Email;
    }

    public String getCart_quntity() {
        return cart_quntity;
    }




}
