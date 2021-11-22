package com.example.bloodbank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<com.example.bloodbank.MyAdapter.ViewHolder> {

    ArrayList<Member> itemLists;

    public MyAdapter(ArrayList<com.example.bloodbank.Member> itemLists) {
        this.itemLists = itemLists;
    }

    @NonNull
    @Override
    public com.example.bloodbank.MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitemadmin,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.bloodbank.MyAdapter.ViewHolder holder, int position) {
        holder.name.setText(itemLists.get(position).getName());
        holder.bloodGroup.setText(itemLists.get(position).getBloodgrp());
        holder.contactNo.setText(itemLists.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener
    {
        TextView name;
        TextView bloodGroup;
        TextView contactNo;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.row_item);
            name = itemView.findViewById(R.id.name);
            bloodGroup = itemView.findViewById(R.id.bloodgroup);
            contactNo = itemView.findViewById(R.id.contactno);
            view.setOnLongClickListener(this);

        }

        @Override
        public boolean onLongClick(View v) {
            int position =getAdapterPosition();
            Toast.makeText(v.getContext(),"Deleted: "+itemLists.get(position).getName(),Toast.LENGTH_SHORT).show();
            itemLists.remove(position);
            notifyItemRemoved(position);
            saveData.writeListInPref(v.getContext(),itemLists);
            return true;
        }
    }
}
