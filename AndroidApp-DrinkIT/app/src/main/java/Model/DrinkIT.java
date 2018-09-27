package Model;

import java.util.ArrayList;
import java.util.List;

public class DrinkIT {
    private List<Player> players;
    private List<Card> cards;
    private List<Challenge> challenges;
    private int duration;
    //TODO alice list
    private List<Category> categories;

    public DrinkIT(List<Player> players, List<Card> cards, List<Challenge> challenges, int duration) {
        this.players = players;
        this.cards = cards;
        this.challenges = challenges;
        this.duration = duration;
    }
    public DrinkIT(List<Player> players, List<Card> cards, List<Challenge> challenges) {
        this.players = players;
        this.cards = cards;
        this.challenges = challenges;
    }

    public DrinkIT(List<Player> players) {
        this.players = players;
    }


    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void setDuration(List<Player> players, int duration){
        System.out.println("Knappen för vald tid är tryck och antalet spelare multipliceras med "+ duration);
        duration = players.size()*duration;
    }

    //medtod för test
    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        for (Player p : players) {
            names.add(p.getName());
        }

        return names;
    }

    //TODO alice made method
    public void addCategory(String category){
        //if selected put the category in this list.
        categories.add(new Category(category));



}




}
