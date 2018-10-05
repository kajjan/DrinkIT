package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import Controller.Controller;
import Model.DrinkIT;

public class MainAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showStartPage();

    }

    DrinkIT model = new DrinkIT();
    Controller ctrl = new Controller(model);
    MainView view = new MainView(ctrl);

    void showStartPage() {
        Intent intent = new Intent(this, StartPageActivity.class);
        startActivity(intent);
    }

}
