package com.TDA367.drinkit.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DrinkIT {
    //Category cat = new Category();
    private List<Player> players = new ArrayList<>(); //
    private int numberOfRounds = 0;                     //
    private List<Player> completeListOfPlayers = new ArrayList<>(); //
    private List<String> playerInPointOrder = new ArrayList<>(); //
    private int indexOfActivePlayer = 0; //
    private List<Category> cats = new ArrayList<>(); //
    private int indexOfActiveCategory = -1;
    private List<GameRound> playedRounds = new ArrayList<>(); //
    private String activeChallenge;
    private List<String> categoryNames = new ArrayList<>();
    private List<String> completelistOfPlayerNames = new ArrayList<>();
    private List<String> playerNames = new ArrayList<>(10);

    //Uses for tests
    private List<Category> categories = new ArrayList<>();
    private List<String> playerList = new ArrayList<>();


    public DrinkIT() {}


    public void createCategoryListOnCreate(String categoryName, String instruction, List<String> challenges ) {
            cats.add(CategoryFactory.createCategory(categoryName,instruction,challenges));
    }

    public List<String> getCategoryNames () {
        for (Category c : cats) {
            categoryNames.add(c.getName());
        }
        return categoryNames;
    }


    public List<String> getPresentableCategoryNames() {
        List<String> presentableCategoryNames = new ArrayList<>();
        for (Category c : cats) {
            presentableCategoryNames.add(c.getPresentableName());
        }
        return presentableCategoryNames;
    }


    public void addPlayer(String name) {
        players.add(new Player(name));
    } //ok

    public List<String> getAllPlayerNames() {
        for (Player p : players) {
            playerNames.add(p.getName());
        }
        return playerNames;
    }


    public void setNumberOfRounds(int duration) {
        System.out.println("Knappen för vald tid är tryckt och antalet spelare multipliceras med " + duration);

        numberOfRounds = players.size() * duration;
    }


    public int getNumberOfRounds() {
        return numberOfRounds;
    }


    //method to create a complete list with all the players multiplied with the duration time.
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

    public List<String> getCompleteListOfPlayersNames() {
        for (Player p : completeListOfPlayers) {
            completelistOfPlayerNames.add(p.getName());
        }
        return completelistOfPlayerNames;
    }


    //shuffle the completePlayerList
    private void shufflePlayerList(List<Player> listOfPlayers) {
        Collections.shuffle(listOfPlayers);
    }


    //method to get the name of the player in the list. Need to get so that the indexOfActivePlayer is controlled somewhere else.
    public String getNameOfPlayer() {
        System.out.println(indexOfActivePlayer);
        return completeListOfPlayers.get(indexOfActivePlayer).getName();
    }

    public String getActiveChallenge() {
        playedRounds.add(new GameRound(completeListOfPlayers.get(indexOfActivePlayer),
                cats.get(indexOfActiveCategory).getActiveChallenge()));
        activeChallenge = cats.get(indexOfActiveCategory).getChallengeToPlay();
        return activeChallenge;
    }

    //hur i världen ska detta funka - /Elin

    public String getActiveChallengesAnswer() {
        String activeAnswer;
        activeAnswer = cats.get(indexOfActiveCategory).getActiveChallenge().getAnswer();
        return activeAnswer;
    }

    public String getNextCategory(){
        String nextCategory = "none";
        Collections.shuffle(cats);
        indexOfActiveCategory++;
        while (nextCategory.equals("none")) {
            if(indexOfActiveCategory == cats.size()-1){
                indexOfActiveCategory = 0;
            }
            if (cats.get(indexOfActiveCategory).isActive()){
                nextCategory = cats.get(indexOfActiveCategory).getName();
                System.out.println(nextCategory);
            } else {
                indexOfActiveCategory++;
            }
        }

        return nextCategory;
    }

    public String getInstructions(){
        return cats.get(indexOfActiveCategory).getInstruction();
    }

    public void succeededChallenge() {

        int point = completeListOfPlayers.get(indexOfActivePlayer).getPoint();
        int pointToAdd = cats.get(indexOfActiveCategory).getActiveChallengePoint();
        point += pointToAdd;
        completeListOfPlayers.get(indexOfActivePlayer).setPoint(point);
        System.out.println("Points: " + point);
        playedRounds.get(playedRounds.size()-1).setSucceded(true);
        indexOfActivePlayer++;
        System.out.println("Player "+playedRounds.get(playedRounds.size()-1).getPlayer().getName()+
                " Point "+playedRounds.get(playedRounds.size()-1).getChallenge().getPoint()+" Succeeded = "+playedRounds.get(playedRounds.size()-1).isSucceded());

    }

    public void failedChallenge() {
        playedRounds.get(playedRounds.size()-1).setSucceded(false);
        indexOfActivePlayer++;
        System.out.println("Player "+playedRounds.get(playedRounds.size()-1).getPlayer().getName()+
                " Point "+playedRounds.get(playedRounds.size()-1).getChallenge().getPoint()+" Succeeded = "+playedRounds.get(playedRounds.size()-1).isSucceded());
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
        // endast för att printa och se att det funkar
        for (int i = 0; i<cats.size(); i++) {
            System.out.println(cats.get(i).getName());
            System.out.println(cats.get(i).isActive());
        }

    }

    public boolean atLeastOneCategoryChosen() {
        boolean b = false;
        for (Category c : cats)
        if (c.isActive()) {
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
        System.out.println("GAMEROUND HERE -->"+playedRounds);
        System.out.println(playedRounds.size());
        System.out.println(playedRounds.toString());
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
