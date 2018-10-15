package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChallengeWithAnswerPageTwoActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_with_answer_page_two);
        getCtrl().createCompleteListOfPlayers();

        printPlayersName();
        printAnswer();
    }

    public void printPlayersName(){
        TextView text=((TextView)findViewById(R.id.playerOfchallenge));
        text.setText(getCtrl().getPlayersName());
    }

    public void printAnswer(){
        TextView text=((TextView)findViewById(R.id.answerText));
        text.setText(getCtrl().getActiveChallengesAnswer());
        //text.setText("funkar detta?");
    }


    public void failChallenge(View view) {
        getCtrl().failedChallenge();
        if(nextRound()) {
            printPlayersName();
            printAnswer();
        }
        else{
            changePage(view);
            String nextCategory = getCtrl().getNextCategory();
            startNextActivity(nextCategory);
        }
    }

    public void succeededChallenge(View view) {
        getCtrl().succeededChallenge();
        if(nextRound()) {
            printPlayersName();
            printAnswer();
        }
        else{
            changePage(view);
            String nextCategory = getCtrl().getNextCategory();
            startNextActivity(nextCategory);
        }
    }

    public boolean nextRound(){
        return getCtrl().nextRound();
    }


    public void changePage(View view) {
        startActivity(new Intent(ChallengeWithAnswerPageTwoActivity.this, FinishPageActivity.class));
    }

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeWithAnswerPageTwoActivity.this, ChallengeInstructionActivity.class));
    }



    public void startNextActivity(String category){
        if (category.equals("quiz") || category.equals("song") || category.equals("charades") ){
            //Dubbelvy med poäng
            startActivity(new Intent(ChallengeWithAnswerPageTwoActivity.this, ChallengeWithAnswerPageOneActivity.class));
        }
        else if(category.equals("truthOrDare")){
            //Enkelvy med poäng
            startActivity(new Intent(ChallengeWithAnswerPageTwoActivity.this, ChallengeWithPointActivity.class));
        }
        else if(category.equals("mostLikelyTo") || category.equals("rules")  || category.equals("neverHaveIEver") || category.equals("theme") || category.equals("thisOrThat") )
            //en vy utan poäng (ingen spelar)
            startActivity(new Intent(ChallengeWithAnswerPageTwoActivity.this, ChallengeWithoutPointActivity .class));
        else{
            System.out.println("Something is wrong with the code in DurationActivity...");
        }

    }

}
