package com.TDA367.drinkit.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Model class: DrinkIT
 *
 * DrinkIT is the model in the MCV modelling of the application and acts as the interface to the code.
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 *
 *
 */

public class DrinkIT {
    private List<Player> players = new ArrayList<>(); //                    1
    private int numberOfRounds = 0;                     //                  2
    private List<String> playerInPointOrder = new ArrayList<>(); //         4
    private int indexOfActivePlayer = 0; //                                 5
    private List<Category> categories = new ArrayList<>(); //               6
    private int indexOfActiveCategory = -1;   //                            7
    private List<GameRound> playedRounds = new ArrayList<>(); //            8
    private List<String> categoryNames = new ArrayList<>();//               10



    public DrinkIT() {}

    /**
     * @return the name of the indexOfActiveCategory from the categories list
     */
    public String getActiveCategory() {
        return categories.get(indexOfActiveCategory).getName();
    }

    /**
     * @return the ActiveChallengePoint from the indexOfActiveCategory in the categories list
     */
    public int getActiveChallengePoints() {
        return categories.get(indexOfActiveCategory).getActiveChallengePoint();
    }

    /**
     * A method with creates and adds a category to the list categories
     * @param categoryName String Category name
     * @param instruction String Instruction
     * @param challenges List of strings Challenges
     */
    public void createCategoryListOnCreate(String categoryName, String instruction, List<String> challenges ) {
            categories.add(CategoryFactory.createCategory(categoryName,instruction,challenges));
    }

    /** Method looks through Category list and adds the elements as Strings to
     * the list categoryNames
     * @return String list categoryNames
     */
    public List<String> getCategoryNames () {
        for (Category c : categories) {
            categoryNames.add(c.getName());
        }
        return categoryNames;
    }

    /** Method which adds a player to the player list
     * @param name Player name
     */
    public void addPlayer(String name) {
        players.add(new Player(name));
    }


    /**
     * Method goes through Player list players and adds the players names to string list
     * @return String list playerNames
     */
    public List<String> getAllPlayerNames() {
        List<String> playerNames = new ArrayList<>(10);
        for (Player p : players) {
            playerNames.add(p.getName());
        }
        return playerNames;
    }

    /**
     * Mathod removes a player from the lists players and completeListOfPlayer
     * @param playerName String of Player name
     */
    public void removePlayerDuringGame(String playerName) {
        for (int i=0; i<players.size(); i++) {
            if (players.get(i).getName().equals(playerName)) {
                players.remove(i);
            }
        }
    }

    /**
     * Method takes in String playerName and adds it to the players list as a new Player
     * and then shuffles players list
     */
    public void addPlayerDuringGame(String playerName) {
        System.out.println("I want to add player " + playerName + " to the game!");
        addPlayer(playerName);
        Collections.shuffle(players);
    }

