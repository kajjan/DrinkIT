package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinishPageActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_page);

        printScoreBoard();
    }

    public void printScoreBoard(){
        TextView text=((TextView)findViewById(R.id.printScoreBoard));
        text.setText(getCtrl().getScoreBoard());
    }

    public void continueTheGame(View view) { //hur vill vi göra här? starta om på ifyllda namn


    }

    public void endTheGameButton(View view) {
        getCtrl().endTheGame();
        startActivity(new Intent(FinishPageActivity.this, StartPageActivity.class));


    }


}
