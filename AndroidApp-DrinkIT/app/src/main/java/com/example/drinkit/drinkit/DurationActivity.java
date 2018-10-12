package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
        if (category.equals("quiz") || category.equals("rules") || category.equals("song") || category.equals("charades") ){
            //Dubbelvy med poäng
        }
        else if(category.equals("truthOrDare")){
            //Enkelvy med poäng
        }
        else if(category.equals("mostLikelyTo") || category.equals("neverHaveIEver") || category.equals("theme") || category.equals("thisOrThat") )
            //en vy utan poäng (ingen spelar)
        startActivity(new Intent(DurationActivity.this, ChallengeActivity.class));
        else{
            System.out.println("Something is wrong with the code in DurationActivity...");
        }


    }


}

