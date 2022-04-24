package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MainAdapter extends FirebaseRecyclerAdapter<model,MainAdapter.myviewholder> {


    public MainAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model Model) {
        holder.addr.setText(Model.getAddr());
        holder.catag.setText(Model.getCatag());
        holder.name.setText(Model.getName());
        holder.num.setText(Model.getNum());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_userlist,parent,false);

        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView addr,catag,name,num;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            addr=(TextView) itemView.findViewById(R.id.addrs);
            catag=(TextView) itemView.findViewById(R.id.catagory);
            name=(TextView)itemView.findViewById(R.id.nametext);
            num=(TextView) itemView.findViewById(R.id.numbr);




        }
    }
}
