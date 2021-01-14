package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class textActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Intent intent = getIntent();
        TextView tex = findViewById(R.id.textViewIntent);
        if(intent!=null){
            Uri uri = this.getIntent().getData();
            //String url = intent.getStringExtra(Intent.ACTION_VIEW);
            tex.setText(uri.toString());
        }

    }
}