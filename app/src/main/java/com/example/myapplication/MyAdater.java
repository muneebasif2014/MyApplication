package com.example.myapplication;

import static com.example.myapplication.DBmain.TABLENAME;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdater extends RecyclerView.Adapter<MyAdater.ModelViewHolder> {
    Context context;
    ArrayList<Model>modelArrayList=new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    //generate constructor

    public MyAdater(Context context, int singledata, ArrayList<Model> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public MyAdater.ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.singledata,null);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdater.ModelViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Model model=modelArrayList.get(position);
        holder.name.setText(model.getName());
        holder.number.setText(model.getNumber());
        holder.address.setText(model.getAddress());
        holder.category.setText(model.getCategory());
        holder.remarks.setText(model.getRemarks());


        //click on button go to main activity
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putInt("id",model.getId());
                bundle.putString("name",model.getName());
                bundle.putString("number",model.getNumber());
                bundle.putString("address",model.getAddress());
                bundle.putString("category",model.getCategory());
                bundle.putString("remarks",model.getRemarks());
                Intent intent=new Intent(context,MainActivity.class);
                intent.putExtra("userdata",bundle);
                context.startActivity(intent);
            }
        });
        //delete row
        holder.delete.setOnClickListener(new View.OnClickListener() {
            DBmain dBmain=new DBmain(context);
            @Override
            public void onClick(View v) {
                sqLiteDatabase=dBmain.getReadableDatabase();
                long delele=sqLiteDatabase.delete(TABLENAME,"id="+model.getId(),null);
                if (delele!=-1){
                    Toast.makeText(context, "deleted data successfully", Toast.LENGTH_SHORT).show();
                    modelArrayList.remove(position);
                    notifyDataSetChanged();
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder {
        TextView name,number,address,category,remarks;
        Button edit,delete;
        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.clientname);
            number=(TextView)itemView.findViewById(R.id.number);
            address=(TextView)itemView.findViewById(R.id.address);
            category=(TextView)itemView.findViewById(R.id.category);
            remarks=(TextView)itemView.findViewById(R.id.remarks);
            edit=(Button)itemView.findViewById(R.id.txt_btn_edit);
            delete=(Button)itemView.findViewById(R.id.txt_btn_delete);
        }
    }
}