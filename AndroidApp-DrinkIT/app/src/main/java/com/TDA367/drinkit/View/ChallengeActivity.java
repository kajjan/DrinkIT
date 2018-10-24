package com.TDA367.drinkit.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class ChallengeActivity extends MainView implements Decorator {

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_base);
        decorateNextActivity("Rules");
        printPlayersName();
        printCategory();
    }



    @Override
    public void decorate() {

    }

    public ChallengeActivity(){

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


    public void decorateNextActivity(String category) {
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades")) {
           // new ChallengeWithoutPointView(challengeTask,challengeNextButton);
            //kalla på svarssidan, vart???

            //startActivity(new Intent(.this, ChallengeWithAnswerPageOneActivity.class));
        }else if (category.equals("Truth or Dare")) {
         //   new ChallengeTruthOrDare(challengeTruthOrDare);

            //startActivity(new Intent(ChallengeWithAnswerPageTwoActivity.this, TruthOrDarePageActivity.class));
        }else if (category.equals("Most Likely To") || category.equals("Rules") || category.equals("Never Have I Ever") || category.equals("Themes") || category.equals("This or That")) {
                Decorator view1 = new NextButton(new ChallengeText(new ChallengeActivity()));
                view1.decorate();
        }else{
            System.out.println("Something is wrong with the code in ChallengeWithAnswerActivity..." + category);
        }
    }

    public void optionsDuringGamePage(View view) {
        startActivity(new Intent(ChallengeActivity.this, OptionsDuringGameActivity.class));

    }


}