    /**
     * sets numberOfRound to the players list size multiplied with the
     * users chosen duration
     */
    public void setNumberOfRounds(int duration) {
        numberOfRounds = players.size() * duration;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    /**
     * @return name of indexOfActivePlayer from the players list
     */
    public String getNameOfPlayer() {
        return players.get(indexOfActivePlayer).getName();
    }

    /**
     * Method which adds a new gameRound to the game
     */
    public void addGameRound(){
        playedRounds.add(new GameRound(players.get(indexOfActivePlayer),
                categories.get(indexOfActiveCategory).getActiveChallenge()));
    }

    /**
     * TODO!!!!!!!!!!!!!!!!!!!!!!!!
     * @param player Player
     * @param challenge Challenge
     * @return this to be done
     */
    public boolean isAlreadyPlayed(Player player, String challenge) {
        //if(playedRounds.size() < 3){return false;}
        Boolean b = false;
        for (GameRound r : playedRounds) {
            if (r.getChallenge().getChallengeText().equals(challenge) && r.getPlayer().equals(player)) {
                b = true;
            }
        }
        return b;
    }


    /**
     * TODO work in progress??
     * @return activeChallenge
     */
    public String getActiveChallenge(){
            if(indexOfActiveCategory < 0) {
                indexOfActiveCategory = 0;
            }
            String activeChallenge = categories.get(indexOfActiveCategory).getChallengeToPlay();

            /* isPlayedAgain makes the app crash inconsistently, unsure of why - needs more work before it can be used
            boolean b = true;
            while (b) {
                if (!isAlreadyPlayed(players.get(indexOfActivePlayer), activeChallenge)) {
                    //return activeChallenge;
                    b = false;
                } else {
                    updateActiveChallenge();
                    //getActiveChallenge();
                }
            }
            */

        return activeChallenge;
    }

    /**
     * Gets answer of the activeChallenge of the activeCategory in the list categories
     * @return nextCategory string
     */
    public String getActiveChallengesAnswer() {
        return categories.get(indexOfActiveCategory).getActiveChallenge().getAnswer();
    }

    /** TODO den här medoden skulle ändras?? bytas namn på? javadoc avaktar
     * @return String nextCategory
     */
    public String getNextCategory(){
        String nextCategory = "none";
        Collections.shuffle(categories);
        indexOfActiveCategory++;
        while (nextCategory.equals("none")) {
            if(indexOfActiveCategory == categories.size()){
                indexOfActiveCategory = 0;
            }
            if (categories.get(indexOfActiveCategory).isActive()){
                nextCategory = categories.get(indexOfActiveCategory).getName();
                System.out.println(nextCategory);
            } else {
                indexOfActiveCategory++;
            }
        }
        return nextCategory;
    }

    /**
     * If the indexOfActiveCategory in categories is active, the name of the currentCategory is
     * returned
     * @return the currentCategory
     */
    public String getCurrentCategory() {
        String currentCategory = "none";
        if (categories.get(indexOfActiveCategory).isActive()) {
            currentCategory = categories.get(indexOfActiveCategory).getName();
        }
        return currentCategory;
    }

    /**
     * @return Instruction of indexOfActiveCategory in list categories
     */
    public String getInstructions(){
        return categories.get(indexOfActiveCategory).getInstruction();
    }

    /**
     * Method gives active player points, and moves on to next gameRound
     */
    public void succeededChallenge() {
        int point = players.get(indexOfActivePlayer).getPoint();

        int pointToAdd = categories.get(indexOfActiveCategory).getActiveChallengePoint();
        point += pointToAdd;

        players.get(indexOfActivePlayer).setPoint(point);

        addGameRound();
        playedRounds.get(playedRounds.size()-1).setSucceded(true);
        updateActivePlayer();
        updateActiveChallenge();
    }

    /**
     * Method moves on to next gameRound without giving active player points
     */
    public void failedChallenge() {
        addGameRound();
        playedRounds.get(playedRounds.size()-1).setSucceded(false);
        updateActivePlayer();
        updateActiveChallenge();
    }

    /**
     * This method makes sure the players TODO ASK ELIN!!!
     */
    private void updateActivePlayer() {
        indexOfActivePlayer++;

        if (indexOfActivePlayer==players.size()) {
            String previousPlayer = players.get(indexOfActivePlayer-1).getName();
            Collections.shuffle(players);
            while (players.get(0).getName()==previousPlayer) {
                Collections.shuffle(players);
            }
            indexOfActivePlayer=0;
        }
    }

    /**
     * gets the indexOfActiveCategory from categories list and increases the indexOfActiveChallenge
     */
    private void updateActiveChallenge() {
        categories.get(indexOfActiveCategory).increaseIndexOfActiveChallenge();
    }

    /**
     * Method which sets chosen Cetegories to active and inactive based onClick, in view
     * @param category String
     */
    public void chooseCategory(String category) {
        for (Category c : categories) {
            if (c.getName().equals(category)) {
                if (c.isActive()) {
                    c.setInActive();
                } else {
                    c.setActive();
                }
            }
        }
        // only for printing to see if it works
        for (int i = 0; i< categories.size(); i++) {
            System.out.println(categories.get(i).getName());
            System.out.println(categories.get(i).isActive());
        }

    }

    /**
     * Checks if category button in list categories is Active
     * @param i int
     * @return boolean b
     */
    public boolean buttonActive(int i){
        boolean b = false;
        if(categories.get(i).isActive()){
            b=true;
        }
        return b;
    }

    /**
     * Checks list players in based on Player points and adds to the list playerInPointOrder
     */
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

    /**
     * method that makes a list that write the players name and its point in a String list
    */
     private String playerToString(Player player){ //private
        return player.getName() + " " + player.getPoint() + " Points";
    }

    /** method that returns the whole scoreboard as one string.
     *
     * @return String scoreText
     */
    public String getScoreBoardText() {
        putListInPointOrder();
        String scoreText;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playerInPointOrder.size(); i++) {

            sb.append(playerInPointOrder.get(i) + "\n");
        }
        scoreText = sb.toString();
        System.out.println("GAMEROUND HERE -->"+playedRounds);
        System.out.println(playedRounds.size());
        System.out.println(playedRounds.toString());
        return scoreText;
    }

