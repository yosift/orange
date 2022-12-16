package com.example.test_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class search extends AppCompatActivity {
SearchView sv;
Switch s1;
RecyclerView RView2;
data_base db;
    item_adapter adapter2;
    ArrayList<item_models> p2;
    RecyclerViewAdapter adapter;


    ArrayList<Res_model> p;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        RView2=findViewById(R.id.Serach_recyclar);
        db=new data_base(this);
        p2=db.getiteme();
        p=db.getAllCars();
        adapter2 =new item_adapter(getApplicationContext(),p2);
        RecyclerView.LayoutManager lm2=new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        RView2.setHasFixedSize(true);
        RView2.setLayoutManager(lm2);
        RView2.setAdapter(adapter2);
        s1=findViewById(R.id.switch1);

        sv=findViewById(R.id.searchview);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(s1.isChecked())
                {
                    ArrayList<Res_model> item_model=new ArrayList<>();

                    adapter  =new RecyclerViewAdapter(getApplicationContext(),p);
                    RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
                    RView2.setHasFixedSize(true);
                    RView2.setLayoutManager(lm);
                    RView2.setAdapter(adapter);

                    for(Res_model i:p)
                    {
                        if(i.getRes_name().toLowerCase().contains(newText.toLowerCase()))
                        {
                            item_model.add(i);
                        }
                    }
                    if(item_model.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        adapter.setSearch2(item_model);
                    }
                }
                else
                {



                    ArrayList<item_models> item_model=new ArrayList<>();

                    adapter2 =new item_adapter(getApplicationContext(),p2);


                    RecyclerView.LayoutManager lm2=new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                    RView2.setHasFixedSize(true);
                    RView2.setLayoutManager(lm2);
                    RView2.setAdapter(adapter2);
                    for(item_models i:p2)
                    {
                        if(i.getItem_name().toLowerCase().contains(newText.toLowerCase()))
                        {
                            item_model.add(i);
                        }
                    }
                    if(item_model.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        adapter2.setSearch(item_model);
                    }
                }

                return false;
            }
        });
    }

}