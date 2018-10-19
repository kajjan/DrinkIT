package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ChallengeWithPointActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_with_point);
        getCtrl().getCompleteListOfPlayersNames();

        printPlayersName();
        printChallenge();
        printCategory();
        printChallengePoints();
    }

    private void printChallengePoints() {
        TextView text=((TextView)findViewById(R.id.challengePoints));
        text.setText(getCtrl().getActiveChallengePoints() + " Points");
    }

    private void printCategory() {
        TextView text=((TextView)findViewById(R.id.challengeCategory));
        text.setText(getCtrl().getActiveCategory());
    }

    //print the name of the player on the challenge card
    public void printPlayersName(){
        TextView text=((TextView)findViewById(R.id.playerOfchallenge));
        text.setText(getCtrl().getPlayersName());
    }

    public void printChallenge(){
        TextView text=((TextView)findViewById(R.id.challengeText));
        text.setText(getCtrl().getActiveChallengeToPlay());
    }


    public void failChallenge(View view) {
        getCtrl().failedChallenge();
        if(nextRound()) {
            String nextCategory = getCtrl().getNextCategory();
            startNextActivity(nextCategory);
        }
        else{
            toFinishPage(view);
        }

    }

    public void succeededChallenge(View view) {
        getCtrl().succeededChallenge();
        if(nextRound()) {
            String nextCategory = getCtrl().getNextCategory();
            startNextActivity(nextCategory);
        }
        else{
            toFinishPage(view);
        }

    }


    public void toFinishPage(View view) {
        startActivity(new Intent(ChallengeWithPointActivity.this, FinishPageActivity.class));
    }

    public boolean nextRound(){
        return getCtrl().nextRound();
        }

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeWithPointActivity.this, ChallengeInstructionActivity.class));
    }

    public void optionsDuringGamePage(View view) {
        startActivity(new Intent(ChallengeWithPointActivity.this, OptionsDuringGameActivity.class));
    }

    public void startNextActivity(String category){
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades") ){
            //Dubbelvy med poäng
            startActivity(new Intent(ChallengeWithPointActivity.this, ChallengeWithAnswerPageOneActivity.class));
        }
        else if(category.equals("Truth or Dare")){
            //Enkelvy med poäng
            startActivity(new Intent(ChallengeWithPointActivity.this, TruthOrDarePageActivity.class));
        }
        else if(category.equals("Most Likely To") || category.equals("Rules")  || category.equals("Never Have I Ever") || category.equals("Themes") || category.equals("This or That") )
            //en vy utan poäng (ingen spelar)
            startActivity(new Intent(ChallengeWithPointActivity.this, ChallengeWithoutPointActivity .class));
        else{
            System.out.println("Something is wrong with the code in DurationActivity...");
        }

    }
}
