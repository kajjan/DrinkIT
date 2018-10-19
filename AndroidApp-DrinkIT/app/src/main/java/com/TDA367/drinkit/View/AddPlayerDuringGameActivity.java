package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class AddPlayerDuringGameActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player_during_game);
    }

    public void exitOptionAddPlayerPage(View view) {
        finish();
        //startActivity(new Intent(AddPlayerDuringGameActivity.this, OptionsDuringGameActivity.class));
    }

    public void addPlayerToGame(View view) {

    }

}
