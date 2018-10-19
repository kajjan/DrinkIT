package com.TDA367.drinkit.View;

import org.junit.Test;

import com.TDA367.drinkit.Model.Category;
import com.TDA367.drinkit.Model.Challenge;
import com.TDA367.drinkit.Model.ChallengeFactory;
import com.TDA367.drinkit.Model.DrinkIT;
import com.TDA367.drinkit.Model.GameRound;
import com.TDA367.drinkit.Model.Player;

import com.TDA367.drinkit.Model.TruthOrDareCategory;

import java.util.ArrayList;
import java.util.List;

public class FinishPageTest {

    DrinkIT model = new DrinkIT();
    List<Player> playersList = new ArrayList<>();
    Player player1 = new Player("Emil");
    Player player2 = new Player("Ida");
    Player player3 = new Player("Klas");



    Challenge challenge = ChallengeFactory.createChallenge("truthOrDare", "here lies a challenge 1");
    Challenge challenge1 = ChallengeFactory.createChallenge("truthOrDare", "here lies another one 2");

    GameRound gameRound = new GameRound(player1, challenge);
    GameRound gameRound1 = new GameRound(player2, challenge1);
    GameRound gameRound2 = new GameRound(player1, challenge1);


    List<Category> cats = new ArrayList<>();
    List<GameRound> playedRounds = new ArrayList<>();
    List<String> challenges = new ArrayList<>();
    Boolean a= true;



    @Test
    public void finishPageTest () {

        //hej vickan, hoppas det funkar nu 

    }

   @Test
    public void nextRound(){
       playersList.add(player1);
       playersList.add(player2);

       int i = playersList.size();
       challenges.add("here is the challenge 1");
       challenges.add("here is a challenge 2");

       TruthOrDareCategory truthOrDare = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a);
       TruthOrDareCategory truthOrDare1 = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a );

       cats.add(truthOrDare);
       cats.add(truthOrDare1);



       DrinkIT drinkIT = new DrinkIT(playersList, 0, null, 0,
               cats, 0, playedRounds, null, null,
               null, null);

       drinkIT.setNumberOfRounds(3);
       drinkIT.createCompletedPlayersList();

       playedRounds.add(gameRound);
       playedRounds.add(gameRound1);
       playedRounds.add(gameRound);
       playedRounds.add(gameRound1);
       playedRounds.add(gameRound);
       playedRounds.add(gameRound1);
       playedRounds.add(gameRound1);

       drinkIT.failedChallenge();
       drinkIT.failedChallenge();

       assert(drinkIT.nextRound());

       drinkIT.failedChallenge();
       drinkIT.failedChallenge();
       drinkIT.succeededChallenge();
       drinkIT.succeededChallenge();
       assert(!drinkIT.nextRound());

    }

    @Test
    public void endTheGame() {

        playersList.add(player1);
        playersList.add(player2);

        int i = playersList.size();
        challenges.add("here is the challenge 1");
        challenges.add("here is a challenge 2");

        TruthOrDareCategory truthOrDare = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a);
        TruthOrDareCategory truthOrDare1 = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a);

        cats.add(truthOrDare);
        cats.add(truthOrDare1);


        DrinkIT drinkIT = new DrinkIT(playersList, 0, null, 0,
                cats, 0, playedRounds, null, null,
                null, null);

        drinkIT.setNumberOfRounds(3);
        drinkIT.createCompletedPlayersList();


        drinkIT.endTheGame();
        assert (playersList.isEmpty());









    }
}
