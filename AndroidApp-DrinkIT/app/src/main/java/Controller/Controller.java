package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.DrinkIT;

public class Controller {
    DrinkIT model;

    public Controller(DrinkIT model) {
        this.model = model;
    }

    public void addPlayer(String player) {
        model.addPlayer(player);
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

    List<String> categoryNames = new ArrayList<>();

    public List<String> getCategories() {
        categoryNames = model.getCategoryNames();
        return categoryNames;
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

    public void setTruthChallenge(){
        model.setTruthChallenge();
    }

    public void setDareChallenge(){
        model.setDareChallenge();
    }


    public String getActiveChallenge() {
        return model.getActiveChallenge();
    }

    public String getActiveChallengesAnswer() {
        return model.getActiveChallengesAnswer();
    }
}
