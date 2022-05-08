package com.example.myapplication;

import static com.example.myapplication.Dbmain_sch.sch;

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

public class MyAdapter_sch extends RecyclerView.Adapter<MyAdapter_sch.ModelViewHolder> {
    Context context;
    ArrayList<Schedule_dataholder>modelArrayList=new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    //generate constructor

    public MyAdapter_sch(Context context, int singledata, ArrayList<Schedule_dataholder> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }


    @Override
    public MyAdapter_sch.ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.singledata_sch,null);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter_sch.ModelViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Schedule_dataholder model=modelArrayList.get(position);
        holder.t1.setText(model.getCase_status());
        holder.t2.setText(model.getClintename());
        holder.t3.setText(model.getCasenumber());
        holder.t4.setText(model.getCase_name());
        holder.t5.setText(model.getCase_date());
        holder.t6.setText(model.getSc_remarks());


        //click on button go to main activity
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("case_status",model.getCase_status());
                bundle.putString("clinte_name",model.getClintename());
                bundle.putString("case_number",model.getCase_name());
                bundle.putString("case_name",model.getCase_name());
                bundle.putString("case_date",model.getCase_date());
                bundle.putString("remarks_casee",model.getSc_remarks());
                Intent intent=new Intent(context,Schedule.class);
                intent.putExtra("userdata",bundle);
                context.startActivity(intent);
            }
        });
        //delete row
        holder.delete.setOnClickListener(new View.OnClickListener() {
            Dbmain_sch dBmain=new Dbmain_sch(context);
            @Override
            public void onClick(View v) {
                sqLiteDatabase=dBmain.getReadableDatabase();
                long delele=sqLiteDatabase.delete(sch,"case_number="+model.getCasenumber(),null);
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
        Button edit,delete;
        public ModelViewHolder( View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.casee_status_sch);
            t2=(TextView)itemView.findViewById(R.id.clientname_sch);
            t3=(TextView)itemView.findViewById(R.id.casee_number_sch);
            t4=(TextView)itemView.findViewById(R.id.casee_name_sch);
            t5=(TextView)itemView.findViewById(R.id.casee_data_sch);
            t6=(TextView)itemView.findViewById(R.id.remarks_casee_layout_sch);
            edit=(Button)itemView.findViewById(R.id.txt_btn_edit_sch);
            delete=(Button)itemView.findViewById(R.id.txt_btn_delete_sch);
        }
    }
}