package com.example.test_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class Favorites extends AppCompatActivity {
    Switch sh;
    data_base  db;
    ArrayList<Res_model> p;
    ArrayList<item_models> p2;
    RecyclerView RView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        sh=findViewById(R.id.switch1);

        RView=findViewById(R.id.fav_Recu);
        db=new data_base(this);
        sh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    p2=db.getfavitem();
                    item_adapter adapter=new item_adapter(Favorites.this,p2);
                    RecyclerView.LayoutManager lm2=new LinearLayoutManager(Favorites.this, RecyclerView.VERTICAL, false);
                    RView.setHasFixedSize(true);
                    RView.setLayoutManager(lm2);
                    RView.setAdapter(adapter);
                }
                else
                {
                    p=db.getfavorit();
                    RecyclerViewAdapter adapter=new RecyclerViewAdapter(Favorites.this,p);
                    RecyclerView.LayoutManager lm=new LinearLayoutManager(Favorites.this, RecyclerView.VERTICAL, false);
                    RView.setHasFixedSize(true);
                    RView.setLayoutManager(lm);
                    RView.setAdapter(adapter);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        db=new data_base(this);
        if(sh.isChecked()==true)
        {
            Toast.makeText(Favorites.this, "True", Toast.LENGTH_SHORT).show();
        }
        else
        {
            p=db.getfavorit();
            RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,p);
            RecyclerView.LayoutManager lm=new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
            RView.setHasFixedSize(true);
            RView.setLayoutManager(lm);
            RView.setAdapter(adapter);
        }
    }
}