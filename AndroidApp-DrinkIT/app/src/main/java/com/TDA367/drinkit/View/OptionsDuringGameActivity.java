package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class OptionsDuringGameActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_during_game);
    }

    public void exitOptionsPage(View view) {        //player and category can be the same as earlier, but we haven't yet solved so it's the same challenge
        String currentPlayer = getCtrl().getNameOfPlayer();
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
        startActivity(new Intent(OptionsDuringGameActivity.this, ChallengeView1.class));
    }

}
