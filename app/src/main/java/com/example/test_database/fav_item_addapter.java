package com.example.test_database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fav_item_addapter extends RecyclerView.Adapter<fav_item_addapter.myholder> {
    data_base  db;
    Context context;
    ArrayList<item_models> item_models;

    public fav_item_addapter(Context context, ArrayList<com.example.test_database.item_models> item_models) {
        this.context = context;
        this.item_models = item_models;
    }

    @NonNull
    @Override
    public fav_item_addapter.myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item_cell,null,false);
        fav_item_addapter.myholder pv=new fav_item_addapter.myholder(v);


        return  pv;
    }

    @Override
    public void onBindViewHolder(@NonNull fav_item_addapter.myholder holder, @SuppressLint("RecyclerView") int position) {
        db =new data_base(context);
        holder.item_image.setImageResource(item_models.get(position).getItem_image());
        holder.itemname.setText(item_models.get(position).getItem_name());
        holder.pref_description.setText(item_models.get(position).getItem_pref_descriprion());
        holder.Rating_btn.setText(item_models.get(position).getItrem_ratimg()+"");
        holder.Price_btn.setText(item_models.get(position).getItem_price());
        holder.hart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item_models it =new item_models(item_models.get(position).getItem_name(),item_models.get(position).getItem_image(),item_models.get(position).getItrem_ratimg(),item_models.get(position).getItem_price(),item_models.get(position).getItem_pref_descriprion());
                db.insertIntofavItem(it);
                Toast.makeText(context, "product add to fav ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class myholder extends RecyclerView.ViewHolder
    {
        TextView itemname,pref_description;
        Button Rating_btn,Price_btn;
        ImageView item_image,hart;
        public myholder(@NonNull View itemView) {

            super(itemView);
            itemname=itemView.findViewById(R.id.item_name);
            pref_description=itemView.findViewById(R.id.pref_description);
            Rating_btn=itemView.findViewById(R.id.item_btn_rating);
            Price_btn=itemView.findViewById(R.id.price_logo);
            item_image=itemView.findViewById(R.id.item_image);
            hart=itemView.findViewById(R.id.item_hart);
        }
    }


}
