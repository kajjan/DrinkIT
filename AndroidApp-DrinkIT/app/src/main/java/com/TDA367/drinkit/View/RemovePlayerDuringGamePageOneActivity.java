package com.TDA367.drinkit.View;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RemovePlayerDuringGamePageOneActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_player_during_game_page_one);

        List<String> playerNames = new ArrayList<>(10);
        playerNames = getCtrl().getAllPlayerNames();

        List <Button> buttons = new ArrayList<>();

        Button btn1 = findViewById(R.id.playerOneButton);
        Button btn2 = findViewById(R.id.playerTwoButton);
        Button btn3 = findViewById(R.id.playerThreeButton);
        Button btn4 = findViewById(R.id.playerFourButton);
        Button btn5 = findViewById(R.id.playerFiveButton);
        Button btn6 = findViewById(R.id.playerSixButton);
        Button btn7 = findViewById(R.id.playerSevenButton);
        Button btn8 = findViewById(R.id.playerEightButton);
        Button btn9 = findViewById(R.id.playerNineButton);
        Button btn10 = findViewById(R.id.playerTenButton);

        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);
        buttons.add(btn7);
        buttons.add(btn8);
        buttons.add(btn9);
        buttons.add(btn10);

        for (int i=0; i<buttons.size(); i++) {
            if (i<playerNames.size()) {
                buttons.get(i).setText(playerNames.get(i));
            } else {
                buttons.get(i).setText("no player at this index");
            }
        }

    }

    public void exitOptionRemovePlayerPage(View view) {

    }

}
