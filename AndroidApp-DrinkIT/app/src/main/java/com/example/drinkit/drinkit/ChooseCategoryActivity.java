package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseCategoryActivity extends MainView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
    }


    public void nextToDurationPage(View view) {
        if (!(getCtrl().categoryListEmpty())) {
            startActivity(new Intent(ChooseCategoryActivity.this, DurationActivity.class));
        } else {
            System.out.println("Please select a category before moving forward"); //visual feedback till användaren på skärmen istället
        }
    }

    public void returnToAddPlayersPage(View view) {
        startActivity(new Intent(ChooseCategoryActivity.this, AddPlayerActivity.class));

    }

    public void category1(View view) {getCtrl().chooseCategory("Charades");} //hitta lösning, ev skapa enum i appen? på något sätt inte ge vyn tillåtelse att ändra eller se för mycket

    public void category2(View view) {getCtrl().chooseCategory("Quiz");}

    public void category3(View view) {getCtrl().chooseCategory("NeverhaveIever");}

    public void category4(View view) {getCtrl().chooseCategory("Truth or dare");}

    public void category5(View view) {getCtrl().chooseCategory("Songs");}

    public void category6(View view) {getCtrl().chooseCategory("Kategori 6");}

    public void category7(View view) {getCtrl().chooseCategory("Kategori 7");}

    public void category8(View view) {getCtrl().chooseCategory("Kategori 8");}

    public void category9(View view) {getCtrl().chooseCategory("Kategori 9");}







}
