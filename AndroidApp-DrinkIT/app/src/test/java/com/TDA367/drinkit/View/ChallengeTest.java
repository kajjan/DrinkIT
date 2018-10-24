package com.TDA367.drinkit.View;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import com.TDA367.drinkit.Model.Category;
import com.TDA367.drinkit.Model.DrinkIT;
import com.TDA367.drinkit.Model.Player;
import com.TDA367.drinkit.Model.GameRound;
import com.TDA367.drinkit.Model.Challenge;


public class ChallengeTest {
   List<Player> playersList = new ArrayList<>();
    Player noOne = new Player("Arya Stark");
    Player khaleesi = new Player("Denaerys Targaryen");
    Player redViper = new Player("Oberyn Martell");

    Challenge challenge = new Challenge("Truth or dare challenge 1 here", null, 0);
    Challenge challenge1 = new Challenge("Truth or dare challenge 2 here", null, 0);

    GameRound gameRound = new GameRound(redViper, challenge);
    GameRound gameRound1 = new GameRound(redViper, challenge1);
    GameRound gameRound2 = new GameRound(noOne, challenge1);


    List<Category> cats = new ArrayList<>();
    List<GameRound> playedRounds = new ArrayList<>();
    List<Challenge> challengeList = new ArrayList<>();
    boolean a = true;


    @Test
    public void failedChallenge(){
        playersList.add(noOne);
        playersList.add(khaleesi);
        playersList.add(redViper);
        challengeList.add(challenge);
        challengeList.add(challenge1);

        Category truthOrDare = new Category("Truth or dare", "how to play", challengeList);
        Category truthOrDare1 = new Category("Truth or dare", "how to play", challengeList);

        cats.add(truthOrDare);
        cats.add(truthOrDare1);

        playedRounds.add(gameRound);
        playedRounds.add(gameRound1);

        DrinkIT drinkIT = new DrinkIT(playersList, 0, null, 2, cats, 0, playedRounds, null);

        cats.add(truthOrDare);
        cats.add(truthOrDare1);


        drinkIT.failedChallenge();//don't give the player a point for the game

        int pointsNoOne = noOne.getPoint();
        int pointsRedViper = redViper.getPoint();
        int khaleesiPoint = khaleesi.getPoint();

        assert(pointsNoOne==0);
        assert (pointsRedViper==0);
        assert(khaleesiPoint==0);
    }

    @Test //Test to see if Point setting works.
    public void succeededChallenge() {
        playersList.add(noOne);
        playersList.add(khaleesi);
        playersList.add(redViper);
        challengeList.add(challenge);
        challengeList.add(challenge1);

        Category truthOrDare = new Category("Truth or dare", "how to play", challengeList);
        Category truthOrDare1 = new Category("Truth or dare", "how to play", challengeList);

        cats.add(truthOrDare);
        cats.add(truthOrDare1);

        playedRounds.add(gameRound);
        playedRounds.add(gameRound1);
        playedRounds.add(gameRound2);

        DrinkIT drinkIT = new DrinkIT(playersList, 0, null, 2, cats, 0, playedRounds, null);

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
