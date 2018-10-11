package Controller;

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

    public String getNextChallenge(){
        return model.getNextChallenge();
    }

    public void createCompleteListOfPlayers(){
        model.createCompletedPlayersList();
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

    public boolean nextRound(){
        return model.nextRound();
    }

    public void endTheGame(){
        model.endTheGame();
    }


}
