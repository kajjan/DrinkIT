package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Activity which handles chosen duration input from user
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class DurationActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duration);
    }

    /**
     * If the chosen duration is "short" the duration sets to 3
     *
     * @param view View
     */
    public void shortDuration(View view) {
        getCtrl().setDuration(3);
        getCtrl().initiateGame();
        String nextCategory = getCtrl().getNextCategory();
        startNextActivity(nextCategory);
    }

    /**
     * If the chosen duration is "medium" the duration sets to 5
     *
     * @param view View
     */
    public void mediumDuration(View view) {
        getCtrl().setDuration(5);
        getCtrl().initiateGame();
        String nextCategory = getCtrl().getNextCategory();
        startNextActivity(nextCategory);
    }

    /**
     * If the chosen duration is "long" the duration sets to 10
     *
     * @param view View
     */
    public void longDuration(View view) {
        getCtrl().setDuration(10);
        getCtrl().initiateGame();
        String nextCategory = getCtrl().getNextCategory();
        startNextActivity(nextCategory);
    }

    /**
     * Start next activity based on chosen shuffled Categories
     *
     * @param category Category
     */
    public void startNextActivity(String category) {
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades")) {
            startActivity(new Intent(DurationActivity.this, ChallengePageOne.class));
        } else if (category.equals("Truth or Dare")) {
            startActivity(new Intent(DurationActivity.this, ChallengePageOne.class));
        } else if (category.equals("Most Likely To") || category.equals("Rules") || category.equals("Never Have I Ever") || category.equals("Themes") || category.equals("This or That"))
            startActivity(new Intent(DurationActivity.this, ChallengePageOne.class));
        else {
            System.out.println("Something is wrong with the code in DurationActivity...");
        }

    }


}

