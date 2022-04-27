package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    ArrayList<model> dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.dname.setText(dataholder.get(position).getName());
        holder.dnumber.setText(dataholder.get(position).getNumber());
        holder.daddress.setText(dataholder.get(position).getAddress());
        holder.dcategory.setText(dataholder.get(position).getCategory());
        holder.dremarks.setText(dataholder.get(position).getRemarks());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView dname,dnumber,daddress ,dcategory,dremarks;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            dname=(TextView)itemView.findViewById(R.id.nametext);
            dnumber=(TextView)itemView.findViewById(R.id.numbr);
            daddress=(TextView)itemView.findViewById(R.id.addrs);
            dcategory=(TextView)itemView.findViewById(R.id.catagory);
            dremarks=(TextView)itemView.findViewById(R.id.remarks);
        }
    }

}

