package Model;

import java.util.ArrayList;
import java.util.List;

public class DrinkIT {
    private List<Player> players;
    private List<Card> cards;
    private List<Challenge> challenges;
    private List<Category> categories = new ArrayList<>();
    private int durationOfGame;

    public DrinkIT(List<Player> players, List<Card> cards, List<Challenge> challenges, int durationOfGame) {
        this.players = players;
        this.cards = cards;
        this.challenges = challenges;
        this.durationOfGame = durationOfGame;
    }


    //Temporary constructor for duration method
    public DrinkIT(List<Player> players) {
        this.players = players;
    }


    public void addPlayer(String name) {
        players.add(new Player(name));
    }


    public void setDuration(List<Player> players, int duration) {
        //System.out.println("Knappen för vald tid är tryckt och antalet spelare multipliceras med "+ duration);
        durationOfGame = players.size() * duration;
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


    public void chooseCategory(String category) {
        if (isInList(category)) {
            unSelectCategory(category);
        } else {
            selectCategory(category);
            System.out.println(getCategoryNames());
        }

    }

    //Adds chosen category to categories list
    public void selectCategory(String category) {
        categories.add(new Category(category));
    }

    //Method for removing a category, removes the choosen category
    public void unSelectCategory(String category) {
        for (int i = 0; i < categories.size(); i++) {
            if (category.equals(categories.get(i).getCategoryName())) {
                categories.remove(i);
                System.out.println(getCategoryNames());


            }
        }
    }

    //Checks if chosen category already is in the categories list
    private boolean isInList(String category) {
        boolean b = false;
        for (Category c : categories) {
            if (category.equals(c.getCategoryName())) {
                b = true;
            }
        }
        return b;
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
