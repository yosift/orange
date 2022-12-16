package com.example.test_database;

public class Resturant_model {
        String R_name;
   int R_image ;
  int  R_rating ;
    String R_del ;
    String time ;
    String item1 ;
    String  item2;
    String item3 ;
    int logo;

    public Resturant_model(String r_name, int r_image, int r_rating, String r_del, String time, String item1, String item2, String item3,int logo) {
        R_name = r_name;
        R_image = r_image;
        R_rating = r_rating;
        R_del = r_del;
        this.time = time;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.logo=logo;
    }

    public String getR_name() {
        return R_name;
    }

    public int getR_image() {
        return R_image;
    }
    public int getlogo() {
        return logo;
    }

    public int getR_rating() {
        return R_rating;
    }

    public String getR_del() {
        return R_del;
    }

    public String getTime() {
        return time;
    }

    public String getItem1() {
        return item1;
    }

    public String getItem2() {
        return item2;
    }

    public String getItem3() {
        return item3;
    }
}
