package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;


public class QuitDuringGameActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quit_during_game);
    }

    public void exitOptionQuitPage(View view) {
        finish();
        //startActivity(new Intent(QuitDuringGameActivity.this, OptionsDuringGameActivity.class));
    }

    public void quitGame(View view) {
        startActivity(new Intent(QuitDuringGameActivity.this, FinishPageActivity.class));
    }

}
