package com.example.test_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AddToCart extends AppCompatActivity {
    data_base db;
    RecyclerView RView;
    Button btn,check_btn;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        RView=findViewById(R.id.cart_Recylar);
        btn=findViewById(R.id.back_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddToCart.this,home_screen.class);
                startActivity(i);
            }
        });

        check_btn=findViewById(R.id.checkout);
        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddToCart.this,payment.class);
                startActivity(i);
            }
        });


        ArrayList<cart_model> p;

        db=new data_base(this);
        p=db.showcartItems();

        cartadapter adapter=new cartadapter(this,p);


        RecyclerView.LayoutManager lm=new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RView.setHasFixedSize(true);
        RView.setLayoutManager(lm);
        RView.setAdapter(adapter);

    }
}