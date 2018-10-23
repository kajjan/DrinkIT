package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ChallengeWithoutPointActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_without_point);

        printPlayersName();
        printCategory();
        printChallenge();
    }


    public void printPlayersName(){
        TextView text=((TextView)findViewById(R.id.textViewPlayerChallengeWithoutPoint));
        text.setText(getCtrl().getNameOfPlayer());
    }

    public void printCategory(){
        TextView text=((TextView)findViewById(R.id.challengeCategory));
        text.setText(getCtrl().getActiveCategory());
    }

    public void printChallenge(){
        TextView text=((TextView)findViewById(R.id.textViewChallengeWithoutPoint));
        text.setText(getCtrl().getActiveChallenge());
    }

    public void nextButtonWithoutPoint(View view) {
        getCtrl().failedChallenge();
        if(nextRound()) {
            String nextCategory = getCtrl().getNextCategory();
            startNextActivity(nextCategory);
        }
        else{
            toFinishPage(view);
        }
    }

    public boolean nextRound(){
        return getCtrl().nextRound();
    }

    public void toFinishPage(View view) {
        startActivity(new Intent(ChallengeWithoutPointActivity.this, FinishPageActivity.class));
    }

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeWithoutPointActivity.this, ChallengeInstructionActivity.class));
    }

    public void optionsDuringGamePage(View view) {
        startActivity(new Intent(ChallengeWithoutPointActivity.this, OptionsDuringGameActivity.class));
    }

    public void startNextActivity(String category){
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades") ){
            //Dubbelvy med poäng
            startActivity(new Intent(ChallengeWithoutPointActivity.this, ChallengeWithAnswerPageOneActivity.class));
        }
        else if(category.equals("Truth or Dare")){
            //Enkelvy med poäng
            startActivity(new Intent(ChallengeWithoutPointActivity.this, TruthOrDarePageActivity.class));
        }
        else if(category.equals("Most Likely To") || category.equals("Rules")  || category.equals("Never Have I Ever") || category.equals("Themes") || category.equals("This or That") )
            //en vy utan poäng (ingen spelar)
            startActivity(new Intent(ChallengeWithoutPointActivity.this, ChallengeWithoutPointActivity .class));
        else{
            System.out.println("Something is wrong with the code in ChallengeWithoutPointActivity..." + category);
        }

    }

}


