package com.TDA367.drinkit.Controller;

import java.util.List;

import com.TDA367.drinkit.Model.Category;
import com.TDA367.drinkit.Model.Challenge;
import com.TDA367.drinkit.Model.DrinkIT;

/**
 * As part of the MVC pattern this is the controller of the application. It takes input from the views and calls
 * on methods in the model.
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class Controller {
    DrinkIT model;

    public Controller(DrinkIT model) {
        this.model = model;
    }

    public void initiateGame() {
        model.initiateGame();
    }

    public void addPlayer(String player) {
        model.addPlayer(player);
    }

    public List<String> getAllPlayerNames() { List<String> playerNames = model.getAllPlayerNames(); return playerNames; }

    public void removePlayerDuringGame(String playerName) { model.removePlayerDuringGame(playerName); }

    public void addPlayerDuringGame(String playerName) {
        model.addPlayerDuringGame(playerName);
    }

    public void setDuration(int duration) {
        model.setNumberOfRounds(duration);
    }

    public String getNameOfPlayer() {
        return model.getNameOfPlayer();
    }

    public String getNextCategory() {
        return model.getNextCategory();
    }

    public String getCurrentCategory() {
        return model.getCurrentCategory();
    }

    public String getInstructions() {
        return model.getInstructions();
    }

    public List<String> getCategoryNames() { List<String> categoryNames = model.getCategoryNames(); return categoryNames; }

    public void failedChallenge() {
        model.failedChallenge();
    }

    public void succeededChallenge() {
        model.succeededChallenge();
    }

    public void chooseCategory(String category) { //ändra i samband med activiteten
        model.chooseCategory(category);
    }

    public String getScoreBoard() {
        return model.getScoreBoardText();
    }

    public String getActiveCategory() {
        return model.getActiveCategory();
    }

    public boolean nextRound() {
        return model.nextRound();
    }

    public void endTheGame() {
        model.clearTheGame();
    }

    public void setTruthChallenge() {
        model.setTruthChallenge();
    }

    public void setDareChallenge() {
        model.setDareChallenge();
    }

    public String getActiveChallenge() {
        return model.getActiveChallenge();
    }

    public String getActiveChallengesAnswer() { return model.getActiveChallengesAnswer(); }

    public int getActiveChallengePoints() {
        return model.getActiveChallengePoints();
    }

    public boolean buttonActive(int i) {
        return model.buttonActive(i);
    }

    public boolean atLeastOneCategoryChosen(){ return model.atLeastOneCategoryChosen();}

    public Challenge createChallenge(String challengeText, String answerText, int point) { return model.createChallenge(challengeText, answerText, point); }

    public Category createCategory(String name, String description, List<Challenge> challenges) { return model.createCategory(name, description, challenges); }
}
