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

    public String getActiveCategory() {
        return categories.get(indexOfActiveCategory).getName();
    }

    public int getActiveChallengePoints() {
        return categories.get(indexOfActiveCategory).getActiveChallengePoint();
    }

    /**
     * A method with creates and adds a category to the list categories
     * @param categoryName
     * @param instruction
     * @param challenges
     */
    public void createCategoryListOnCreate(String categoryName, String instruction, List<String> challenges ) {
            categories.add(CategoryFactory.createCategory(categoryName,instruction,challenges));
    }

    public List<String> getCategoryNames () {
        for (Category c : categories) {
            categoryNames.add(c.getName());
        }
        return categoryNames;
    }

    /** Method which adds a player to the player list
     *
     * @param name
     */
    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public List<String> getAllPlayerNames() {
        List<String> playerNames = new ArrayList<>(10);
        for (Player p : players) {
            playerNames.add(p.getName());
        }
        return playerNames;
    }

    /**
     * Mathod removes a player from the lists players and completeListOfPlayer
     * @param playerName
     */
    public void removePlayerDuringGame(String playerName) {
        for (int i=0; i<players.size(); i++) {
            if (players.get(i).getName().equals(playerName)) {
                players.remove(i);
            }
        }
    }

    public void addPlayerDuringGame(String playerName) {
        System.out.println("I want to add player " + playerName + " to the game!");
        addPlayer(playerName);
        Collections.shuffle(players);
    }

    public void setNumberOfRounds(int duration) {
        numberOfRounds = players.size() * duration;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public String getNameOfPlayer() {
        return players.get(indexOfActivePlayer).getName();
    }

    /**
     * Method which adds a gameRound.
     */
    public void addGameRound(){
        playedRounds.add(new GameRound(players.get(indexOfActivePlayer),
                categories.get(indexOfActiveCategory).getActiveChallenge()));
    }


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


    public String getActiveChallenge(){
            if(indexOfActiveCategory < 0) { indexOfActiveCategory = 0;}
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

    public String getActiveChallengesAnswer() {
        return categories.get(indexOfActiveCategory).getActiveChallenge().getAnswer();
    }

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

    public String getCurrentCategory() {
        String currentCategory = "none";
        if (categories.get(indexOfActiveCategory).isActive()) {
            currentCategory = categories.get(indexOfActiveCategory).getName();
        }
        return currentCategory;
    }

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
        playedRounds.get(playedRounds.size()-1).setSucceeded(true);
        updateActivePlayer();
        updateActiveChallenge();
    }

    /**
     * Method moves on to next gameRound without giving active player points
     */
    public void failedChallenge() {
        addGameRound();
        playedRounds.get(playedRounds.size()-1).setSucceeded(false);
        updateActivePlayer();
        updateActiveChallenge();
    }

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

    private void updateActiveChallenge() {
        categories.get(indexOfActiveCategory).increaseIndexOfActiveChallenge();
    }

    /**
     * Method which sets chosen Cetegories to active and inactive based onClick, in view
     * @param category
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
        // endast för att printa och se att det funkar
        for (int i = 0; i< categories.size(); i++) {
            System.out.println(categories.get(i).getName());
            System.out.println(categories.get(i).isActive());
        }

    }

    /**
     * Checks if category button in list categories is Active
     * @param i
     * @return
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
        System.out.println("GAMEROUND HERE -->"+playedRounds);
        System.out.println(playedRounds.size());
        System.out.println(playedRounds.toString());
        return scoreText;
    }

    /**
     * Method that keep track if the game is done and if the view should change to the finishPage
     * @return
     */
    public boolean nextRound() {
        if (numberOfRounds > playedRounds.size()) {
            return true;
        }
        return false;
    }

    public void setTruthChallenge(){
        while(!(getActiveChallenge()).contains("truth")) {
                categories.get(indexOfActiveCategory).increaseIndexOfActiveChallenge();
        }
    }

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
     *  Helpmethods for tests
     * @param players
     */
    public DrinkIT(List<Player> players) {
        this.players = players;
    }

    /**
     * method for test
     * @return
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

    //setters for tests

    public void setIndexOfActivePlayer(int indexOfActivePlayer) {
        this.indexOfActivePlayer = indexOfActivePlayer;
    }

    /**
     * setter for tests
     * @param indexOfActiveCategory
     */
    public void setIndexOfActiveCategory(int indexOfActiveCategory) {
        this.indexOfActiveCategory = indexOfActiveCategory;
    }

    public int getIndexOfActiveCategory(){ return indexOfActiveCategory;}


    /**
     * Constructor for tests
     * @param players
     * @param numberOfRounds
     * @param playerInPointOrder
     * @param indexOfActivePlayer
     * @param categories
     * @param indexOfActiveCategory
     * @param playedRounds
     * @param categoryNames
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
