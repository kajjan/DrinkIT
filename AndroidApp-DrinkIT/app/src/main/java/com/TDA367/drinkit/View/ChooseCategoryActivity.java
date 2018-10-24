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

/**
 * This activity handles the view where the user chooses categories
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class ChooseCategoryActivity extends MainView {

    GridLayout categoryGrid;
    List<String> categoryNames = new ArrayList<>();
    final int unActiveBackgroundColor = Color.WHITE;
    final int activeBackgroundColor = Color.GRAY;
    List<Button> categoryButtons = new ArrayList<>();  // cache category names
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        categoryNames = getCtrl().getCategoryNames();

        categoryButtons.add(btn1 = findViewById(R.id.catOne));
        categoryButtons.add(btn2 = findViewById(R.id.catTwo));
        categoryButtons.add(btn3 = findViewById(R.id.catThree));
        categoryButtons.add(btn4 = findViewById(R.id.catFour));
        categoryButtons.add(btn5 = findViewById(R.id.catFive));
        categoryButtons.add(btn6 = findViewById(R.id.catSix));
        categoryButtons.add(btn7 = findViewById(R.id.catSeven));
        categoryButtons.add(btn8 = findViewById(R.id.catEight));
        categoryButtons.add(btn9 = findViewById(R.id.catNine));

        for (int i = 0; i < categoryButtons.size(); i++) {
            categoryButtons.get(i).setText(categoryNames.get(i));
        }

        categoryGrid = findViewById(R.id.categoryGrid);
    }

    /**
     * Sets background color on category buttons based on pressed or not
     * @param v View
     * @param i int
     */
    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void changeButtonsColor(View v, int i) {
        Toast.makeText(ChooseCategoryActivity.this, "clicked at index" + i, Toast.LENGTH_SHORT).show();
        final Button buttonView = (Button) categoryGrid.getChildAt(i);
        if (buttonActive(i)) {
            buttonView.setBackgroundColor(unActiveBackgroundColor);

        } else if (!buttonActive(i)) {
            buttonView.setBackgroundColor(activeBackgroundColor);

        }
    }

    public boolean buttonActive(int index) {
        return getCtrl().buttonActive(index);
    }

    /**
     * Takes the user to the next page which is the DurationActivity
     * @param view
     */
    public void nextToDurationPage(View view) {
        if (getCtrl().atLeastOneCategoryChosen()) {
            startActivity(new Intent(ChooseCategoryActivity.this, DurationActivity.class));
        } else {
            System.out.println("No category is chosen");
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void category1(View view) {
        changeButtonsColor(view, 0);
        getCtrl().chooseCategory(categoryNames.get(0));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category2(View view) {
        changeButtonsColor(view, 1);
        getCtrl().chooseCategory(categoryNames.get(1));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category3(View view) {
        changeButtonsColor(view, 2);
        getCtrl().chooseCategory(categoryNames.get(2));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category4(View view) {
        changeButtonsColor(view, 3);
        getCtrl().chooseCategory(categoryNames.get(3));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category5(View view) {
        changeButtonsColor(view, 4);
        getCtrl().chooseCategory(categoryNames.get(4));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category6(View view) {
        changeButtonsColor(view, 5);
        getCtrl().chooseCategory(categoryNames.get(5));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category7(View view) {
        changeButtonsColor(view, 6);
        getCtrl().chooseCategory(categoryNames.get(6));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category8(View view) {
        changeButtonsColor(view, 7);
        getCtrl().chooseCategory(categoryNames.get(7));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void category9(View view) {
        changeButtonsColor(view, 8);
        getCtrl().chooseCategory(categoryNames.get(8));
    }

}
