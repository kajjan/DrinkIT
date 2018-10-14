package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Model.ChallengeWithAnswer;

public class ChallengeWithAnswerActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_with_answer);
    }

    public void startNextActivity(String category){
        if (category.equals("quiz") || category.equals("song") || category.equals("charades") ){
            //Dubbelvy med poäng
            startActivity(new Intent(ChallengeWithAnswerActivity.this, ChallengeWithAnswerActivity.class));
        }
        else if(category.equals("truthOrDare")){
            //Enkelvy med poäng
            startActivity(new Intent(ChallengeWithAnswerActivity.this, ChallengeWithPointActivity.class));
        }
        else if(category.equals("mostLikelyTo") || category.equals("rules")  || category.equals("neverHaveIEver") || category.equals("theme") || category.equals("thisOrThat") )
            //en vy utan poäng (ingen spelar)
            startActivity(new Intent(ChallengeWithAnswerActivity.this, ChallengeWithoutPointActivity .class));
        else{
            System.out.println("Something is wrong with the code in DurationActivity...");
        }

    }
}
