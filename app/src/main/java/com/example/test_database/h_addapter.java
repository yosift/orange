package com.example.test_database;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Timer;

public class h_addapter extends RecyclerView.Adapter<h_addapter.Myholder> {

    Context context;
    ArrayList<h_model>h_models;

    public h_addapter(Context context, ArrayList<h_model> h_models) {
        this.context = context;
        this.h_models = h_models;
    }

    @NonNull
    @Override
    public h_addapter.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.history_order,null,false);
        h_addapter.Myholder pv=new h_addapter.Myholder(v);
        return  pv;
    }

    @Override
    public void onBindViewHolder(@NonNull h_addapter.Myholder holder, int position) {
        holder.main_image.setImageResource(h_models.get(position).getImage());
        holder.price.setText(h_models.get(position).getPrice());
        holder.title.setText(h_models.get(position).getName());
        holder.date.setText(h_models.get(position).getDate());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,map_view.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return h_models.size();
    }

    class Myholder extends RecyclerView.ViewHolder
    {
        ImageView main_image;
        TextView price,title,date;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            main_image=itemView.findViewById(R.id.image_h);
            price=itemView.findViewById(R.id.price_h);
            title=itemView.findViewById(R.id.name_h);
            date=itemView.findViewById(R.id.date_h);
        }
    }

}
