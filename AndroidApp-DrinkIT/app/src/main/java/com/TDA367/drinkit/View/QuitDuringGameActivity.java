package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

/**
 * This activity handles the option to quit the game midgame
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class QuitDuringGameActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quit_during_game);
    }

    /**
     * Method which exits the OptionQuitPage
     * @param view View
     */
    public void exitOptionQuitPage(View view) {
        finish();
    }

    /**
     * Method which starts the new activity FinishPageActivty
     * @param view View
     */
    public void quitGame(View view) { startActivity(new Intent(QuitDuringGameActivity.this, FinishPageActivity.class)); }

}
