package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{

    Context context;
    ArrayList<model> list;

    public myadapter(Context context, ArrayList<model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        model model=list.get(position);
        holder.name.setText(model.getName());
        holder.address.setText(model.getAddr());
        holder.number.setText(model.getNumber());
        holder.category.setText(model.getCatag());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static class myviewholder extends RecyclerView.ViewHolder{

        EditText id,name,number,address,category,remarks;


        public myviewholder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.lawyerid);
            name=itemView.findViewById(R.id.name);
            number=itemView.findViewById(R.id.numbr);
            address=itemView.findViewById(R.id.addrs);
            category=itemView.findViewById(R.id.catagory);
        }
    }




}