    /**
     * Method that keep track if the game is done and if the view should change to the finishPage
     * @return false or true boolean
     */
    public boolean nextRound() {
        if (numberOfRounds > playedRounds.size()) {
            return true;
        }
        return false;
    }

    /**
     * Method which sets truthChallenge
     */
    public void setTruthChallenge(){
        while(!(getActiveChallenge()).contains("truth")) {
                categories.get(indexOfActiveCategory).increaseIndexOfActiveChallenge();
        }
    }


    /**
     * Method which sets dare challenge
     */
    public void setDareChallenge(){
        while(!(getActiveChallenge()).contains("dare")) {
                categories.get(indexOfActiveCategory).increaseIndexOfActiveChallenge();
        }
    }

    /**
     *  Method that clears the model for a possible new round
     */
    public void clearTheGame() {
        players.clear();
        playerInPointOrder.clear();
        categories.clear();
        playedRounds.clear();
        categoryNames.clear();
        indexOfActiveCategory = -1;
        indexOfActivePlayer = 0;
        numberOfRounds = 0;
        }

    /**
     *  Helpmethods for tests, constructor
     * @param players list
     */
    public DrinkIT(List<Player> players) {
        this.players = players;
    }

    /**
     * method for test
     * @return names
     */
    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        for (Player p : players) {
            names.add(p.getName());
        }

        return names;
    }

    public int getIndexOfActivePlayer(){
        return indexOfActivePlayer;
    }

    public List<Player> getPlayers(){ return players;}

    public List<GameRound> getPlayedRounds(){return playedRounds; }

    public List<Category> getCategories() {
        return categories;
    }

    /**
     * setter for test
     * @param indexOfActivePlayer int
     */
    public void setIndexOfActivePlayer(int indexOfActivePlayer) {
        this.indexOfActivePlayer = indexOfActivePlayer;
    }

    /**
     * setter for tests
     * @param indexOfActiveCategory int
     */
    public void setIndexOfActiveCategory(int indexOfActiveCategory) {
        this.indexOfActiveCategory = indexOfActiveCategory;
    }


    public int getIndexOfActiveCategory(){ return indexOfActiveCategory;}


    /**
     * Constructor for tests
     * @param players list Players
     * @param numberOfRounds int
     * @param playerInPointOrder String list
     * @param indexOfActivePlayer int
     * @param categories Category list
     * @param indexOfActiveCategory int
     * @param playedRounds List GameRound
     * @param categoryNames String List
     */
    public DrinkIT(List<Player> players, int numberOfRounds,
                   List<String> playerInPointOrder, int indexOfActivePlayer, List<Category> categories,
                   int indexOfActiveCategory, List<GameRound> playedRounds,
                   List<String> categoryNames) {
        this.players = players;
        this.numberOfRounds = numberOfRounds;
        this.playerInPointOrder = playerInPointOrder;
        this.indexOfActivePlayer = indexOfActivePlayer;
        this.categories = categories;
        this.indexOfActiveCategory = indexOfActiveCategory;
        this.playedRounds = playedRounds;
        this.categoryNames = categoryNames;
    }

    public List<String> getPlayerInPointOrder() {
        return playerInPointOrder;
    }

}
