package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.DrinkIT;
import Model.Player;

public class Controller {
    DrinkIT model = new DrinkIT();
    static List<Player> listOfPlayers = new ArrayList<>();
    static List<Player> completeListOfPlayers = new ArrayList<>();
    int roundOfChallenge = 0;



    //Constructors
    public Controller() {

    }

    public Controller(List<Player> players, DrinkIT model) {
        this.listOfPlayers = players;
        this.model = model;

    }


    //methods
    public void addPlayer(String player) {
        model.addPlayer(player);
        listOfPlayers = model.getPlayers();
    }


    public void setDuration(int duration){
        model.setDuration(listOfPlayers, duration);
    }

    public int getDuration(){
        return model.getDurationOfGame();
    }

    public String getPlayersName(){
        String name= model.getNameOfPlayer(completeListOfPlayers, roundOfChallenge);
        return name;
    }

    public void setCompleteListOfPlayers(){
        completeListOfPlayers = model.createCompletedPlayersList(listOfPlayers, getDuration());
        completeListOfPlayers = model.shufflePlayerList(completeListOfPlayers);
        System.out.println(completeListOfPlayers);
    }


    public void failedChallenge() {
        roundOfChallenge++;
    }


}



