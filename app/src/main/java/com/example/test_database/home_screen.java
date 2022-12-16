package com.example.test_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class home_screen extends AppCompatActivity {
    Button i;
    DrawerLayout d;
    Button bt1,bt2;
    RecyclerView RView,RView2;
    data_base  db;
    EditText ser;

    ImageView hart,cart,order;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        d=findViewById(R.id.draw);
        i=findViewById(R.id.men_icon);
        ser=findViewById(R.id.search_bar);
        hart=findViewById(R.id.hart_ic);
        hart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(home_screen.this,Favorites.class);
                startActivity(i);
            }
        });
cart=findViewById(R.id.cart_logo);
cart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i= new Intent(home_screen.this,AddToCart.class);
        startActivity(i);
    }
});

order=findViewById(R.id.home_ic);
order.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i= new Intent(home_screen.this,order.class);
        startActivity(i);
    }
});







        ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(home_screen.this,search.class);
                startActivity(i);
            }
        });



try {
    RView=findViewById(R.id.Res_recylar);
    RView2=findViewById(R.id.Recylar_Popular_item);
    db=new data_base(this);
    ArrayList<Res_model> p;
    ArrayList<item_models> p2;

    p=db.getAllCars();
    p2=db.getiteme();




    RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,p);


    RecyclerView.LayoutManager lm=new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
    RView.setHasFixedSize(true);
    RView.setLayoutManager(lm);
    RView.setAdapter(adapter);





    item_adapter adapter2=new item_adapter(this,p2);


    RecyclerView.LayoutManager lm2=new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
    RView2.setHasFixedSize(true);
    RView2.setLayoutManager(lm2);
    RView2.setAdapter(adapter2);


}
catch (Exception e)
{
    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
}





        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.openDrawer(GravityCompat.START);
            }
        });

        bt1=findViewById(R.id.btn1);
        bt2=findViewById(R.id.btn2);

        bt2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                bt2.setBackgroundColor(R.drawable.slider_style);
                bt2.setTextColor(R.color.white);
                bt1.setBackgroundColor(R.drawable.white_style);
            }
        });




    }
}