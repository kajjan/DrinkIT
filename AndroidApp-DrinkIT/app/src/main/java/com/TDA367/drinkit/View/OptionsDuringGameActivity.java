package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import java.util.List;

public class OptionsDuringGameActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_during_game);
    }

    public void exitOptionsPage(View view) {
        String currentPlayer = getCtrl().getPlayersName();
        List<String> playerNames = getCtrl().getAllPlayerNames();
        String category;

        if (playerNames.contains(currentPlayer)) {
            category = getCtrl().getCurrentCategory();

        } else {
            category = getCtrl().getNextCategory();
        }

        startNextActivity(category);
    }

    public void addNewPlayerDuringGame(View view) {
        startActivity(new Intent(OptionsDuringGameActivity.this, AddPlayerDuringGameActivity.class));
    }

    public void removeExistingPlayerDuringGame(View view) {
        startActivity(new Intent(OptionsDuringGameActivity.this, RemovePlayerDuringGamePageOneActivity.class));
    }

    public void quitDuringGame(View view) {
        startActivity(new Intent(OptionsDuringGameActivity.this, QuitDuringGameActivity.class));
    }

    public void resumeGame(View view) {
        exitOptionsPage(view);
    }

    public void startNextActivity(String category){
        if (category.equals("quiz") || category.equals("songs") || category.equals("charades") ){
            //Dubbelvy med poäng
            startActivity(new Intent(OptionsDuringGameActivity.this, ChallengeWithAnswerPageOneActivity.class));
        }
        else if(category.equals("truthOrDare")){
            //Enkelvy med poäng
            startActivity(new Intent(OptionsDuringGameActivity.this, ChallengeWithPointActivity.class));
        }
        else if(category.equals("mostLikelyTo") || category.equals("rules")  || category.equals("neverHaveIEver") || category.equals("themes") || category.equals("thisOrThat") )
            //en vy utan poäng (ingen spelar)
            startActivity(new Intent(OptionsDuringGameActivity.this, ChallengeWithoutPointActivity .class));
        else{
            System.out.println("Something is wrong with the code in DurationActivity...");
        }

    }

}
