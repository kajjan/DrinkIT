package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Controller.Controller;
import Model.Category;

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

    public void category1(View view) {ctrl.chooseCategory("Charades");}

    public void category2(View view) {ctrl.chooseCategory("Quiz");}

    public void category3(View view) {ctrl.chooseCategory("NeverhaveIever");}

    public void category4(View view) {ctrl.chooseCategory("Truth or dare");}

    public void category5(View view) {ctrl.selectCategory("Songs");}

    public void category6(View view) {ctrl.selectCategory("Kategori 6");}

    public void category7(View view) {ctrl.selectCategory("Kategori 7");}

    public void category8(View view) {ctrl.selectCategory("Kategori 8");}

    public void category9(View view) {ctrl.selectCategory("Kategori 9");}







}
