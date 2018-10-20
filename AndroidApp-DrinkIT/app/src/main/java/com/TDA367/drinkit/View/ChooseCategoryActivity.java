package com.TDA367.drinkit.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ChooseCategoryActivity extends MainView {

    GridLayout categoryGrid;
    List<String> categoryNames = new ArrayList<>();
    final int unActiveBackgroundColor= Color.WHITE;
    final int activeBackgroundColor= Color.GRAY;
    List<Button> categoryButtons = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        getCategoryNames();

        Button btn1; categoryButtons.add(btn1 = findViewById(R.id.catOne));
        Button btn2; categoryButtons.add(btn2 = findViewById(R.id.catTwo));
        Button btn3; categoryButtons.add(btn3 = findViewById(R.id.catThree));
        Button btn4; categoryButtons.add(btn4 = findViewById(R.id.catFour));
        Button btn5; categoryButtons.add(btn5 = findViewById(R.id.catFive));
        Button btn6; categoryButtons.add(btn6 = findViewById(R.id.catSix));
        Button btn7; categoryButtons.add(btn7 = findViewById(R.id.catSeven));
        Button btn8; categoryButtons.add(btn8 = findViewById(R.id.catEight));
        Button btn9; categoryButtons.add(btn9 = findViewById(R.id.catNine));

        for (int i=0; i<categoryButtons.size(); i++) {
            categoryButtons.get(i).setText(categoryNames.get(i));
        }

        /*
        btn1 = findViewById(R.id.catOne);
        btn1.setText(categoryNames.get(0));
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
        */

        categoryGrid = (GridLayout) findViewById(R.id.categoryGrid);
        // setSingleEvent(categoryGrid);
    }


                @SuppressLint("ResourceAsColor")
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                public void changeButtonsColor(View v, int i) {
                    Toast.makeText(ChooseCategoryActivity.this, "clicked at index" + i, Toast.LENGTH_SHORT).show();
                    final Button buttonView= (Button) categoryGrid.getChildAt(i);
                    if(buttonActive(i)){
                        buttonView.setBackgroundColor(unActiveBackgroundColor);

                    }
                    else if(!buttonActive(i)){
                        buttonView.setBackgroundColor(activeBackgroundColor);

                    }
                }

    public int getColorOfButton(int i){
        int color = 0;
        if(buttonActive(i)){
            color= unActiveBackgroundColor;
        }
        else if(!buttonActive(i)){
            color=activeBackgroundColor;
        }
        return color;
    }


    public boolean buttonActive(int index){
        boolean b = getCtrl().buttonActive(index);
        return b;
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

    private List<String> getCategoryNames() {
        categoryNames = getCtrl().getCategoryNames();
        return categoryNames;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void category1(View view) {
        changeButtonsColor(view, 0);
        getCtrl().chooseCategory(categoryNames.get(0));
    } //hitta lösning, ev skapa enum i appen? på något sätt inte ge vyn tillåtelse att ändra eller se för mycket

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category2(View view) {
        changeButtonsColor(view, 1);
        getCtrl().chooseCategory(categoryNames.get(1));}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category3(View view) {
        changeButtonsColor(view, 2);
        getCtrl().chooseCategory(categoryNames.get(2));}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category4(View view) {
        changeButtonsColor(view, 3);
        getCtrl().chooseCategory(categoryNames.get(3));}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category5(View view) {
        changeButtonsColor(view, 4);
        getCtrl().chooseCategory(categoryNames.get(4));}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category6(View view) {
        changeButtonsColor(view, 5);
        getCtrl().chooseCategory(categoryNames.get(5));}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category7(View view) {
        changeButtonsColor(view, 6);
        getCtrl().chooseCategory(categoryNames.get(6));}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category8(View view) {
        changeButtonsColor(view, 7);
        getCtrl().chooseCategory(categoryNames.get(7));}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category9(View view) {
        changeButtonsColor(view, 8);
        getCtrl().chooseCategory(categoryNames.get(8));}







}
