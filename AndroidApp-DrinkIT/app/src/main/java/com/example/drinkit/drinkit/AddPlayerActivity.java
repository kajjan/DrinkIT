package com.example.drinkit.drinkit;

import android.content.Context;
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

    Controller ctrl;


    EditText playerOne;
    List<EditText> players = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        playerOne = (EditText) findViewById(R.id.player1);


    }



    public void nextToCategoryPage(View view) {
        //Get to the next page, categoryPage. Make it impossible to go to the next page if there is less than 3 players.
    }


    public void namesSubmitClick(View view) {
        //Method that saves all the names in the textfields of players
        //Typ adda i controllern

        System.out.println(playerOne.getText().toString());


        //for (int i = 0; i < players.size(); i++) {
            //kollar igenom listan av spelare och OM det är ifyllt ska det skickas till controller.
        //}


    }
}
