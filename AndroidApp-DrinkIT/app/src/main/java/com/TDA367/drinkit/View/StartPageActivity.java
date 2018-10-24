package com.TDA367.drinkit.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * This activity is the startpage of DrinkIT
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class StartPageActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
    }

    /**
     * onClick(), starts the activity AddPlayerActivity when the start game button is pressed
     *
     * @param view View
     */
    public void startGame(View view) { startActivity(new Intent(StartPageActivity.this, AddPlayerActivity.class)); }

    /**
     * onClick(), Starts the activity which shows the instructions, InstructionsActivity, when the
     * instructions button is pressed
     *
     * @param view View
     */
    public void instructions(View view) { startActivity(new Intent(StartPageActivity.this, InstructionsActivity.class)); }
}
