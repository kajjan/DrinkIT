package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrinkIT {
    //Category cat = new Category();
    private List<Player> players = new ArrayList<>();
    private int numberOfRounds = 0;
    private List<Player> completeListOfPlayers = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private List<String> playerList = new ArrayList<>();
    private List<String> playerInPointOrder = new ArrayList<>();
    private int indexOfActivePlayer = 0;
    private List<Challenge> challenges = new ArrayList<>();
    private List<Category> cats = new ArrayList<>();
    private int indexOfActiveCategory = -1;


    public DrinkIT() {}


    public void createCategoryListOnCreate(String categoryName, String instruction, List<String> challenges ) {
            cats.add(Factory.createCategory(categoryName,instruction,challenges));
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    } //ok


    public void setNumberOfRounds(int duration) {
        System.out.println("Knappen för vald tid är tryckt och antalet spelare multipliceras med " + duration);

        numberOfRounds = players.size() * duration;
    }


    public int getNumberOfRounds() {
        return numberOfRounds;
    }


    //method to create a complete list with all the players multiplide with the duration time.
    //connected from setNumberOfRounds maybe not the best solution?
    public void createCompletedPlayersList() {
        int challengePerPlayer = numberOfRounds / players.size();
        int i = 0;
        for (Player player : players) {

            while(i!=challengePerPlayer) {
                completeListOfPlayers.add(player);
                i++;
            }
            i = 0;
        }
        shufflePlayerList(completeListOfPlayers);
        //System.out.println(cat.getNeverHaveIEverChallenges().toString());
        //System.out.println(cat.getCharadChallenges().toString());
    }


    //shuffle the completePlayerList
    private void shufflePlayerList(List<Player> listOfPlayers) {
        Collections.shuffle(listOfPlayers);
    }


    //method to get the name of the player in the list. Need to get so that the indexOfActivePlayer is controlled somewhere else.
    public String getNameOfPlayer() {
        return completeListOfPlayers.get(indexOfActivePlayer).getName();

    }

    public String getNextChallenge(){
        String nextChallenge = "";

        Collections.shuffle(cats);
        indexOfActiveCategory++;

        if(indexOfActiveCategory == cats.size()){
            indexOfActiveCategory = 0;
        }

        if (cats.get(indexOfActiveCategory).isActive()){
            nextChallenge = cats.get(indexOfActiveCategory).getChallengeToPlay();
        } else {
            indexOfActiveCategory++;        //Har jag tänkt rätt här??
        }

        if(indexOfActiveCategory == cats.size()){
            indexOfActiveCategory = 0;
        }
        return nextChallenge;
    }


    public void succeededChallenge() {
        int point = completeListOfPlayers.get(indexOfActivePlayer).getPoint();
        int pointToAdd = cats.get(indexOfActiveCategory).getActiveChallengePoint();
        point += pointToAdd;
        completeListOfPlayers.get(indexOfActivePlayer).setPoint(point);
        System.out.println("Points: " + point);
        indexOfActivePlayer++;
    }

    public void failedChallenge() {
        indexOfActivePlayer++;
    }


    public void chooseCategory(String category) { //ska ev inte va string, beror på vad katergori är
        for (Category c : cats) {
            if (c.getName().equals(category)) {
                if (c.isActive()) {
                    c.setInActive();
                } else {
                    c.setActive();
                }
            }
        }
        for (int i = 0; i<cats.size(); i++) { // endast för att se att det funkar
            System.out.println(cats.get(i).getName());
            System.out.println(cats.get(i).isActive());
        }


        /*
        if (categories.contains(category)) {//contains istället
            unSelectCategory(category);
        } else {
            //categories.add(new Category(category));
            System.out.println(getCategoryNames());
        }
        */


    }

    /*
    //Method for removing a category, removes the choosen category
    public void unSelectCategory(String category) { //public, borde va private men måste va public för test
        for (int i = 0; i < categories.size(); i++) {
            if (category.equals(categories.get(i).getName())) {
                categories.remove(i);
                System.out.println(getCategoryNames());
            }
        }
    }

*/

    public boolean categoryListEmpty() {
        boolean b = false;
        if (categories.size() == 0) {
            b = true;
        }
        return b;
    }


    //method that puts every player in the players list in order of highest point to lowest.
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
        for (Player c : players) {
            playerInPointOrder.add(playerToString(c));
        }
    }


    //method that makes a list that write the players name and its point in a list of strings.
    private String playerToString(Player player){ //private
        return player.getName() + " " + player.getPoint() + " Points";
    }

    //method that returns the whole scoreboard as one string.
    public String getScoreBoardText() {
        putListInPointOrder();
        String scoreText;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playerInPointOrder.size(); i++) {

            sb.append(playerInPointOrder.get(i) + "\n");
        }
        scoreText = sb.toString();
        return scoreText;
    }

    //Method that keep track if the game is done and if the view should change to the finishPage
    public boolean nextRound() {
        if (numberOfRounds > indexOfActivePlayer) {
            return true;
        }
        return false;
    }

    //Method that clears the model for a possible new round
    public void endTheGame() {
        playerList.clear();
        players.clear();
        categories.clear();
        completeListOfPlayers.clear();
        playerInPointOrder.clear();
        indexOfActivePlayer = 0;
        numberOfRounds = 0;

    }

    //Helpmethods for tests below


    public DrinkIT(List<Player> players) {
        this.players = players;
    }

    //method for test
    public List<String> getCategoryNames() {
        List<String> categoryNames = new ArrayList<>();
        for (Category c : categories) {
            categoryNames.add(c.getName());
        }
        return categoryNames;
    }

    public List<Category> getCategories() {
        return categories;
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
