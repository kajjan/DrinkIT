package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DrinkIT {
    private List<Player> players = new ArrayList<>();
    private int durationOfGame=0;
    private List<Player> completeListOfPlayers = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private List<String>playerInPointOrder = new ArrayList<>();
    private int index=0;


    private List<Card>cards=new ArrayList<>();
    private List<Challenge>challenges=new ArrayList<>();



    public DrinkIT() {}


    public void addPlayer(String name) {
        players.add(new Player(name));
    } //ok


    public void setDuration(int duration) {
        System.out.println("Knappen för vald tid är tryckt och antalet spelare multipliceras med "+ duration);

        durationOfGame = players.size() * duration;
    }


    public int getDurationOfGame() {
        return durationOfGame;
    }


    //method to create a complete list with all the players multiplide with the duration time.
    //connected from setDuration maybe not the best solution?
    public void createCompletedPlayersList (){
        int challengePerPlayer = durationOfGame/players.size();
        int i=0;
        for(Player player: players){

            while(i!=challengePerPlayer) {
                completeListOfPlayers.add(player);
                i++;
            }

            i=0;
        }
        shufflePlayerList(completeListOfPlayers);
    }

    //shuffle the completePlayerList
    private void shufflePlayerList (List<Player>listOfPlayers){ //ev privet, bör va void
        Collections.shuffle(listOfPlayers);
    }


    //method to get the name of the player in the list. Need to get so that the index is controlled somewhere else.
    public String getNameOfPlayer (){ //om kallas från controller ta bara in index
         return completeListOfPlayers.get(index).getName();

    }

    private void setPointOfPlayer (){
        int point = completeListOfPlayers.get(index).getPoint();
        point++;
        completeListOfPlayers.get(index).setPoint(point);
        System.out.println("Points: " + point);
    }

    public void succeedChallenge(){
        setPointOfPlayer();
        index++;
    }

    public void failedChallenge(){
        index++;
    }



    public List<Player> getPlayers() {
        return players;
    } //tveksamt, får denna användas? kanske för test



    public void chooseCategory(String category) { //ska ev inte va string, beror på vad katergori är
        if (isInList(category)) {//contains istället
            unSelectCategory(category);
        } else {
            selectCategory(category);
            System.out.println(getCategoryNames());
        }

    }

    //Adds chosen category to categories list
    public void selectCategory(String category) { //samma som ovan, ev inte en string

        categories.add(new Category(category));
    }

    //Method for removing a category, removes the choosen category
    public void unSelectCategory(String category) { // se ovan
        for (int i = 0; i < categories.size(); i++) {
            if (category.equals(categories.get(i).getCategoryName())) {
                categories.remove(i);
                System.out.println(getCategoryNames());
            }
        }
    }

    //Checks if chosen category already is in the categories list
    private boolean isInList(String category) { //ersätt med contains
        boolean b = false;
        for (Category c : categories) {
            if (category.equals(c.getCategoryName())) {
                b = true;
            }
        }
        return b;
    }



    public List<Category> getCategories() { //se var den används, returnera istället namn eller int
        return categories;
    }


    //method that puts every player in the players list in order of highest point to smallest.
    public void putListInPointOrder() {

        for (int i = 0; i < players.size(); i++) {
            Player s = players.get(i);
            if(i<players.size()-1) {
                for (int j = i; j <players.size() ; j++) {

                    while (s.getPoint() < players.get(j).getPoint()) {
                        Collections.swap(players, i, j);
                    }

                }
            }

        }
        playerListString();
    }

    //creates a list of strings with the players in a order after points.
    private void playerListString(){ //private
        for (Player c : players) {
            playerInPointOrder.add(playerToString(c));
        }

    }


    //method that makes a list that write the players name and its point in a list of strings.
    private String playerToString(Player player){ //private
        return player.getName() + " " + player.getPoint() + " Points";
    }

    //method that returns the whole scoreboard as one string.
    public String getScoreBoardText(){
        String scoreText= "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <playerInPointOrder.size(); i++) {

           sb.append(playerInPointOrder.get(i) + "\n");
        }
        scoreText= sb.toString();
        return scoreText;
    }

    //Method that keep track if the game is done and if the view should change to the finishPage
    public boolean nextRound(){
        if(durationOfGame>index){
            return true;
        }
        return false;
    }

    //Method that clears the model for a possible new round
    public void endTheGame(){
        players.clear();
        categories.clear();
        completeListOfPlayers.clear();
        playerInPointOrder.clear();
        index=0;
        durationOfGame=0;

    }

    //Helpmethods for tests below

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

    //method for test
    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        for (Player p : players) {
            names.add(p.getName());
        }

        return names;
    }
}
