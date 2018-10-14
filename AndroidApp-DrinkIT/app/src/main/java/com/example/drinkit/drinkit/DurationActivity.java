package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Model.ChallengeWithAnswer;
import Model.ChallengeWithPoints;
import Model.ChallengeWithoutPoint;


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
    }

    public void mediumDuration(View view) {
        getCtrl().setDuration(5);
        String nextCategory = getCtrl().getNextCategory();
        startNextActivity(nextCategory);
    }

    public void longDuration(View view) {
        getCtrl().setDuration(10);
        String nextCategory = getCtrl().getNextCategory();
        startNextActivity(nextCategory);
    }

    public void startNextActivity(String category){
        if (category.equals("quiz") || category.equals("song") || category.equals("charades") ){
            //Dubbelvy med poäng
            startActivity(new Intent(DurationActivity.this, ChallengeWithAnswerActivity.class));
        }
        else if(category.equals("truthOrDare")){
            //Enkelvy med poäng
            startActivity(new Intent(DurationActivity.this, ChallengeWithPointActivity.class));
        }
        else if(category.equals("mostLikelyTo") || category.equals("rules")  || category.equals("neverHaveIEver") || category.equals("theme") || category.equals("thisOrThat") )
            //en vy utan poäng (ingen spelar)
        startActivity(new Intent(DurationActivity.this, ChallengeWithoutPointActivity .class));
        else{
            System.out.println("Something is wrong with the code in DurationActivity...");
        }

    }


}

