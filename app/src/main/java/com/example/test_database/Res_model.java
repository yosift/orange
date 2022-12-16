package com.example.test_database;

public class Res_model {
    String Res_name;
    int Res_image;
    int Res_rating;
    String del;
    String time;
    String item1;
    String item2;
    String item3;

    public Res_model(String res_name, int res_image, int res_rating, String del, String time, String item1, String item2, String item3) {
        Res_name = res_name;
        Res_image = res_image;
        Res_rating = res_rating;
        this.del = del;
        this.time = time;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public String getRes_name() {
        return Res_name;
    }

    public void setRes_name(String res_name) {
        Res_name = res_name;
    }

    public int getRes_image() {
        return Res_image;
    }

    public void setRes_image(int res_image) {
        Res_image = res_image;
    }

    public int getRes_rating() {
        return Res_rating;
    }

    public void setRes_rating(int res_rating) {
        Res_rating = res_rating;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }
}
