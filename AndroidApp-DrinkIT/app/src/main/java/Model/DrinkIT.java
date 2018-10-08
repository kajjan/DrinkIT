package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DrinkIT {
    List<Player> players = new ArrayList<>();
    private List<Card> cards;
    private List<Challenge> challenges;
    int durationOfGame=0;
    private List<Player> completeListOfPlayers = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    List<String> playerList = new ArrayList<>();
    private List<String>playerInPointOrder = new ArrayList<>();
    int index=0;



    public DrinkIT() {}


    public void addPlayer(String name) {
        players.add(new Player(name));
    } //ok


    public void setDuration(List<Player> players, int duration) {//ta bara in duration och hämta lämgden från listan som ka finnas här i modellen.
        System.out.println("Knappen för vald tid är tryckt och antalet spelare multipliceras med "+ duration);

        durationOfGame = players.size() * duration;
    }


    public int getDurationOfGame() {
        return durationOfGame;
    }


    //method to create a complete list with all the players multiplide with the duration time.
    //connected from setDuration maybe not the best solution?
    public void createCompletedPlayersList (){ //privet
        int challengePerPlayer = durationOfGame/players.size();
        int i=0;
        for(Player player: players){

            while(i!=challengePerPlayer) {
                completeListOfPlayers.add(player);
                i++;
            }
            if(i==challengePerPlayer){
                i=0;
            }
        }
        shufflePlayerList(completeListOfPlayers);
    }

    //shuffle the completePlayerList
    private List<Player>shufflePlayerList (List<Player>listOfPlayers){ //ev privet, bör va void
        Collections.shuffle(listOfPlayers);
        return listOfPlayers;
    }


    //method to get the name of the player in the list. Need to get so that the index is controlled somewhere else.
    public String getNameOfPlayer (){ //om kallas från controller ta bara in index
        String name= completeListOfPlayers.get(index).getName();
        return name;
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
            int nextIndex=i+1;
            if(i<players.size()-1) {
                for (int j = i; j <players.size() ; j++) {

                    while (s.getPoint() < players.get(j).getPoint()) {
                        Collections.swap(players, i, j);
                    }

                }
            }

        }
        playerInPointOrder= playerListString();
    }

    //creates a list of strings with the players in a order after points.
    private List<String> playerListString(){ //private
        for (Player c : players) {
            playerList.add(playerToString(c));
        }
        return playerList;
    }


    //method that makes a list that write the players name and its point in a list of strings.
    private String playerToString(Player player){ //private
        String playerToString =player.getName() + " " + player.getPoint() + " Points";

        return playerToString;
    }


    public String getScoreBoardText(){ //private
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
    public void endTheGame(){
        playerList.clear();
        players.clear();
        categories.clear();
        completeListOfPlayers.clear();
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
