package com.example.myapplication;

import static com.example.myapplication.DBmain.Clinte;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter_clinte extends RecyclerView.Adapter<MyAdapter_clinte.ModelViewHolder> {
    Context context;
    ArrayList<clinte_dataholder> modelArrayList=new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;

    public MyAdapter_clinte(Context context, int sinflrdata_clinte, ArrayList<clinte_dataholder> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public MyAdapter_clinte.ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.singledata,null);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter_clinte.ModelViewHolder holder,@SuppressLint("RecyclerView")  int position) {
        final clinte_dataholder model = modelArrayList.get(position);
        holder.t1.setText(model.getClinte_name());
        holder.t2.setText(model.getEmail_clinte());
        holder.t3.setText(model.getClinte_number());
        holder.t4.setText(model.getClinte_add());
        holder.t5.setText(model.getClinte_city());
        holder.t6.setText(model.getClinte_remarks());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();

                bundle.putString("name",model.getClinte_name());
                bundle.putString("number",model.getEmail_clinte());
                bundle.putString("address",model.getClinte_number());
                bundle.putString("remarks",model.getClinte_add());
                bundle.putString("category",model.getClinte_city());
                bundle.putString("remarks",model.getClinte_remarks());
                Intent intent=new Intent(context,clinte.class);
                intent.putExtra("userdata",bundle);
                context.startActivity(intent);
            }
        });
    holder.delete.setOnClickListener(new View.OnClickListener() {
        DBmain dBmain=new DBmain(context);
        @Override
        public void onClick(View view) {
            sqLiteDatabase=dBmain.getReadableDatabase();
            long delele=sqLiteDatabase.delete(Clinte,"name="+model.getClinte_name(),null);
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
        TextView t1,t2,t3,t4,t5,t6;
        Button edit, delete;

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.name_clinte);
            t2 = (TextView) itemView.findViewById(R.id.email_clinte);
            t3 = (TextView) itemView.findViewById(R.id.number_clinte);
            t4 = (TextView) itemView.findViewById(R.id.address_clinte);
            t5 = (TextView) itemView.findViewById(R.id.city_clinte);
            t6 = (TextView) itemView.findViewById(R.id.remarks_clinte);
            edit=(Button)itemView.findViewById(R.id.edite_clinte);
            delete=(Button)itemView.findViewById(R.id.delete_clinte);
        }
    }
}
