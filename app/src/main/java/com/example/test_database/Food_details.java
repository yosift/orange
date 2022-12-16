package com.example.test_database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Food_details extends AppCompatActivity {
    String first_price,second_price,third_price,desc,price,name;
    int rating_int,addim1,addim2,addim3,image;
    TextView p1,p2,p3,title,rating,main_price,description;
    ImageView add1image;
    ImageView add2image;
    ImageView add3image;
    ImageView main_image;
    Button addtocart;
    data_base db;
    TextView tx;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        Intent i=getIntent();
        first_price=i.getStringExtra("add1price");
        second_price=i.getStringExtra("add2price");
        third_price=i.getStringExtra("add3price");
        addim1 = i.getIntExtra("add1_image",0);
        addim2=i.getIntExtra("add2_image",0);
        addim3=i.getIntExtra("add3_image",0);
        image=i.getIntExtra("item_image",0);
        rating_int=i.getIntExtra("item_Rating",0);
        name=i.getStringExtra("item_name");
        desc=i.getStringExtra("item_description");
        price=i.getStringExtra("item_price");
        p1=findViewById(R.id.price1);
        p2=findViewById(R.id.price2);
        p3=findViewById(R.id.price3);
        title=findViewById(R.id.title);
        rating=findViewById(R.id.rating_text_from_Food_details);
        main_image=findViewById(R.id.pro_im);
        main_price=findViewById(R.id.pr_price);
        description=findViewById(R.id.description_for_food_items);
        add1image=findViewById(R.id.im1);
        add2image=findViewById(R.id.im2);
        add3image=findViewById(R.id.im3);
        addtocart=findViewById(R.id.add);
        p1.setText(first_price);
        p2.setText(second_price);
        p3.setText(third_price);
        title.setText(name);
        rating.setText(rating_int+"");
        main_image.setImageResource(image);
        main_price.setText(price);
        description.setText(desc);
        add1image.setImageResource(addim1);
        add2image.setImageResource(addim2);
        add3image.setImageResource(addim3);
        tx=findViewById(R.id.qun);


        db=new data_base(this);

        insert_item_addToCart_model da=new insert_item_addToCart_model(image,name,price,"checken hot","y.tarek1996@gmail.com",tx.getText().toString());


        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insert_into_add_to_cart(da);

            }
        });
    }
}