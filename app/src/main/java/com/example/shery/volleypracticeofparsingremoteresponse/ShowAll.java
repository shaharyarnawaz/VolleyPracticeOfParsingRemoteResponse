package com.example.shery.volleypracticeofparsingremoteresponse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class ShowAll extends AppCompatActivity {
    String url="http://192.168.0.105/getAll.php";
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Contact> listFromShowAll = new ArrayList<Contact>();

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("++--++","onStart Called");
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new RecyclerAdapter(listFromShowAll);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        listFromShowAll=new BackgroundTask(ShowAll.this).getList();

        Log.i("++--++","onCreate Called");



        Log.i("++--++","From ShowAll Activity == "+listFromShowAll.size());

    }
}
