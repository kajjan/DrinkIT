package com.TDA367.drinkit.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ChooseCategoryActivity extends MainView {

    List<String> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        getCategories();
    }


    public void nextToDurationPage(View view) {
        //if (getCtrl().atLeastOneCategoryChosen()) {
            startActivity(new Intent(ChooseCategoryActivity.this, DurationActivity.class));
        //} else {
         //   System.out.println("Please select a category before moving forward"); //visual feedback till användaren på skärmen istället
        //}
    }

    public void returnToAddPlayersPage(View view) {
        startActivity(new Intent(ChooseCategoryActivity.this, AddPlayerActivity.class));
    }


    private List<String> getCategories() {
        categories = getCtrl().getCategories();
        return categories;
    }


    public void category1(View view) {getCtrl().chooseCategory(categories.get(0));} //hitta lösning, ev skapa enum i appen? på något sätt inte ge vyn tillåtelse att ändra eller se för mycket

    public void category2(View view) {getCtrl().chooseCategory(categories.get(1));}

    public void category3(View view) {getCtrl().chooseCategory(categories.get(2));}

    public void category4(View view) {getCtrl().chooseCategory(categories.get(3));}

    public void category5(View view) {getCtrl().chooseCategory(categories.get(4));}

    public void category6(View view) {getCtrl().chooseCategory(categories.get(5));}

    public void category7(View view) {getCtrl().chooseCategory(categories.get(6));}

    public void category8(View view) {getCtrl().chooseCategory(categories.get(7));}

    public void category9(View view) {getCtrl().chooseCategory(categories.get(8));}







}
