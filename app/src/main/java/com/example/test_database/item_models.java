package com.example.test_database;

public class item_models {
    String item_name;
    int item_image;
    int itrem_ratimg;
    String item_price;
    String item_pref_descriprion;

    public item_models(String item_name, int item_image, int itrem_ratimg, String item_price, String item_pref_descriprion) {
        this.item_name = item_name;
        this.item_image = item_image;
        this.itrem_ratimg = itrem_ratimg;
        this.item_price = item_price;
        this.item_pref_descriprion = item_pref_descriprion;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getItem_image() {
        return item_image;
    }

    public int getItrem_ratimg() {
        return itrem_ratimg;
    }

    public String getItem_price() {
        return item_price;
    }

    public String getItem_pref_descriprion() {
        return item_pref_descriprion;
    }
}
