package Model;

import java.util.ArrayList;
import java.util.List;

public class DrinkIT {
    private List<Player> players;
    private List<Card> cards;
    private List<Challenge> challenges;


    //TODO alice list
    private List<Category> categories = new ArrayList<>();
    private int durationOfGame;

    public DrinkIT(List<Player> players, List<Card> cards, List<Challenge> challenges, int durationOfGame) {
        this.players = players;
        this.cards = cards;
        this.challenges = challenges;
        this.durationOfGame = durationOfGame;
    }


    //Temporary constructor för duration method
    public DrinkIT(List<Player> players) {
        this.players = players;
    }


    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void setDuration(List<Player> players, int duration){
        //System.out.println("Knappen för vald tid är tryckt och antalet spelare multipliceras med "+ duration);
        durationOfGame = players.size()*duration;
    }

    public int getDurationOfGame() {
        return durationOfGame;
    }

    //method for test
    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        for (Player p : players) {
            names.add(p.getName());
        }
        return names;
    }

    public void selectCategory(String category){
        //if selected put the category in this list.
        categories.add(new Category(category));
        System.out.println(getCategoryNames());
    }

    public List<Category> getCategories() {
        return categories;
    }

    //method for test
    public List<String> getCategoryNames() {
        List<String> categoryNames = new ArrayList<>();
        for (Category c : categories) {
            categoryNames.add(c.getCategoryName());
        }
        return categoryNames;
    }




    //Constructor for tests
    public DrinkIT(List<Player> players, List<Card> cards, List<Challenge> challenges) {
        this.players = players;
        this.cards = cards;
        this.challenges = challenges;
    }
}
