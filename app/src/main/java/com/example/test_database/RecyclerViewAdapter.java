package com.example.test_database;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewAdapter extends RecyclerView .Adapter<RecyclerViewAdapter.productView>{

    Context context;
    List<Res_model> pro;
    data_base db;


    public RecyclerViewAdapter(Context context,ArrayList<Res_model> pro) {
        this.pro = pro;
        this.context=context;

    }
    public void setSearch2(ArrayList<Res_model> i)
    {
        this.pro=i;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public productView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_item,null,false);
        productView pv=new productView(v);
        return  pv;
    }

    @Override
    public void onBindViewHolder(@NonNull productView holder, int position) {

        Res_model prd= pro.get(position);
        db=new data_base(context);
        holder.man_image.setImageResource(prd.getRes_image());
        holder.ratting.setText(String.valueOf(prd.getRes_rating()));
        holder.i1.setText(prd.getItem1());
        holder.i2.setText( prd.getItem2());
        holder.i3.setText(prd.getItem3());
        holder.del.setText(prd.getDel());
        holder.time1.setText(prd.getTime());
        holder.R_name.setText(prd.getRes_name());
        holder.hart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Res_model h =new Res_model(prd.getRes_name(),prd.getRes_image(),prd.getRes_rating(),prd.getDel(),prd.getTime(),prd.getItem1(),prd.getItem2(),prd.getItem3());
                db.insertIntofav(h);
                Toast.makeText(context, "Added to fav ", Toast.LENGTH_SHORT).show();
            }
        });
        holder.ratting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,Rating.class);
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return pro.size();
    }

    class  productView extends RecyclerView.ViewHolder
    {
Button ratting,i1,i2,i3;
ImageView man_image,hart;
TextView del,time1,R_name;

        public productView(@NonNull View itemView) {
            super(itemView);
            ratting=itemView.findViewById(R.id.btn_rating);
            i1=itemView.findViewById(R.id.bt1);
            i2=itemView.findViewById(R.id.bt2);
            i3=itemView.findViewById(R.id.bt3);
            man_image=itemView.findViewById(R.id.pro_im);
            del=itemView.findViewById(R.id.delivary);
            time1=itemView.findViewById(R.id.time);
            hart=itemView.findViewById(R.id.hart_item);
            R_name=itemView.findViewById(R.id.Resturan_name);






        }


    }
}
