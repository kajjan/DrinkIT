package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RemovePlayerDuringGamePageTwoActivity extends MainView {



    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_player_during_game_page_two);
        playerName = (String) getIntent().getStringExtra("PLAYER_NAME");

        TextView questionForRemove = (TextView)findViewById(R.id.removePlayerText);
        questionForRemove.setText("Are you sure you want to remove player " + playerName + " from the game?");
    }


    public void exitOptionRemovePlayerPage(View view) {
        finish();
    }

    public void removePlayer(View view) {
        getCtrl().removePlayerDuringGame(playerName);
        startActivity(new Intent(RemovePlayerDuringGamePageTwoActivity.this, OptionsDuringGameActivity.class));

    }



}
