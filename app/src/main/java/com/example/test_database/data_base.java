package com.example.test_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class data_base extends SQLiteOpenHelper {

    public static final String data_base_Name = "Users.db";

    public data_base(Context context) {
        super(context, data_base_Name, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Resturant (R_name text  primary key,R_image int,R_rating integer,R_del text,time text,item1 text,item2 text,item3 text,logo integer)");
        sqLiteDatabase.execSQL("create table products (pro_id integer primary key AUTOINCREMENT,pro_name text,pro_image int,pro_rating int,pro_price text,pro_description text,pro_add1 text ,pro_add2 text,pro_add3 text,pro_add1_price text ,pro_add2_price text ,pro_add3_price text,pref_des text,pro_cat text,add1_image integer,add2_image integer,add3_image integer, R_name text,FOREIGN KEY (R_name) REFERENCES Resturant(R_name))");
        sqLiteDatabase.execSQL("create table User_info (Email text primary key,Full_name text)");
        sqLiteDatabase.execSQL("create table cartIt (cart_id integer primary key AUTOINCREMENT,cart_image integer,cart_name text,cart_price text,cart_pref text,Email text,cart_quntity text,FOREIGN KEY (Email) REFERENCES User_info(Email))");
        sqLiteDatabase.execSQL("create table Favorite (fav_name text primary key,fav_image int,fav_rating int,fav_del text,fav_time text,fav_item1 text ,fav_item2 text,fav_item3 text)");
        sqLiteDatabase.execSQL("create table Favorite_pro (fav_pro_name text primary key,fav_pro_image int,fav_pro_rating int,fav_pro_price text,fav_pro_pref text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertIntoResturant(Resturant_model u) {

        SQLiteDatabase dp = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("R_name", u.getR_name());
        values.put("R_image", u.getR_image());
        values.put("R_rating", u.getR_rating());
        values.put("R_del", u.getR_del());
        values.put("time", u.getTime());
        values.put("item1", u.getItem1());
        values.put("item2", u.getItem2());
        values.put("item3", u.getItem3());
        values.put("logo", u.getlogo());
        dp.insert("Resturant", null, values);
    }
    public ArrayList<Res_model> getfavorit() {
        SQLiteDatabase dp =getReadableDatabase();
        Cursor cursor = dp.rawQuery("SELECT*FROM Favorite", null);
        ArrayList<Res_model> Products = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String R_name = cursor.getString(0);
                int R_image = cursor.getInt(1);
                int R_rating = cursor.getInt(2);
                String R_del=cursor.getString(3);
                String time=cursor.getString(4);
                String item1=cursor.getString(5);
                String item2=cursor.getString(6);
                String item3=cursor.getString(7);
                Res_model prods = new Res_model(R_name,R_image,R_rating,R_del,time,item1,item2,item3);
                Products.add(prods);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return Products;
    }



    public void insertIntofav(Res_model u) {
        SQLiteDatabase dp = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fav_name", u.getRes_name());
        values.put("fav_image", u.getRes_image());
        values.put("fav_rating", u.getRes_rating());
        values.put("fav_del", u.getDel());
        values.put("fav_time", u.getTime());
        values.put("fav_item1", u.getItem1());
        values.put("fav_item2", u.getItem2());
        values.put("fav_item3", u.getItem3());
        dp.insert("Favorite", null, values);
    }






    public void insertIntofavItem(item_models u) {
        SQLiteDatabase dp = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fav_pro_name", u.getItem_name());
        values.put("fav_pro_image", u.getItem_image());
        values.put("fav_pro_rating", u.getItrem_ratimg());
        values.put("fav_pro_price", u.getItem_price());
        values.put("fav_pro_pref", u.getItem_pref_descriprion());
        dp.insert("Favorite_pro", null, values);
    }


    public ArrayList<item_models> getfavitem() {
        SQLiteDatabase dp =getReadableDatabase();
        Cursor cursor = dp.rawQuery("SELECT*FROM Favorite_pro", null);
        ArrayList<item_models> items = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String it_name = cursor.getString(0);
                int it_image = cursor.getInt(1);
                int it_rating = cursor.getInt(2);
                String it_price=cursor.getString(3);
                String it_pref=cursor.getString(4);
                item_models prods = new item_models(it_name,it_image,it_rating,it_price,it_pref);
                items.add(prods);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return items;
    }

















    public void items_insert(item_insert_model item_data) {
        SQLiteDatabase dp = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("pro_name", item_data.getPro_name());
        values.put("pro_image", item_data.getPro_image());
        values.put("pro_rating", item_data.getPro_Rating());
        values.put("pro_price", item_data.getPro_price());
        values.put("pro_description", item_data.getPro_description());
        values.put("pro_add1", item_data.getPro_add1());
        values.put("pro_add2", item_data.getPro_add2());
        values.put("pro_add3", item_data.getPro_add3());
        values.put("pro_add1_price", item_data.getPro_add1_price());
        values.put("pro_add2_price", item_data.getPro_add2_price());
        values.put("pro_add3_price", item_data.getPro_add3_price());
        values.put("pref_des", item_data.getPref_des());
        values.put("pro_cat", item_data.getPro_cat());
        values.put("R_name", item_data.getR_name());


        values.put("add1_image", item_data.getImg_item1());
        values.put("add2_image", item_data.getImg_item2());
        values.put("add3_image", item_data.getImg_item3());
        dp.insert("products", null, values);
    }




    public ArrayList<Res_model> getAllCars() {
        SQLiteDatabase dp =getReadableDatabase();
        Cursor cursor = dp.rawQuery("SELECT*FROM Resturant", null);
        ArrayList<Res_model> Products = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String R_name = cursor.getString(0);
                int R_image = cursor.getInt(1);
                int R_rating = cursor.getInt(2);
                String R_del=cursor.getString(3);
                String time=cursor.getString(4);
                String item1=cursor.getString(5);
                String item2=cursor.getString(6);
                String item3=cursor.getString(7);
                Res_model prods = new Res_model(R_name,R_image,R_rating,R_del,time,item1,item2,item3);
                Products.add(prods);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return Products;
    }






    public ArrayList<item_models> getiteme() {
        SQLiteDatabase dp =getReadableDatabase();
        Cursor cursor = dp.rawQuery("SELECT*FROM products", null);
        ArrayList<item_models> items = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String it_name = cursor.getString(1);
                int it_image = cursor.getInt(2);
                int it_rating = cursor.getInt(3);
                String it_price=cursor.getString(4);
                String it_pref=cursor.getString(12);
                item_models prods = new item_models(it_name,it_image,it_rating,it_price,it_pref);
                items.add(prods);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return items;
    }













    public ArrayList<item_insert_model> get_all_inserted_product() {
        SQLiteDatabase dp =getReadableDatabase();
        Cursor cursor = dp.rawQuery("SELECT*FROM products", null);
        ArrayList<item_insert_model> items = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String it_name = cursor.getString(1);
                int it_image = cursor.getInt(2);
                int it_rating = cursor.getInt(3);
                String it_price=cursor.getString(4);
                String it_pro_description=cursor.getString(5);
                String it_pro_add1 =cursor.getString(6);
                String it_pro_add2=cursor.getString(7);
                String it_pro_add3=cursor.getString(8);
                String it_pro_add1_price=cursor.getString(9);
                String it_pro_add2_price=cursor.getString(10);
                String it_pro_add3_price=cursor.getString(11);
                String it_pref_des=cursor.getString(12);
                String it_pro_cat=cursor.getString(13);
                int it_add1_image = cursor.getInt(14);
                int it_add2_image = cursor.getInt(15);
                int it_add3_image=cursor.getInt(16);
                String it_R_name=cursor.getString(17);
                item_insert_model prods = new item_insert_model(it_name,it_image,it_rating,it_price,it_pro_description,it_pro_add1,it_pro_add2,it_pro_add3,it_pro_add1_price,it_pro_add2_price,it_pro_add3_price,it_pref_des,it_pro_cat,it_R_name,it_add1_image,it_add2_image,it_add3_image);
                items.add(prods);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return items;
    }











    public void insert_into_add_to_cart(insert_item_addToCart_model u) {

        SQLiteDatabase dp = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cart_image", u.getCart_image());
        values.put("cart_name", u.getCart_name());
        values.put("cart_price", u.getCart_price());
        values.put("cart_pref", u.getCart_pref());
        values.put("Email", u.getEmail());
        values.put("cart_quntity", u.getCart_quntity());

        dp.insert("cartIt", null, values);

    }


    public ArrayList<cart_model> showcartItems() {
        SQLiteDatabase dp =getReadableDatabase();
        Cursor cursor = dp.rawQuery("SELECT*FROM cartIt", null);
        ArrayList<cart_model> items = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String it_name = cursor.getString(2);
                int it_image = cursor.getInt(1);
                String quantity = cursor.getString(6);
                String pref=cursor.getString(4);
                String price=cursor.getString(3);
                cart_model prods = new cart_model(it_image,quantity,it_name,pref,price);
                items.add(prods);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return items;
    }












}
