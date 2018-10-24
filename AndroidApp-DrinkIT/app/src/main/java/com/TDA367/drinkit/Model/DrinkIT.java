package com.TDA367.drinkit.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Model class: DrinkIT
 * <p>
 * DrinkIT is the model in the MCV modelling of the application and acts as the interface to the code.
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class DrinkIT {
    private List<Player> players = new ArrayList<>();
    private int numberOfRounds = 0;
    private int indexOfActivePlayer = 0;
    private List<Category> categories = new ArrayList<>();
    private int indexOfActiveCategory = -1;
    private int playedRounds = 0;


    public DrinkIT() {
    }

    /**
     * Prepares the game for a new game which will statistically be different from previously played games, making it more interesting
     */
    public void initiateGame() {
        Collections.shuffle(players);
        Collections.shuffle(categories);
        for (Category c : categories) {
            c.shuffleChallenges();
        }
    }

    /**
     * @return the name of the indexOfActiveCategory from the categories list
     */
    public String getActiveCategory() {
        return categories.get(indexOfActiveCategory).getName();
    }

    public boolean atLeastOneCategoryChosen() {
        for (Category c : categories) {
            if (c.isActive()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the ActiveChallengePoint from the indexOfActiveCategory in the categories list
     */
    public int getActiveChallengePoints() {
        return categories.get(indexOfActiveCategory).getActiveChallengePoint();
    }

    public List<String> getCategoryNames() {
        List<String> res = new ArrayList<>();

        for (Category c : categories)
            res.add(c.getName());

        return res;
    }

    /**
     * Method which adds a player to the player list
     *
     * @param name
     */
    public void addPlayer(String name) {
        players.add(new Player(name));
    }


    /**
     * Method goes through Player list players and adds the players names to string list
     *
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
     *
     * @param playerName String of Player name
     */
    public void removePlayerDuringGame(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                players.remove(player);
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
     * Method which adds a gameRound.
     */
    public void addGameRound(boolean challengeCompleted) {
        GameRound gameRound = new GameRound(players.get(indexOfActivePlayer),
                categories.get(indexOfActiveCategory).getActiveChallenge());
        gameRound.setSucceded(challengeCompleted);
        gameRound.addPlayedRound(gameRound);

    }

    public boolean isAlreadyPlayed(GameRound gameRound) {
        Boolean b = false;
        List<GameRound> playedRounds;
        playedRounds = gameRound.getPlayedRounds();
        for (GameRound r : playedRounds) {
            if (r.getChallenge().getChallengeText().equals(gameRound.getChallenge().getChallengeText()) && r.getPlayer().getName().equals(gameRound.getPlayer().getName())) {
                b = true;
            }
        }
        return b;
    }


    public String getActiveChallenge() {
        if (indexOfActiveCategory < 0) {
            indexOfActiveCategory = 0;
        }
        String activeChallenge = categories.get(indexOfActiveCategory).getChallengeToPlay();
        return activeChallenge;
    }

    /**
     * Gets answer of the activeChallenge of the activeCategory in the list categories
     *
     * @return nextCategory string
     */
    public String getActiveChallengesAnswer() {
        return categories.get(indexOfActiveCategory).getActiveChallenge().getAnswer();
    }

    public String getNextCategory() {
        String nextCategory = "none";
        indexOfActiveCategory++;
        while (nextCategory.equals("none")) {
            if (indexOfActiveCategory == categories.size()) {
                Collections.shuffle(categories);
                indexOfActiveCategory = 0;
            }
            if (categories.get(indexOfActiveCategory).isActive()) {
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
     *
     * @return the currentCategory
     */
    public String getCurrentCategory() {
        String currentCategory = "none";
        if (categories.get(indexOfActiveCategory).isActive()) {
            currentCategory = categories.get(indexOfActiveCategory).getName();
        }
        return currentCategory;
    }

    public String getInstructions() {
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
        addGameRound(true);
        playedRounds++;
        updateActivePlayer();
        updateActiveChallenge();
    }

    /**
     * Method moves on to next gameRound without giving active player points
     */
    public void failedChallenge() {
        addGameRound(false);
        playedRounds++;
        updateActivePlayer();
        updateActiveChallenge();
    }

    /**
     * This method makes sure the players TODO ASK ELIN!!!
     */
    private void updateActivePlayer() {
        indexOfActivePlayer++;
        if (indexOfActivePlayer == players.size()) {
            String previousPlayer = players.get(indexOfActivePlayer - 1).getName();
            Collections.shuffle(players);
            while (players.get(0).getName() == previousPlayer) {
                Collections.shuffle(players);
            }
            indexOfActivePlayer = 0;
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
     *
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
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(categories.get(i).getName());
            System.out.println(categories.get(i).isActive());
        }
    }

    /**
     * Checks if category button in list categories is Active
     *
     * @param i int
     * @return boolean b
     */
    public boolean buttonActive(int i) {
        boolean b = false;
        if (categories.get(i).isActive()) {
            b = true;
        }
        return b;
    }

    /**
     * Checks list players in based on Player points and adds to the list playerInPointOrder
     */
    public void putListInPointOrder() {
        for (int i = 0; i < players.size(); i++) {
            Player s = players.get(i);
            if (i < players.size() - 1) {
                for (int j = i; j < players.size(); j++) {
                    while (s.getPoint() < players.get(j).getPoint()) {
                        Collections.swap(players, i, j);
                    }

                }
            }
        }
    }

    /**
     * method that returns the whole scoreboard as one string.
     *
     * @return String scoreText
     */
    public String getScoreBoardText() {
        putListInPointOrder();
        String scoreText;
        StringBuilder sb = new StringBuilder();

        for (Player player : players)
            sb.append(player.toString() + "\n");

        scoreText = sb.toString();
        return scoreText;
    }

    /**
     * Method that keep track if the game is done and if the view should change to the finishPage
     *
     * @return false or true boolean
     */
    public boolean nextRound() {
        if (numberOfRounds > playedRounds) {
            return true;
        }
        return false;
    }

    /**
     * Method which sets truthChallenge
     */
    public void setTruthChallenge() {
        while (!(getActiveChallenge()).contains("Truth")) {
            categories.get(indexOfActiveCategory).increaseIndexOfActiveChallenge();
        }
    }

    /**
     * Method which sets dare challenge
     */
    public void setDareChallenge() {
        while (!(getActiveChallenge()).contains("Dare")) {
            categories.get(indexOfActiveCategory).increaseIndexOfActiveChallenge();
        }
    }

    /**
     * Method that clears the model for a possible new round
     */
    public void clearTheGame() {
        players.clear();
        categories.clear();
        playedRounds = 0;
        indexOfActiveCategory = -1;
        indexOfActivePlayer = 0;
        numberOfRounds = 0;
    }


    public Challenge createChallenge(String challengeText, String answerText, int point) {
        return new Challenge(challengeText, answerText, point);
    }

    public Category createCategory(String name, String description, List<Challenge> challenges) {
        Category cat = new Category(name, description, challenges);
        categories.add(cat);
        return cat;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Helpmethods for tests
     *
     * @param players Players
     */
    public DrinkIT(List<Player> players) {
        this.players = players;
    }

    /**
     * method for test
     *
     * @return names
     */
    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        for (Player p : players) {
            names.add(p.getName());
        }

        return names;
    }

    public int getIndexOfActivePlayer() {
        return indexOfActivePlayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Category> getCategories() {
        return categories;
    }

    /**
     * setter for test
     *
     * @param indexOfActivePlayer int
     */
    public void setIndexOfActivePlayer(int indexOfActivePlayer) {
        this.indexOfActivePlayer = indexOfActivePlayer;
    }

    /**
     * setter for tests
     *
     * @param indexOfActiveCategory int
     */
    public void setIndexOfActiveCategory(int indexOfActiveCategory) {
        this.indexOfActiveCategory = indexOfActiveCategory;
    }

    public int getIndexOfActiveCategory() {
        return indexOfActiveCategory;
    }


    /**
     * Constructor for tests
     */
    public DrinkIT(List<Player> players, int numberOfRounds, int indexOfActivePlayer, List<Category> categories,
                   int indexOfActiveCategory) {
        this.players = players;
        this.numberOfRounds = numberOfRounds;
        this.indexOfActivePlayer = indexOfActivePlayer;
        this.categories = categories;
        this.indexOfActiveCategory = indexOfActiveCategory;
    }
}
