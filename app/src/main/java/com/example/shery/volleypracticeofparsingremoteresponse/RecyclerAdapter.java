package com.example.shery.volleypracticeofparsingremoteresponse;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SHERY on 10/4/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    ArrayList<Contact> list=new ArrayList<>();

    public RecyclerAdapter(ArrayList<Contact> list)
    {
        this.list=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.Name.setText(list.get(position).getName());
        holder.Email.setText(list.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView Name,Email;

        public MyViewHolder(View itemView) {
            super(itemView);
            Name=(TextView) itemView.findViewById(R.id.txt_name);
            Email=(TextView) itemView.findViewById(R.id.txt_email);


        }

    }   //MyViewHolder







}//RecyclerAdapter