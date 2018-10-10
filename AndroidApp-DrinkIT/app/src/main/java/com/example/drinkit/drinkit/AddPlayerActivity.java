package com.example.drinkit.drinkit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;



public class AddPlayerActivity extends MainView {

    EditText playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight, playerNine, playerTen;
    List<String> players = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
    }


    public void namesSubmitClick(View view) { //Method that saves all of the players and send it to the controller
        players.clear();

        playerOne = (EditText) findViewById(R.id.player1);
        playerTwo = (EditText) findViewById(R.id.player2);
        playerThree = (EditText) findViewById(R.id.player3);
        playerFour = (EditText) findViewById(R.id.player4);
        playerFive = (EditText) findViewById(R.id.player5);
        playerSix = (EditText) findViewById(R.id.player6);
        playerSeven = (EditText) findViewById(R.id.player7);
        playerEight = (EditText) findViewById(R.id.player8);
        playerNine= (EditText) findViewById(R.id.player9);
        playerTen = (EditText) findViewById(R.id.player10);

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

        int numberOfSameNames=0;
        int numberOfNamesAdded=0;

         for (int i = 0; i <players.size() ; i++) {
            if (players.get(i).isEmpty()){
                System.out.println("Nothing in this place of index"); //We dont need this later on, just for now
            }
            else{
                System.out.println(players.get(i));
                if (sameName(players, players.get(i),i)){
                    System.out.println("Type in names again");
                    numberOfSameNames++;

                }
                else{
                    getCtrl().addPlayer(players.get(i));
                    }
                numberOfNamesAdded++;

            }

            }
            if(numberOfNamesAdded<=1){
             atLeastTwoPlayersErrorMessage();
            }
            if(numberOfSameNames<1 & numberOfNamesAdded>1) {
                startActivity(new Intent(AddPlayerActivity.this, ChooseCategoryActivity.class));
            }

        }






    //Kan denna ersätts av en .contains??
    public boolean sameName(List<String> players, String player, int index) { //Method that checks if player already exists in list
        int numberOfTimes = 0;
        int i=0;
        for (String name : players) {
                if(name.equals(player)){
                    printErrorIfSameName(i, index);
                    numberOfTimes++;
                }

                if (numberOfTimes > 1) {
                    return true;
                }
                i++;
            }
        return false;

    }


//A method that send an error message too the textfield that has the same input as an other.
    public void printErrorIfSameName(int i, int index){

        if(i!=index) {
            if (index == 0 | i == 0) {
                playerOne.setError("Can't type in same name twice");
            }
            if (index == 1 | i == 1) {
                playerTwo.setError("Can't type in same name twice");
            }
            if (index == 2 | i == 2) {
                playerThree.setError("Can't type in same name twice");
            }
            if (index == 3 | i == 3) {
                playerFour.setError("Can't type in same name twice");
            }
            if (index == 4 | i == 4) {
                playerFive.setError("Can't type in same name twice");
            }
            if (index == 5 | i == 5) {
                playerSix.setError("Can't type in same name twice");
            }
            if (index == 6 | i == 6) {
                playerSeven.setError("Can't type in same name twice");
            }
            if (index == 7 | i == 7) {
                playerEight.setError("Can't type in same name twice");
            }
            if (index == 8 | i == 8) {
                playerNine.setError("Can't type in same name twice");
            }
            if (index == 9 | i == 9) {
                playerTen.setError("Can't type in same name twice");
            }
        }

    }

//A method that sends error messages than two players.
   public void atLeastTwoPlayersErrorMessage(){
       playerOne.setError("Need too at least add two players");
       playerTwo.setError("Need too at least add two players");
       playerThree.setError("Need too at least add two players");
       playerFour.setError("Need too at least add two players");
       playerFive.setError("Need too at least add two players");
       playerSix.setError("Need too at least add two players");
       playerSeven.setError("Need too at least add two players");
       playerEight.setError("Need too at least add two players");
       playerNine.setError("Need too at least add two players");
       playerTen.setError("Need too at least add two players");
   }

}





