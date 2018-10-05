package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.DrinkIT;
import Model.Player;

public class Controller {
    DrinkIT model;
    static List<Player> listOfPlayers = new ArrayList<>();
    static List<Player> completeListOfPlayers = new ArrayList<>();
    int roundOfChallenge = 0;


    //Constructors

    public Controller() {

    }

    public Controller(DrinkIT model) {
        this.model = model;
    }

    /*
        public Controller(List<Player> players, DrinkIT model) {
            this.listOfPlayers = players;
            this.model = model;

        }
    */

    //methods
    public void addPlayer(String player) {
        model.addPlayer(player);
        listOfPlayers = model.getPlayers();
    }

    public boolean categoryListEmpty(){
        boolean b = false;
        if(model.getCategories().size()==0){
            b = true;
        }
        return b;
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
        model.createCompletedPlayersList(listOfPlayers, getDuration());
        completeListOfPlayers = model.getCompleteListOfPlayers();
        completeListOfPlayers = model.shufflePlayerList(completeListOfPlayers);
        System.out.println(completeListOfPlayers);
    }


    public void failedChallenge() {
        roundOfChallenge++;
    }

    public void succeedChallenge(){
        model.setPointOfPlayer(completeListOfPlayers, roundOfChallenge);

        roundOfChallenge++;
    }


    public void chooseCategory(String category) {
        model.chooseCategory(category);
    }



}
