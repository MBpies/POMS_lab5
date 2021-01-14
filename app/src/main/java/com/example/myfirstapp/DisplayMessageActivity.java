package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        FragmentManager mngr = getSupportFragmentManager();
        FragmentTransaction trs = mngr.beginTransaction();
        trs.replace(R.id.nums_frag,NumsFragment.newInstance());
        trs.replace(R.id.lems_frag,LemsFragment.newInstance());
        trs.commit();
    }
}