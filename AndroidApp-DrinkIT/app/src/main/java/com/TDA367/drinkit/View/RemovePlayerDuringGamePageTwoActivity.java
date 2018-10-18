package com.TDA367.drinkit.View;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class RemovePlayerDuringGamePageTwoActivity extends MainView {

    TextView questionForRemove = (TextView)findViewById(R.id.removePlayerText);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_player_during_game_page_two);
        String playerName = (String) getIntent().getStringExtra("PLAYER_NAME");

        questionForRemove.setText("Are you sure you want to remove player " + playerName + " from the game?");
    }


    public void exitOptionRemovePlayerPage(View view) {
        finish();
    }

    public void removePlayer(View view) {

    }



}
