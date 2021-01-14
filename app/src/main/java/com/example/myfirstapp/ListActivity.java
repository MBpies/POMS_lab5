package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        ArrayList<ListItemH> testing = new ArrayList<ListItemH>();

        adapter = new ListAdapter();
        if(intent!=null && intent.hasExtra(MainActivity.ARRAY_TAG)){
            testing = intent.getParcelableArrayListExtra(MainActivity.ARRAY_TAG);
            adapter.initialize(testing);
        }


        RecyclerView vu = findViewById(R.id.rec_vu);
        vu.setLayoutManager(new LinearLayoutManager(this));
        vu.setAdapter(adapter);
    }

}