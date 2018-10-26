package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


/**
 * Activity which handles the task to Remove a player during game on page two of a challenge
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class RemovePlayerDuringGamePageTwoActivity extends MainView {

    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_player_during_game_page_two);
        playerName = (String) getIntent().getStringExtra("PLAYER_NAME");

        TextView questionForRemove = (TextView) findViewById(R.id.removePlayerText);
        questionForRemove.setText("Are you sure you want to remove player " + playerName + " from the game?");
    }

    /**
     * Exits the optionRemovePlayerPage
     *
     * @param view View
     */
    public void exitOptionRemovePlayerPage(View view) { startActivity(new Intent(RemovePlayerDuringGamePageTwoActivity.this, OptionsDuringGameActivity.class)); }

    /**
     * removes the chosen player and goes to the activity OptionsDuringGameActivity
     *
     * @param view
     */
    public void removePlayer(View view) { getCtrl().removePlayerDuringGame(playerName); startActivity(new Intent(RemovePlayerDuringGamePageTwoActivity.this, OptionsDuringGameActivity.class)); }

}
