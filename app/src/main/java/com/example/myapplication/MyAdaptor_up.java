package com.example.myapplication;

import static com.example.myapplication.DBmain_up.up;

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

public class MyAdaptor_up extends RecyclerView.Adapter<MyAdaptor_up.ModelViewHolder> {
    Context context;
    ArrayList<update_dataholder>modelArrayList=new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    //generate constructor

    public MyAdaptor_up(Context context, int singledata, ArrayList<update_dataholder> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }


    @Override
    public MyAdaptor_up.ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.singledata_up,null);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdaptor_up.ModelViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final update_dataholder model=modelArrayList.get(position);
        holder.t1.setText(model.getCase_status_up());
        holder.t2.setText(model.getCase_number_up());
        holder.t3.setText(model.getCase_name_up());
        holder.t4.setText(model.getCase_date_up());
        holder.t5.setText(model.getCase_update_up());


        //click on button go to main activity
        holder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("case_status",model.getCase_status_up());
                bundle.putString("case_number",model.getCase_number_up());
                bundle.putString("case_name",model.getCase_name_up());
                bundle.putString("case_date ",model.getCase_date_up());
                
                bundle.putString("update_up ",model.getCase_update_up());
                Intent intent=new Intent(context,UPdate.class);
                intent.putExtra("userdata",bundle);
                context.startActivity(intent);
            }
        });
        //delete row
        holder.b2.setOnClickListener(new View.OnClickListener() {
            DBmain_up dBmain=new DBmain_up(context);
            @Override
            public void onClick(View v) {
                sqLiteDatabase=dBmain.getReadableDatabase();
                long delele=sqLiteDatabase.delete(up,"case_number="+model.getCase_number_up(),null);
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
        TextView t1,t2,t3,t4,t5;
        Button b1,b2;
        public ModelViewHolder( View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.case_status_up);
            t2=(TextView)itemView.findViewById(R.id.case_number_up);
            t3=(TextView)itemView.findViewById(R.id.case_name_up);
            t4=(TextView)itemView.findViewById(R.id.case_date_up);
           t5=(TextView)itemView.findViewById(R.id.update_up);
            b1=(Button)itemView.findViewById(R.id.btn_edit_upsingle);
            b2=(Button)itemView.findViewById(R.id.btn_delete_upsingle);
        }
    }
}