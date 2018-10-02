package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.DrinkIT;
import Model.Player;

public class Controller {
    //provisorisk sätter vi listan med players


    DrinkIT model = new DrinkIT();
    static List<Player> listOfPlayers = new ArrayList<>();

    public Controller() {

    }

    public Controller(List<Player> players, DrinkIT model) {
        this.listOfPlayers = players;
        this.model = model;

    }


    public void addPlayer(String player) {
        model.addPlayer(player);
        listOfPlayers = model.getPlayers();

    }

    public void setDuration(int duration){
        model.setDuration(listOfPlayers, duration);
    }
}



