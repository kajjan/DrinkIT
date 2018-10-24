package com.TDA367.drinkit.View;

import org.junit.Test;

import com.TDA367.drinkit.Model.Category;
import com.TDA367.drinkit.Model.CategoryFactory;
import com.TDA367.drinkit.Model.Challenge;
import com.TDA367.drinkit.Model.ChallengeFactory;
import com.TDA367.drinkit.Model.DrinkIT;
import com.TDA367.drinkit.Model.GameRound;
import com.TDA367.drinkit.Model.Player;
import java.util.ArrayList;
import java.util.List;


public class FinishPageTest {

    List<Player> playersList = new ArrayList<>();
    Player player1 = new Player("Emil");
    Player player2 = new Player("Ida");


    Challenge challenge = ChallengeFactory.createChallenge("Truth or Dare", "here lies a challenge 1");
    Challenge challenge1 = ChallengeFactory.createChallenge("Truth or Dare", "here lies another one 2");

    GameRound gameRound = new GameRound(player1, challenge);
    GameRound gameRound1 = new GameRound(player2, challenge1);


    List<Category> cats = new ArrayList<>();
    List<GameRound> playedRounds = new ArrayList<>();
    List<String> challenges = new ArrayList<>();
    List<String>completeListOfPlayerNames= new ArrayList<>();
    String activeChallenge;
    Boolean a= true;

   @Test
    public void nextRound(){
       playersList.add(player1);
       playersList.add(player2);

       int i = playersList.size();
       challenges.add("here is the challenge 1");
       challenges.add("here is a challenge 2");

       Category truthOrDare = CategoryFactory.createCategory("TruthOrDare", "how to play", challenges);
       Category truthOrDare1 = CategoryFactory.createCategory("TruthOrDare", "how to play", challenges);

       //TruthOrDareCategory truthOrDare = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a);
       //TruthOrDareCategory truthOrDare1 = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a );

       cats.add(truthOrDare);
       cats.add(truthOrDare1);


       DrinkIT drinkIT = new DrinkIT(playersList, 0, null, 0, cats, 0, playedRounds);

       drinkIT.setNumberOfRounds(3);
       //drinkIT.createCompletedPlayersList();

       playedRounds.add(gameRound);
       playedRounds.add(gameRound1);
       playedRounds.add(gameRound);
       playedRounds.add(gameRound1);
       playedRounds.add(gameRound);


       assert(drinkIT.nextRound());

       drinkIT.failedChallenge();
       drinkIT.failedChallenge();
       drinkIT.succeededChallenge();
       drinkIT.succeededChallenge();

       assert(!drinkIT.nextRound());

    }

    @Test
    public void clearTheGameTest() {

        playersList.add(player1);
        playersList.add(player2);

        int i = playersList.size();
        challenges.add("here is the challenge 1");
        challenges.add("here is a challenge 2");

        Category truthOrDare = CategoryFactory.createCategory("TruthOrDare", "how to play", challenges);
        Category truthOrDare1 = CategoryFactory.createCategory("TruthOrDare", "how to play", challenges);

        //TruthOrDareCategory truthOrDare = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a);
        //TruthOrDareCategory truthOrDare1 = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a);

        cats.add(truthOrDare);
        cats.add(truthOrDare1);
        List<String>playerInPointOrder1= new ArrayList<>();

        DrinkIT drinkIT = new DrinkIT(playersList, 0, playerInPointOrder1, 0, cats, 0, playedRounds);

        drinkIT.setNumberOfRounds(3);
        drinkIT.putListInPointOrder();
        drinkIT.clearTheGame();


        List<Player>players=drinkIT.getPlayers();
        cats=drinkIT.getCategories();
        int indexOfActivePlayer= drinkIT.getIndexOfActivePlayer();
        int numberOfRounds=drinkIT.getNumberOfRounds();
        int indexOfActiveCategory=drinkIT.getIndexOfActiveCategory();

        assert (playersList.isEmpty());
        assert (players.isEmpty());
        assert (indexOfActivePlayer==0);
        assert (numberOfRounds==0);
        assert (indexOfActiveCategory==-1);
        assert (playedRounds.isEmpty());
        assert (cats.isEmpty());
    }
}
