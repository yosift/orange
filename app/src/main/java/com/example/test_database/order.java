package com.example.test_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class order extends AppCompatActivity {

    data_base db;
    RecyclerView RView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        try {
            ArrayList<h_model> data = new ArrayList<>();

            db=new data_base(this);
            h_model h_m=new h_model("Starbuck",R.drawable.h1,"20 Jun, 10:30","$50");
            data.add(h_m);
            h_model h_m2=new h_model("Burger King ",R.drawable.h2,"10 Jun, 10:15","$70");
            data.add(h_m2);
            h_model h_m3=new h_model("piza hut",R.drawable.h3,"17 Jun, 12:30","$90");
            data.add(h_m3);
            h_model h_m4=new h_model("KFC",R.drawable.h4,"10 Jun, 11:30","$100");
            data.add(h_m4);





            RView=findViewById(R.id.order_Recy);
            h_addapter adapter=new h_addapter(this,data);
            RecyclerView.LayoutManager lm=new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
            RView.setHasFixedSize(true);
            RView.setLayoutManager(lm);
            RView.setAdapter(adapter);
        }catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }






    }
}