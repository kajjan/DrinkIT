package com.TDA367.drinkit.Controller;

import java.util.ArrayList;
import java.util.List;

import com.TDA367.drinkit.Model.DrinkIT;

public class Controller {
    DrinkIT model;

    public Controller(DrinkIT model) {
        this.model = model;
    }

    public void addPlayer(String player) {
        model.addPlayer(player);
    }

    public List<String> getAllPlayerNames() {
        List<String> playerNames = new ArrayList<>(10);
        playerNames = model.getAllPlayerNames();
        return playerNames;
    }

    public void setDuration(int duration){
        model.setNumberOfRounds(duration);
    }

    public String getPlayersName(){
            return model.getNameOfPlayer();
    }

    public String getNextCategory(){
        return model.getNextCategory();
    }

    public String getInstructions(){
        return model.getInstructions();
    }

    public void createCompleteListOfPlayers(){
        model.createCompletedPlayersList();
    }


    public List<String> getCategories() {
        List<String> categoryNames;
        categoryNames = model.getCategoryNames();
        return categoryNames;
    }

    public List<String> getPresentableCategoryNames() {
        List<String> presentableCategoryNames;
        presentableCategoryNames = model.getPresentableCategoryNames();
        return presentableCategoryNames;
    }

    public List<String> getCompleteListOfPlayersNames() {
        List<String> completePlayersNames;
        completePlayersNames = model.getCompleteListOfPlayersNames();
        return completePlayersNames;
    }

    public void failedChallenge() {
        model.failedChallenge();
    }

    public void succeededChallenge(){
        model.succeededChallenge();
    }


    public void chooseCategory(String category) { //ändra i samband med activiteten
        model.chooseCategory(category);
    }

    public String getScoreBoard(){
        return model.getScoreBoardText();

    }

    public boolean atLeastOneCategoryChosen() {
        boolean b = false;
        model.atLeastOneCategoryChosen();
        return b;
    }

    public boolean nextRound(){
        return model.nextRound();
    }

    public void endTheGame(){
        model.endTheGame();
    }


    public String getActiveChallenge() {
        return model.getActiveChallenge();
    }

    public String getActiveChallengesAnswer() {
        return model.getActiveChallengesAnswer();
    }
}
