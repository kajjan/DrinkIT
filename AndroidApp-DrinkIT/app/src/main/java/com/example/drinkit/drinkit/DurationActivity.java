package com.example.drinkit.drinkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Controller.Controller;


public class DurationActivity extends AppCompatActivity {


    Controller ctrl = new Controller();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duration);
    }



    public void shortDuration(View view) {
        ctrl.setDuration(3);
    }

    public void mediumDuration(View view) {
        ctrl.setDuration(5);
    }

    public void longDuration(View view) {
        ctrl.setDuration(10);
    }

}

