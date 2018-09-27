package com.example.drinkit.drinkit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

import Controller.Controller;

public class AddPlayerActivity extends AppCompatActivity {

    Controller ctrl = new Controller();

    EditText playerOne, playerTwo, playerThree;
    List<String> players = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
    }

    public void nextToCategoryPage(View view) {
        startActivity(new Intent(AddPlayerActivity.this, ChooseCategoryActivity.class));
    }


    public void namesSubmitClick(View view) { //Method that saves all of the players and send it to the controller
        players.clear();

        playerOne = (EditText) findViewById(R.id.player1);
        playerTwo = (EditText) findViewById(R.id.player2);
        playerThree = (EditText) findViewById(R.id.player3);

        players.add(playerOne.getText().toString());
        players.add(playerTwo.getText().toString());
        players.add(playerThree.getText().toString());

        for (int i = 0; i <players.size() ; i++) {
            if (players.get(i).isEmpty()){
                System.out.println("Nothing in this place of index"); //We dont need this later on, just for now
            }
            else{
                System.out.println(players.get(i));
                if (sameName(players, players.get(i))){
                    //Error message
                    System.out.println("Type in names again");
                    return;
                }
                else{
                    ctrl.addPlayer(players.get(i));
                }
            }
        }
    }

    public boolean sameName(List<String> players, String player){ //Method that checks if player already exists in list
        for (String name: players) {
            if(name.equals(player)){
                return true;
            }
        }
        return false;
    }
}
