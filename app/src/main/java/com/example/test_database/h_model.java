package com.example.test_database;

public class h_model {
    String name;
    int image;
    String date;
    String price;

    public h_model(String name, int image, String date, String price) {
        this.name = name;
        this.image = image;
        this.date = date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }
}
