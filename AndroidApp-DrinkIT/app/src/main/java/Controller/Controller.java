package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.DrinkIT;
import Model.Player;

public class Controller {
    //provisorisk sätter vi listan med players
    List<Player> players=new ArrayList<>(10);
    DrinkIT model = new DrinkIT(players);


    public Controller() {

    }

    public Controller(List<Player> players, DrinkIT model) {
        this.players = players;
        this.model = model;

    }


    public void setDuration(int duration){
        model.setDuration(players, duration);
    }
}


