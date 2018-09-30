package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.DrinkIT;
import Model.Player;

public class Controller {
    DrinkIT model = new DrinkIT();
    static List<Player> listOfPlayers = new ArrayList<>();


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


    public String getPlayersName(){
        String name= model.getNameOfPlayer(listOfPlayers, model.getIndexForChallenge());
        return name;
    }
}



