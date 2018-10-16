package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ChooseCategoryActivity extends MainView {

    List<String> categories = new ArrayList<>();
    List<String> presentableCategoryNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        getCategories();
        getPresentableCategoryNames();
        Button btn1 = findViewById(R.id.catOne);
        btn1.setText(presentableCategoryNames.get(0));
        Button btn2 = findViewById(R.id.catTwo);
        btn2.setText(presentableCategoryNames.get(1));
        Button btn3 = findViewById(R.id.catThree);
        btn3.setText(presentableCategoryNames.get(2));
        Button btn4 = findViewById(R.id.catFour);
        btn4.setText(presentableCategoryNames.get(3));
        Button btn5 = findViewById(R.id.catFive);
        btn5.setText(presentableCategoryNames.get(4));
        Button btn6 = findViewById(R.id.catSix);
        btn6.setText(presentableCategoryNames.get(5));
        Button btn7 = findViewById(R.id.catSeven);
        btn7.setText(presentableCategoryNames.get(6));
        Button btn8 = findViewById(R.id.catEight);
        btn8.setText(presentableCategoryNames.get(7));
        Button btn9 = findViewById(R.id.catNine);
        btn9.setText(presentableCategoryNames.get(8));
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

    private List<String> getPresentableCategoryNames() {
        presentableCategoryNames = getCtrl().getPresentableCategoryNames();
        return presentableCategoryNames;
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
