package com.example.drinkit.drinkit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class AddPlayerActivity extends MainView implements TextWatcher {


    EditText playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight, playerNine, playerTen;
    List<String> players = new ArrayList<>(10);
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);


        playerOne = (EditText) findViewById(R.id.player1);
        playerTwo = (EditText) findViewById(R.id.player2);
        playerThree = (EditText) findViewById(R.id.player3);
        playerFour = (EditText) findViewById(R.id.player4);
        playerFive = (EditText) findViewById(R.id.player5);
        playerSix = (EditText) findViewById(R.id.player6);
        playerSeven = (EditText) findViewById(R.id.player7);
        playerEight = (EditText) findViewById(R.id.player8);
        playerNine = (EditText) findViewById(R.id.player9);
        playerTen = (EditText) findViewById(R.id.player10);

        playerOne.addTextChangedListener(this);
        playerTwo.addTextChangedListener(this);
        playerThree.addTextChangedListener(this);
        playerFour.addTextChangedListener(this);
        playerFive.addTextChangedListener(this);
        playerSix.addTextChangedListener(this);
        playerSeven.addTextChangedListener(this);
        playerEight.addTextChangedListener(this);
        playerNine.addTextChangedListener(this);
        playerTen.addTextChangedListener(this);

        playerTwo.setVisibility(playerTwo.INVISIBLE);
        playerThree.setVisibility(playerThree.INVISIBLE);
        playerFour.setVisibility(playerFour.INVISIBLE);
        playerFive.setVisibility(playerFive.INVISIBLE);
        playerSix.setVisibility(playerSix.INVISIBLE);
        playerSeven.setVisibility(playerSeven.INVISIBLE);
        playerEight.setVisibility(playerEight.INVISIBLE);
        playerNine.setVisibility(playerNine.INVISIBLE);
        playerTen.setVisibility(playerTen.INVISIBLE);

    }


    public void namesSubmitClick(View view) { //Method that saves all of the players and send it to the controller
        players.clear();
        int numberOfNamesAdded = 0;
        int numberOfSameNamesAdded = 0;

        players.add(playerOne.getText().toString().trim());
        players.add(playerTwo.getText().toString().trim());
        players.add(playerThree.getText().toString().trim());
        players.add(playerFour.getText().toString().trim());
        players.add(playerFive.getText().toString().trim());
        players.add(playerSix.getText().toString().trim());
        players.add(playerSeven.getText().toString().trim());
        players.add(playerEight.getText().toString().trim());
        players.add(playerNine.getText().toString().trim());
        players.add(playerTen.getText().toString().trim());

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isEmpty()) {
            } else if (sameName(i)) {
                numberOfSameNamesAdded++;
            } else {
                getCtrl().addPlayer(players.get(i));
                numberOfNamesAdded++;
            }
        }


        if (numberOfNamesAdded < 2) {
            atLeastTwoPlayersErrorMessage();
        } else if (numberOfSameNamesAdded > 0) {

        } else {
            startActivity(new Intent(AddPlayerActivity.this, ChooseCategoryActivity.class));
        }
    }


    public void atLeastTwoPlayersErrorMessage() {
        playerTwo.setError("At least two people must be added");
    }


    public boolean sameName(int i) { //Method that checks if player already exists in list
        int numberOfTimes = 0;
        for (String name : players) {
            if (name.equals(players.get(i))) {
                numberOfTimes++;

            }
            if (numberOfTimes > 1) {
                return true;
            }
        }
        return false;
    }


    public int sameName(String name) {
        int numberOfTimes = 0;
        for (int i = 0; i < players.size(); i++) {
            if (name.equals(players.get(i))) {
                numberOfTimes++;
            }
        }
        return numberOfTimes;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(this, "before changes", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this, "during chances", Toast.LENGTH_SHORT).show();



    }

    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(this, "after changes", Toast.LENGTH_SHORT).show();
        String name = s.toString().trim();

        if (playerOne.getText().hashCode() == s.hashCode()) {
            name = playerOne.getText().toString().trim();

           if (sameName(name) > 1) {
                playerOne.setError("Can't type in same name twice");
            } else {
                players.add(name);
                playerTwo.setVisibility(playerTwo.VISIBLE);
                playerTwo.setFocusable(true);
                playerTwo.moveCursorToVisibleOffset();
                playerTwo.setHint("Player 2");

            }
        }


        if (playerTwo.getText().hashCode() == s.hashCode()) {
            name = playerTwo.getText().toString().trim();

            if (sameName(name) > 1) {
                playerTwo.setError("Can't type in same name twice");
            } else {
                players.add(name);
                playerThree.setVisibility(playerThree.VISIBLE);
                playerThree.setFocusable(true);
                playerThree.moveCursorToVisibleOffset();
                playerThree.setHint("Player 3");
            }
        }


        if (playerThree.getText().hashCode() == s.hashCode()) {
            name = playerThree.getText().toString().trim();


            if (sameName(name) > 1) {
                playerThree.setError("Can't type in same name twice");
            } else {
                players.add(name);
                playerFour.setVisibility(playerFour.VISIBLE);
                playerFour.setFocusable(true);
                playerFour.moveCursorToVisibleOffset();
                playerFour.setFocusableInTouchMode(true);
                playerFour.setHint("Player 4");

            }
        }


        if (playerFour.getText().hashCode() == s.hashCode()) {
            name = playerFour.getText().toString().trim();


            if (sameName(name) > 1) {
                playerFour.setError("Can't type in same name twice");
            } else {
                players.add(name);
                playerFive.setVisibility(playerFive.VISIBLE);
                playerFive.setFocusable(true);
                playerFive.moveCursorToVisibleOffset();
                playerFive.setFocusableInTouchMode(true);
                playerFive.setHint("Player 5");

            }

        }


        if (playerFive.getText().hashCode() == s.hashCode()) {
            name = playerFive.getText().toString().trim();

            if (sameName(name) > 1) {
                playerFive.setError("Can't type in same name twice");
            } else {
                players.add(name);
                playerSix.setVisibility(playerSix.VISIBLE);
                playerSix.setFocusable(true);
                playerSix.moveCursorToVisibleOffset();
                playerSix.setFocusableInTouchMode(true);
                playerSix.setHint("Player 6");

            }
        }


        if (playerSix.getText().hashCode() == s.hashCode()) {
            name = playerSix.getText().toString().trim();

            if (sameName(name) > 1) {
                playerSix.setError("Can't type in same name twice");
            } else {
                players.add(name);
                playerSeven.setVisibility(playerSeven.VISIBLE);
                playerSeven.setFocusable(true);
                playerSeven.moveCursorToVisibleOffset();
                playerSeven.setFocusableInTouchMode(true);
                playerSeven.setHint("Player 7");

            }
        }


        if (playerSeven.getText().hashCode() == s.hashCode()) {
            name = playerSeven.getText().toString().trim();

            if (sameName(name) > 1) {
                playerSeven.setError("Can't type in same name twice");
            } else {
                players.add(name);
                playerEight.setVisibility(playerEight.VISIBLE);
                playerEight.setFocusable(true);
                playerEight.moveCursorToVisibleOffset();
                playerEight.setFocusableInTouchMode(true);
                playerEight.setHint("Player 8");

            }
        }


        if (playerEight.getText().hashCode() == s.hashCode()) {
            name = playerEight.getText().toString().trim();

            if (sameName(name) > 1) {
                playerEight.setError("Can't type in same name twice");
            } else {
                players.add(name);
                playerNine.setVisibility(playerNine.VISIBLE);
                playerNine.setFocusable(true);
                playerNine.moveCursorToVisibleOffset();
                playerNine.setFocusableInTouchMode(true);
                playerNine.setHint("Player 9");

            }
        }


        if (playerNine.getText().hashCode() == s.hashCode()) {
            name = playerNine.getText().toString().trim();

            if (sameName(name) > 1) {
                playerNine.setError("Can't type in same name twice");
            } else {
                players.add(name);
                playerTen.setVisibility(playerTen.VISIBLE);
                playerTen.setFocusable(true);
                playerTen.moveCursorToVisibleOffset();
                playerTen.setFocusableInTouchMode(true);
                playerTen.setHint("Player 10");
            }
        }


        if (playerTen.getText().hashCode() == s.hashCode()) {
            name = playerTen.getText().toString().trim();

            if (sameName(name) > 1) {
                playerTen.setError("Can't type in same name twice");
            } else {
                players.add(name);
            }
        }

    }
}