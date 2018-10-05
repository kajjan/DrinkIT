package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Controller.Controller;
import Model.Category;

public class ChooseCategoryActivity extends MainView {

    //Controller ctrl = new Controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
    }


    public void nextToDurationPage(View view) {
        if (!(getCtrl().categoryListEmpty())) {
            startActivity(new Intent(ChooseCategoryActivity.this, DurationActivity.class));
        } else {
            System.out.println("Please select a category before moving forward");
        }
    }

    public void returnToAddPlayersPage(View view) {
        startActivity(new Intent(ChooseCategoryActivity.this, AddPlayerActivity.class));

    }

    public void category1(View view) {getCtrl().chooseCategory("Charades");}

    public void category2(View view) {getCtrl().chooseCategory("Quiz");}

    public void category3(View view) {getCtrl().chooseCategory("NeverhaveIever");}

    public void category4(View view) {getCtrl().chooseCategory("Truth or dare");}

    public void category5(View view) {getCtrl().chooseCategory("Songs");}

    public void category6(View view) {getCtrl().chooseCategory("Kategori 6");}

    public void category7(View view) {getCtrl().chooseCategory("Kategori 7");}

    public void category8(View view) {getCtrl().chooseCategory("Kategori 8");}

    public void category9(View view) {getCtrl().chooseCategory("Kategori 9");}







}
