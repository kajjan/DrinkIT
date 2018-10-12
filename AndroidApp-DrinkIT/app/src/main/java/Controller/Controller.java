package Controller;

import Model.DrinkIT;

public class Controller {
    DrinkIT model;

    public Controller(DrinkIT model) {
        this.model = model;
    }


    //methods
/*    public void setChallengeInstruction(String category, String catInstruction){
        model.createCategory(category, catInstruction);                             //ÄNDRA NAMN!!
    }

    public void setChallenge(String category, String challenge){
        model.setListOfChallenges(category, challenge);
    }
    */
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

    public String getNextChallenge(){
        return model.getNextChallenge();
    }

    public String getInstructions(){
        return model.getInstructions();
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
