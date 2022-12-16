package com.example.test_database;

public class item_insert_model {
    String pro_name;
    int pro_image;
    int pro_Rating;
    String pro_price;
    String pro_description;
    String pro_add1;
    String pro_add2;
    String pro_add3;
    String pro_add1_price;
    String pro_add2_price;
    String pro_add3_price;
    String pref_des;
    String pro_cat;
    String R_name;
    int img_item1;
    int img_item2;
    int img_item3;

    public item_insert_model(String pro_name, int pro_image, int pro_Rating, String pro_price, String pro_description, String pro_add1, String pro_add2, String pro_add3, String pro_add1_price, String pro_add2_price, String pro_add3_price, String pref_des, String pro_cat, String r_name, int img_item1, int img_item2, int img_item3) {
        this.pro_name = pro_name;
        this.pro_image = pro_image;
        this.pro_Rating = pro_Rating;
        this.pro_price = pro_price;
        this.pro_description = pro_description;
        this.pro_add1 = pro_add1;
        this.pro_add2 = pro_add2;
        this.pro_add3 = pro_add3;
        this.pro_add1_price = pro_add1_price;
        this.pro_add2_price = pro_add2_price;
        this.pro_add3_price = pro_add3_price;
        this.pref_des = pref_des;
        this.pro_cat = pro_cat;
        R_name = r_name;
        this.img_item1 = img_item1;
        this.img_item2 = img_item2;
        this.img_item3 = img_item3;
    }

    public int getImg_item1() {
        return img_item1;
    }

    public int getImg_item2() {
        return img_item2;
    }

    public int getImg_item3() {
        return img_item3;
    }

    public String getPro_name() {
        return pro_name;
    }

    public String getPref_des() {
        return pref_des;
    }

    public int getPro_image() {
        return pro_image;
    }

    public int getPro_Rating() {
        return pro_Rating;
    }

    public String getPro_price() {
        return pro_price;
    }

    public String getPro_description() {
        return pro_description;
    }

    public String getPro_add1() {
        return pro_add1;
    }

    public String getPro_add2() {
        return pro_add2;
    }

    public String getPro_add3() {
        return pro_add3;
    }

    public String getPro_add1_price() {
        return pro_add1_price;
    }

    public String getPro_add2_price() {
        return pro_add2_price;
    }

    public String getPro_add3_price() {
        return pro_add3_price;
    }

    public String getPro_cat() {
        return pro_cat;
    }

    public String getR_name() {
        return R_name;
    }
}
