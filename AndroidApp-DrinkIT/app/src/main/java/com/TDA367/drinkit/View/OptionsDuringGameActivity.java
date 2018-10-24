package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

/**
 * This Activity handles the different options during the game
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class OptionsDuringGameActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_during_game);
    }


    public void exitOptionsPage(View view) {
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

    /**
     * Method which starts the new activity addPlayerDuringGameActivity
     *
     * @param view View
     */
    public void addNewPlayerDuringGame(View view) {
        startActivity(new Intent(OptionsDuringGameActivity.this, AddPlayerDuringGameActivity.class));
    }

    /**
     * Method starts the new Activity RemovePlayerDuringGamePageOneActivity
     *
     * @param view View
     *             Todo make it impossible to remove one player if there is only two players in the game.
     */

    public void removeExistingPlayerDuringGame(View view) {
        startActivity(new Intent(OptionsDuringGameActivity.this, RemovePlayerDuringGamePageOneActivity.class));
    }

    /**
     * Method to quit the game, starts new activity QuitDuringGameActivity
     *
     * @param view View
     */
    public void quitDuringGame(View view) {
        startActivity(new Intent(OptionsDuringGameActivity.this, QuitDuringGameActivity.class));
    }

    /**
     * Method to resume the game and exits optionsPage
     *
     * @param view
     */
    public void resumeGame(View view) {
        exitOptionsPage(view);
    }

    /**
     * Starts new activity based on next category
     *
     * @param category String
     */
    public void startNextActivity(String category) {
        startActivity(new Intent(OptionsDuringGameActivity.this, ChallengeView1.class));
    }

}
