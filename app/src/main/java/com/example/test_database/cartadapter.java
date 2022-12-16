package com.example.test_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cartadapter extends RecyclerView.Adapter<cartadapter.myholder> {


    Context context;
    ArrayList<cart_model> data;

    public cartadapter(Context context, ArrayList<cart_model> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public cartadapter.myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.add_to_cart_item,null,false);
        myholder pv=new myholder(v);
        return  pv;
    }

    @Override
    public void onBindViewHolder(@NonNull cartadapter.myholder holder, int position) {
        holder.main_im.setImageResource(data.get(position).getCart_image());
        holder.title.setText(data.get(position).getTitle());
        holder.pref.setText(data.get(position).getPref());
        holder.price.setText(data.get(position).getPrice());
        holder.quantite.setText(data.get(position).getQuantity());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myholder extends RecyclerView.ViewHolder
    {

        ImageView main_im;
        TextView title;
        TextView pref;
        TextView price;
        TextView quantite;

        public myholder(@NonNull View itemView) {

            super(itemView);

            main_im=itemView.findViewById(R.id.cart_image);
            title=itemView.findViewById(R.id.cart_title);
            pref=itemView.findViewById(R.id.cart_pref);
            price=itemView.findViewById(R.id.cart_price);
            quantite=itemView.findViewById(R.id.cart_quantite);
        }


    }
}
