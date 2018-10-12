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
        //if (!(getCtrl().categoryListEmpty())) {
            startActivity(new Intent(ChooseCategoryActivity.this, DurationActivity.class));
        //} else {
           // System.out.println("Please select a category before moving forward"); //visual feedback till användaren på skärmen istället
        //}
    }

    public void returnToAddPlayersPage(View view) {
        startActivity(new Intent(ChooseCategoryActivity.this, AddPlayerActivity.class));

    }

    public void category1(View view) {getCtrl().chooseCategory("NeverHaveIEver");} //hitta lösning, ev skapa enum i appen? på något sätt inte ge vyn tillåtelse att ändra eller se för mycket

    public void category2(View view) {getCtrl().chooseCategory("TruthOrDare");}

    public void category3(View view) {getCtrl().chooseCategory("MostLikelyTo");}

    public void category4(View view) {getCtrl().chooseCategory("Rules");}

    public void category5(View view) {getCtrl().chooseCategory("Themes");}

    public void category6(View view) {getCtrl().chooseCategory("ThisOrThat");}

    public void category7(View view) {getCtrl().chooseCategory("Quiz");}

    public void category8(View view) {getCtrl().chooseCategory("Charades");}

    public void category9(View view) {getCtrl().chooseCategory("Songs");}







}
