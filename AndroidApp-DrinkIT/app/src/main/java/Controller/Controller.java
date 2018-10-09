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

    public boolean categoryListEmpty(){
        return model.categoryListEmpty();
    }

    public void setDuration(int duration){
        model.setNumberOfRounds(duration);
    }


    public String getPlayersName(){
            return model.getNameOfPlayer();
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


    //just nu kan vi inte starta om spelet så allt funkar när jag tagit bort saker som är static... klurar på en lösning med det!!
    public void endTheGame(){
        model.endTheGame();
    }


}
