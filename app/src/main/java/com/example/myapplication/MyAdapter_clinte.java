package com.example.myapplication;

import static com.example.myapplication.DBmain_clinte.Clinte;


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

import com.firebase.ui.database.FirebaseRecyclerOptions;

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


    @Override
    public MyAdapter_clinte.ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.sinflrdata_clinte,null);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyAdapter_clinte.ModelViewHolder holder,@SuppressLint("RecyclerView")  int position) {
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
                bundle.putString("email",model.getEmail_clinte());
                bundle.putString("number",model.getClinte_number());
                bundle.putString("addresse",model.getClinte_add());
                bundle.putString("city",model.getClinte_city());
                bundle.putString("remarks",model.getClinte_remarks());
                Intent intent=new Intent(context,clinte.class);
                intent.putExtra("userdata",bundle);
                context.startActivity(intent);
            }
        });
    holder.delete.setOnClickListener(new View.OnClickListener() {
        DBmain_clinte dBmain= new DBmain_clinte(context);
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

        public ModelViewHolder( View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.name_clintesingle);
            t2 = (TextView) itemView.findViewById(R.id.email_clintesingle);
            t3 = (TextView) itemView.findViewById(R.id.number_clintesinglne);
            t4 = (TextView) itemView.findViewById(R.id.address_clintesingle);
            t5 = (TextView) itemView.findViewById(R.id.city_clinte);
            t6 = (TextView) itemView.findViewById(R.id.remarks_clinte);
            edit=(Button)itemView.findViewById(R.id.edite_clintesingle);
            delete=(Button)itemView.findViewById(R.id.delete_clintesingle);
        }
    }
}
