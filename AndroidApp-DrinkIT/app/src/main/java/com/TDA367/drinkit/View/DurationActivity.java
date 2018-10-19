package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class DurationActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duration);
    }


    public void shortDuration(View view) {
        getCtrl().setDuration(3);
        String nextCategory = getCtrl().getNextCategory();
        startNextActivity(nextCategory);
        getCtrl().createCompleteListOfPlayers();
    }

    public void mediumDuration(View view) {
        getCtrl().setDuration(5);
        String nextCategory = getCtrl().getNextCategory();
        startNextActivity(nextCategory);
        getCtrl().createCompleteListOfPlayers();
    }

    public void longDuration(View view) {
        getCtrl().setDuration(10);
        String nextCategory = getCtrl().getNextCategory();
        startNextActivity(nextCategory);
        getCtrl().createCompleteListOfPlayers();
    }

    public void startNextActivity(String category){
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades") ){
            //Dubbelvy med poäng
            startActivity(new Intent(DurationActivity.this, ChallengeWithAnswerPageOneActivity.class));
        }
        else if(category.equals("Truth or Dare")){
            //Enkelvy med poäng
            startActivity(new Intent(DurationActivity.this, TruthOrDarePageActivity.class));
        }
        else if(category.equals("Most Likely To") || category.equals("Rules")  || category.equals("Never Have I Ever") || category.equals("Themes") || category.equals("This or That") )
            //en vy utan poäng (ingen spelar)
        startActivity(new Intent(DurationActivity.this, ChallengeWithoutPointActivity .class));
        else{
            System.out.println("Something is wrong with the code in DurationActivity...");
        }

    }


}

