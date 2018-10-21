package com.TDA367.drinkit.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.TDA367.drinkit.Controller.Controller;


public class ChallengeActivity extends MainView {

    Context context;
    Controller controller=getCtrl();
    String nextCategory;
    Boolean hasButton=true;
    Boolean hasChallenge=true;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_base);
        View contentView = findViewById(R.id.challenge_base);
        nextCategory = getCtrl().getNextCategory();
        decorateNextActivity(nextCategory, contentView);
        printPlayersName();
        printCategory();
        }

        public ChallengeActivity(){
      //  this.recreate();
        }

    public void printPlayersName(){
        TextView text=((TextView)findViewById(R.id.playerOfChallenge));
        text.setText(getCtrl().getNameOfPlayer());
    }
    public void printCategory(){
        TextView text=((TextView)findViewById(R.id.challengeCategory));
        text.setText(getCtrl().getActiveCategory());
    }
    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeActivity.this, ChallengeInstructionActivity.class));
    }

    public void toAnswerPage(View view) {
    }

    public void truthButton(View view) {
    }

    public void dareButton(View view) {
    }


    public void failChallenge(View view) {
    }

    public void succeededChallenge(View view) {
    }



    public void decorateNextActivity(String category, View view) {
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades")) {
           // new ChallengeWithoutPointView(challengeTask,challengeNextButton);
            //kalla på svarssidan, vart???

            //startActivity(new Intent(.this, ChallengeWithAnswerPageOneActivity.class));
        }else if (category.equals("Truth or Dare")) {
         //   new ChallengeTruthOrDare(challengeTruthOrDare);

            //startActivity(new Intent(ChallengeWithAnswerPageTwoActivity.this, TruthOrDarePageActivity.class));
        }else if (category.equals("Most Likely To") || category.equals("Rules") || category.equals("Never Have I Ever") || category.equals("Themes") || category.equals("This or That")) {
            new ChallengeWithoutPointView(view,ChallengeActivity.this, controller, hasButton, hasChallenge);

        }else{
            System.out.println("Something is wrong with the code in ChallengeWithAnswerActivity..." + category);
        }
    }

    public void optionsDuringGamePage(View view) {
    }
}
