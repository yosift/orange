package com.example.test_database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.security.PublicKey;

public class SliderAd extends PagerAdapter {
    Context  contex;
    LayoutInflater layoutInflater;
    public SliderAd(Context c) {
        this.contex=c;
    }

    public int[] im={R.drawable.im2,R.drawable.im3,R.drawable.im1};
    public int[] im2={R.drawable.s1,R.drawable.s2,R.drawable.s3};
    public String[] title={"Browse your  menu\n and order directly","Even to space with \n us! Together","Pickup delivery at \n your door"};
    public String[] des={"Our app can send you everywhere, even \n space. For only $2.99 per month","Our app can send you everywhere, even \n space. For only $2.99 per month","Our app can send you everywhere, even \n space. For only $2.99 per month"};

    @Override
    public int getCount() {
        return des.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) contex.getSystemService(contex.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slider,container,false);
        ImageView imageView=view.findViewById(R.id.s_images);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView2=view.findViewById(R.id.curser);
        TextView tit=view.findViewById(R.id.title);
        TextView des1=view.findViewById(R.id.description);


        imageView.setImageResource(im[position]);
        imageView2.setImageResource(im2[position]);
        tit.setText(title[position]);
        des1.setText(des[position]);
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
