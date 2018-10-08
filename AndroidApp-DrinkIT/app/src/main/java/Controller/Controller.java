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
        model.setDuration(listOfPlayers, duration); //skicka bara med antal, skriv en get för size som returnerar en int
    }

    public int getDuration(){
        return model.getDurationOfGame(); //se ovan
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


    public String putInPointOrder(){
        String scoreBoard=model.putListInPointOrder();
        return scoreBoard;
    }

    public boolean nextRound(){
        return model.nextRound();
    }

    public void endTheGame(){
        model.endTheGame();
    }


}
