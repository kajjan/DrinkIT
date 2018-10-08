package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.DrinkIT;
import Model.Player;

public class Controller {
    DrinkIT model;
    static List<Player> listOfPlayers = new ArrayList<>(); //flytta till model ändra static


    //Constructors

    public Controller() {

    }

    public Controller(DrinkIT model) {
        this.model = model;
    }


    //methods
    public void addPlayer(String player) {
        model.addPlayer(player);
        listOfPlayers = model.getPlayers(); //Red flag, flytta till model och skaffa en get
    }

    public boolean categoryListEmpty(){ //ska ligga i modellen istället
        boolean b = false;
        if(model.getCategories().size()==0){
            b = true;
        }
        return b;
    }

    public void setDuration(int duration){
        model.setDuration(duration);
    }


    public String getPlayersName(){
            String name = model.getNameOfPlayer();
            return name;

    }

    public void setCompleteListOfPlayers(){
        model.createCompletedPlayersList();
    }


    public void failedChallenge() {
        model.failedChallenge();

    }

    public void succeedChallenge(){
        model.succeedChallenge();
    }


    public void chooseCategory(String category) { //ändra i samband med activiteten
        model.chooseCategory(category);
    }

    public String getScoreBoard(){
        model.putListInPointOrder();
        return model.getScoreBoardText();

    }

    public boolean nextRound(){
        return model.nextRound();
    }


    //just nu kan vi inte starta om spelet så allt funkar när jag tagit bort saker som är static... klurar på en lösning med det!!
    public void endTheGame(){
        model.endTheGame();
    }


}
