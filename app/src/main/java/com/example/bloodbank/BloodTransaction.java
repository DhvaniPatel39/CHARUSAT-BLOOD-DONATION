package com.example.bloodbank;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BloodTransaction extends Fragment {

    RecyclerView listView;
    ArrayList<Member> itemList;
    MyAdapter myAdapter;
    private EditText name,bloodgrp;
    private EditText phone;
    Button btn;

    //for current date and time
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy ");
    final String CurrentDateandTime = sdf.format(new Date());


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blood_transaction,container,false);

        name = view.findViewById(R.id.name);
        bloodgrp = view.findViewById(R.id.bg);
        phone = view.findViewById(R.id.pn);
        btn = view.findViewById(R.id.b1);
        myAdapter = new MyAdapter(initDatas());
        listView = view.findViewById(R.id.list_view);
        listView.setHasFixedSize(true);
        listView.setAdapter(myAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        listView.addItemDecoration(dividerItemDecoration);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemList.add(0,new Member(name.getText().toString(),bloodgrp.getText().toString(),phone.getText().toString()+"\nHave donated Blood on : "+CurrentDateandTime));
                myAdapter.notifyItemInserted(0);
                saveData.writeListInPref(view.getContext(),itemList);

            }
        });

        return view;
    }

    private ArrayList<Member> initDatas()
    {
        itemList = saveData.readListFromPref(getContext());
        if(itemList == null)
        {
            itemList = new ArrayList<>();
        }
        itemList.add(new Member("adfadf","fadfadf","adfadf"));
//        itemList = new ArrayList<>();
        return itemList;
    }

}