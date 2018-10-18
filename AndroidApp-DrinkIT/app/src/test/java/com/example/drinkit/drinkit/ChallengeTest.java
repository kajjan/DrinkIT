package com.example.drinkit.drinkit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import Model.Category;
import Model.Challenge;
import Model.ChallengeFactory;
import Model.DrinkIT;
import Model.GameRound;
import Model.Player;
import Model.TruthOrDareCategory;

public class ChallengeTest {
    List<Player> playersList = new ArrayList<>();
    Player noOne = new Player("Arya Stark");
    Player khaleesi = new Player("Denaerys Targaryen");
    Player redViper = new Player("Oberyn Martell");

    Challenge challenge = ChallengeFactory.createChallenge("truthOrDare", "here lies a challenge 1");
    Challenge challenge1 = ChallengeFactory.createChallenge("truthOrDare", "here lies another one 2");

    GameRound gameRound = new GameRound(redViper, challenge);
    GameRound gameRound1 = new GameRound(redViper, challenge1);
    GameRound gameRound2 = new GameRound(noOne, challenge1);


    List<Category> cats = new ArrayList<>();
    List<GameRound> playedRounds = new ArrayList<>();
    List<String> challenges = new ArrayList<>();
    boolean a = true;


    @Test
    public void failedChallenge(){

        playedRounds.add(gameRound);
        playedRounds.add(gameRound1);
        playedRounds.add(gameRound2);

        playersList.add(noOne);
        playersList.add(khaleesi);
        playersList.add(redViper);

        DrinkIT drinkIT = new DrinkIT(null, 0, null,
                null, 1, null, 0,
                playedRounds, null, null,
                null, null, null);

        khaleesi.setPoint(1);
        drinkIT.failedChallenge();
        int khaleesiPoint = khaleesi.getPoint();


        assert(khaleesiPoint==1);
    }

    @Test //Test to see if Point setting works.
    public void succeededChallenge() {

        playersList.add(noOne);
        playersList.add(khaleesi);
        playersList.add(redViper);
        challenges.add("here is the challenge 1");
        challenges.add("here is a challenge 1");

        TruthOrDareCategory truthOrDare = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a);
        TruthOrDareCategory truthOrDare1 = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a );

        cats.add(truthOrDare);
        cats.add(truthOrDare1);

        playedRounds.add(gameRound);
        playedRounds.add(gameRound1);
        playedRounds.add(gameRound2);

        DrinkIT drinkIT = new DrinkIT(null, 0, playersList, null, 2,
                cats, 0, playedRounds, null, null,
                null, null, null);

        drinkIT.succeededChallenge(); //Increases the Point of player redViper.

        int pointsRedViper = redViper.getPoint();
        System.out.println(pointsRedViper);
        int pointsNoOne = noOne.getPoint();
        int pointsKhaleesi = khaleesi.getPoint();


        assert (pointsRedViper == 1);
        assert (pointsKhaleesi == 0);
        assert (pointsNoOne == 0);


    }

}
