package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DrinkIT {
    static List<Player> players = new ArrayList<>();
    private List<Card> cards;
    private List<Challenge> challenges;
    static int durationOfGame;
    private List<Player> completeListOfPlayers;
    private List<Category> categories = new ArrayList<>();
    private List<Player>playerInPointOrder= new ArrayList<>();


    public DrinkIT(List<Player> players, List<Card> cards, List<Challenge> challenges, int durationOfGame) {
        this.players = players;
        this.cards = cards;
        this.challenges = challenges;
        this.durationOfGame = durationOfGame;
    }
    public DrinkIT() {

    }

    //Temporary constructor for duration method
    public DrinkIT(List<Player> players) {
        this.players = players;
    }


    public void addPlayer(String name) {
        players.add(new Player(name));
    }


    public void setDuration(List<Player> players, int duration) {
        System.out.println("Knappen för vald tid är tryckt och antalet spelare multipliceras med "+ duration);
        durationOfGame = players.size() * duration;
    }


    public int getDurationOfGame() {
        return durationOfGame;
    }


    //method to create a complete list with all the players multiplide with the duration time.
    //connected from setDuration maybe not the best solution?
    public List<Player> createCompletedPlayersList (List<Player> listOfPlayers, int durationOfGame){
        List<Player>completePlayerList = new ArrayList<>(durationOfGame);
        int challengePerPlayer = durationOfGame/listOfPlayers.size();
        int i=0;
        for(Player player: listOfPlayers){

            while(i!=challengePerPlayer) {
                completePlayerList.add(player);
                i++;
            }
            if(i==challengePerPlayer){
                i=0;
            }
        }
        System.out.println(completePlayerList);
        return completePlayerList;
    }

    //shuffle the completePlayerList
    public List<Player>shufflePlayerList (List<Player>listOfPlayers){
        Collections.shuffle(listOfPlayers);
        return listOfPlayers;
    }


    //method to get the name of the player in the list. Need to get so that the index is controlled somewhere else.
    public String getNameOfPlayer (List<Player>listOfPlayer, int index){
        String name= listOfPlayer.get(index).getName();
        System.out.println(name);
        return name;
    }

    public void setPointOfPlayer (List<Player>listOfPlayer, int index){
        int point = listOfPlayer.get(index).getPoint();
        point++;
        listOfPlayer.get(index).setPoint(point);
        System.out.println("Points: " + point);
        getNumber1(players);
    }

    //Write a method that keep track of what index in the list of players we are at and wich should be shown. Now it only shows the firt in the list to se that the other methods works.
    public int getIndexForChallenge(){
        int i=0;
        return i;
    }



    public List<Player> getPlayers() {
        return players;
    }



    //Helpmethods for tests below


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

    public void getNumber1(List<Player>players) {

        for (int i = 0; i < players.size(); i++) {
            Player s = players.get(i);
            Player temp;
            List<String>lista= playerListString();
            System.out.println(lista);

           /* while (s.getPoint() < players.get(i + 1).getPoint()) {
            temp=s;
            s=players.get(i+1);
            players.set(i+1, temp);
            }*/

        }

    }

    public List<String> playerListString(){
        List<String> playerList = new ArrayList<>();
        for (Player c : players) {
            playerList.add(playerToString(c));
        }
        return playerList;
    }

    public String playerToString(Player player){
        String playerToString =player.getName() + ": " + player.getPoint() + " Points";

        return playerToString;
    }

    //Method that keep track if the game is done and if the view should change to the finishPage
    public boolean nextRound(int roundOfChallenge){
        if(durationOfGame>roundOfChallenge){
            return true;
        }
        return false;
    }
}
