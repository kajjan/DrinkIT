package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RemovePlayerDuringGamePageOneActivity extends MainView {

    List<String> playerNames = new ArrayList<>(10);
    List <Button> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_player_during_game_page_one);

        playerNames = getCtrl().getAllPlayerNames();

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
                buttons.get(i).setVisibility(View.INVISIBLE);
                //buttons.get(i).setText("no player at this index");
            }
        }

    }

    public void exitOptionRemovePlayerPage(View view) {
        finish();
        //startActivity(new Intent(RemovePlayerDuringGamePageOneActivity.this, OptionsDuringGameActivity.class));
    }

    public void playerOneSelected(View view) {
        Intent intent = new Intent(RemovePlayerDuringGamePageOneActivity.this, RemovePlayerDuringGamePageTwoActivity.class);
        intent.putExtra("PLAYER_NAME", buttons.get(0).getText());

        System.out.println(buttons.get(0).getText());

        startActivity(intent);
    }

    public void playerTwoSelected(View view) {
        Intent intent = new Intent(RemovePlayerDuringGamePageOneActivity.this, RemovePlayerDuringGamePageTwoActivity.class);
        intent.putExtra("PLAYER_NAME", buttons.get(1).getText());

        System.out.println(buttons.get(1).getText());

        startActivity(intent);
    }

    public void playerThreeSelected(View view) {
        Intent intent = new Intent(RemovePlayerDuringGamePageOneActivity.this, RemovePlayerDuringGamePageTwoActivity.class);
        intent.putExtra("PLAYER_NAME", buttons.get(2).getText());

        System.out.println(buttons.get(2).getText());

        startActivity(intent);
    }

    public void playerFourSelected(View view) {
        Intent intent = new Intent(RemovePlayerDuringGamePageOneActivity.this, RemovePlayerDuringGamePageTwoActivity.class);
        intent.putExtra("PLAYER_NAME", buttons.get(3).getText());

        System.out.println(buttons.get(3).getText());

        startActivity(intent);
    }

    public void playerFiveSelected(View view) {
        Intent intent = new Intent(RemovePlayerDuringGamePageOneActivity.this, RemovePlayerDuringGamePageTwoActivity.class);
        intent.putExtra("PLAYER_NAME", buttons.get(4).getText());

        System.out.println(buttons.get(4).getText());

        startActivity(intent);
    }

    public void playerSixSelected(View view) {
        Intent intent = new Intent(RemovePlayerDuringGamePageOneActivity.this, RemovePlayerDuringGamePageTwoActivity.class);
        intent.putExtra("PLAYER_NAME", buttons.get(5).getText());

        System.out.println(buttons.get(5).getText());

        startActivity(intent);
    }

    public void playerSevenSelected(View view) {
        Intent intent = new Intent(RemovePlayerDuringGamePageOneActivity.this, RemovePlayerDuringGamePageTwoActivity.class);
        intent.putExtra("PLAYER_NAME", buttons.get(6).getText());

        System.out.println(buttons.get(6).getText());

        startActivity(intent);
    }

    public void playerEightSelected(View view) {
        Intent intent = new Intent(RemovePlayerDuringGamePageOneActivity.this, RemovePlayerDuringGamePageTwoActivity.class);
        intent.putExtra("PLAYER_NAME", buttons.get(7).getText());

        System.out.println(buttons.get(7).getText());

        startActivity(intent);
    }

    public void playerNineSelected(View view) {
        Intent intent = new Intent(RemovePlayerDuringGamePageOneActivity.this, RemovePlayerDuringGamePageTwoActivity.class);
        intent.putExtra("PLAYER_NAME", buttons.get(8).getText());

        System.out.println(buttons.get(8).getText());

        startActivity(intent);
    }

    public void playerTenSelected(View view) {
        Intent intent = new Intent(RemovePlayerDuringGamePageOneActivity.this, RemovePlayerDuringGamePageTwoActivity.class);
        intent.putExtra("PLAYER_NAME", buttons.get(9).getText());

        System.out.println(buttons.get(9).getText());

        startActivity(intent);
    }


}
