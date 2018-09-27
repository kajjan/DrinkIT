package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Controller.Controller;

public class ChooseCategoryActivity extends AppCompatActivity {

    Controller ctrl = new Controller();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
    }


    public void nextToDurationPage(View view) {
        startActivity(new Intent(ChooseCategoryActivity.this, DurationActivity.class));
    }

    public void returnToAddPlayersPage(View view) {
        startActivity(new Intent(ChooseCategoryActivity.this, AddPlayerActivity.class));

    }

//The IDs for Category buttons
    //b1
    //b2
    //b3
    //b4
    //b5
    //b6
    //b7
    //b8
    //b9



}
