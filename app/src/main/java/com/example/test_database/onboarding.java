package com.example.test_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class onboarding extends AppCompatActivity {

    ViewPager v;
    SliderAd s;
    public int c;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);



            v = findViewById(R.id.a7a);
            s = new SliderAd(this);
            v.setAdapter(s);


    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            c = position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



    public void cli(View vs) {

        v.setCurrentItem(c++);
        if (c==4)
        {
            Intent gotoSignup=new Intent(onboarding.this,Sign_Up.class);
            startActivity(gotoSignup);
        }
    }


}