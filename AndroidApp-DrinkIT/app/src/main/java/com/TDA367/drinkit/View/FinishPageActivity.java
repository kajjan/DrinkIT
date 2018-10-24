package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/** Activity which handles the finishPage
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class FinishPageActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_page);

        printScoreBoard();
    }

    /**
     * Prints the scoreBoard
     */
    public void printScoreBoard(){
        TextView text=((TextView)findViewById(R.id.printScoreBoard));
        text.setText(getCtrl().getScoreBoard());
    }

    //TODO continue implement this method
    public void continueTheGame(View view) {

    }

    /**
     * onClick method which ends the game
     * @param view View
     */
    public void endTheGameButton(View view) {
        getCtrl().endTheGame();
        startActivity(new Intent(FinishPageActivity.this, StartPageActivity.class));


    }


}
