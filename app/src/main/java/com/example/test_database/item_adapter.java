package com.example.test_database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

public class item_adapter extends RecyclerView.Adapter<item_adapter.myholder> {
    data_base  db;
    Context context;
    ArrayList<item_models> item_models;
    ArrayList<item_insert_model> inserted_item;

    public item_adapter(Context context, ArrayList<com.example.test_database.item_models> item_models) {
        this.context = context;
        this.item_models = item_models;
    }

    public void setSearch(ArrayList<item_models> i)
    {
        this.item_models=i;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public item_adapter.myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details,null,false);
        item_adapter.myholder pv=new item_adapter.myholder(v);


        return  pv;
    }

    @Override
    public void onBindViewHolder(@NonNull item_adapter.myholder holder, @SuppressLint("RecyclerView") int position) {
        db =new data_base(context);
        inserted_item=db.get_all_inserted_product();
        inserted_item=db.get_all_inserted_product();
            holder.item_image.setImageResource(item_models.get(position).getItem_image());
            holder.itemname.setText(item_models.get(position).getItem_name());
            holder.pref_description.setText(item_models.get(position).getItem_pref_descriprion());
            holder.Rating_btn.setText(item_models.get(position).getItrem_ratimg()+"");
            holder.Price_btn.setText(item_models.get(position).getItem_price());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(context,Food_details.class);
                    i.putExtra("item_name",inserted_item.get(position).getPro_name());
                    i.putExtra("item_image",inserted_item.get(position).getPro_image());
                    i.putExtra("add1_image",inserted_item.get(position).getImg_item1());
                    i.putExtra("add2_image",inserted_item.get(position).getImg_item2());
                    i.putExtra("add3_image",inserted_item.get(position).getImg_item3());
                    i.putExtra("add1price",inserted_item.get(position).getPro_add1_price());
                    i.putExtra("add2price",inserted_item.get(position).getPro_add2_price());
                    i.putExtra("add3price",inserted_item.get(position).getPro_add3_price());
                    i.putExtra("item_description",inserted_item.get(position).getPro_description());
                    i.putExtra("item_Rating",inserted_item.get(position).getPro_Rating());
                    i.putExtra("item_price",inserted_item.get(position).getPro_price());

                    context.startActivity(i);
                }
            });








    }

    @Override
    public int getItemCount() {
        return item_models.size();
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
