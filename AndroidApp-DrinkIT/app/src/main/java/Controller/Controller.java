package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.DrinkIT;
import Model.Player;

public class Controller {
    DrinkIT model;
    static List<Player> listOfPlayers = new ArrayList<>(); //flytta till model ändra static
    static List<Player> completeListOfPlayers = new ArrayList<>(); //flytta till model rename?
    int roundOfChallenge = 0;


    //Constructors

    public Controller() {

    }

    public Controller(DrinkIT model) {
        this.model = model;
    }


    //methods
    public void setChallengeInstruction(String category, String catInstruction){
        model.createCategory(category, catInstruction);
    }

    public void setChallenge(String category, String challenge){
        model.setListOfChallenges(category, challenge);
    }
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

    public String getPlayersName(){ // samma som alla, ta inte in utan allt finns i modellen
            String name = model.getNameOfPlayer(completeListOfPlayers, roundOfChallenge);
            return name;

    }

    public void setCompleteListOfPlayers(){ //ta inte in något utan kalla på modelen som fixar detta i sjig själv.
        model.createCompletedPlayersList(listOfPlayers, getDuration());
        completeListOfPlayers = model.getCompleteListOfPlayers();
        completeListOfPlayers = model.shufflePlayerList(completeListOfPlayers);
        System.out.println(completeListOfPlayers);
    }


    public void failedChallenge() { //same
        roundOfChallenge++;
    }

    public void succeedChallenge(){ //same
        model.setPointOfPlayer(completeListOfPlayers, roundOfChallenge); //skicka inte med något, lös i model

        roundOfChallenge++;
    }


    public void chooseCategory(String category) { //ändra i samband med activiteten
        model.chooseCategory(category);
    }


    public String putInPointOrder(){
        String scoreBoard=model.putListInPointOrder(listOfPlayers); //same
        return scoreBoard;
    }

    public boolean nextRound(){
        return model.nextRound(roundOfChallenge); //same
    }

    public void endTheGame(){
        model.endTheGame();
    }


}
