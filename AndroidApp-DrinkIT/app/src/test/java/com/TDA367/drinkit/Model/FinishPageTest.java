package com.TDA367.drinkit.Model;

import org.junit.Test;

import com.TDA367.drinkit.Model.Category;
import com.TDA367.drinkit.Model.Challenge;
import com.TDA367.drinkit.Model.DrinkIT;
import com.TDA367.drinkit.Model.Player;

import java.util.ArrayList;
import java.util.List;


public class FinishPageTest {

    List<Player> playersList = new ArrayList<>();
    Player player1 = new Player("Emil");
    Player player2 = new Player("Ida");


    Challenge challenge = new Challenge("here is the first challenge", "here is the anser", 0);
    Challenge challenge1 = new Challenge("here is the second challenge", "here is the anser", 0);


    List<Category> cats = new ArrayList<>();
    List<Challenge> challenges = new ArrayList<>();

    @Test
    public void nextRound() {
        playersList.add(player1);
        playersList.add(player2);

        int i = playersList.size();
        challenges.add(challenge);
        challenges.add(challenge1);

        Category truthOrDare = new Category("TruthOrDare", "Here are the instructions for this category", challenges);
        Category truthOrDare1 = new Category("TruthOrDare", "Here are the instructions for this category", challenges);

        cats.add(truthOrDare);
        cats.add(truthOrDare1);

        DrinkIT drinkIT = new DrinkIT(playersList, 0, 0, cats, 0);

        drinkIT.setNumberOfRounds(3);

        drinkIT.succeededChallenge();
        drinkIT.succeededChallenge();
        drinkIT.succeededChallenge();
        drinkIT.succeededChallenge();
        drinkIT.succeededChallenge();


        assert (drinkIT.nextRound());

        drinkIT.failedChallenge();
        drinkIT.failedChallenge();
        drinkIT.succeededChallenge();
        drinkIT.succeededChallenge();

        assert (!drinkIT.nextRound());
    }

    @Test
    public void clearTheGameTest() {

        playersList.add(player1);
        playersList.add(player2);

        int i = playersList.size();
        challenges.add(challenge);
        challenges.add(challenge1);

        Category truthOrDare = new Category("TruthOrDare", "how to play", challenges);
        Category truthOrDare1 = new Category("TruthOrDare", "how to play", challenges);

        cats.add(truthOrDare);
        cats.add(truthOrDare1);

        DrinkIT drinkIT = new DrinkIT(playersList, 0, 0, cats, 0);

        drinkIT.setNumberOfRounds(3);
        drinkIT.putListInPointOrder();
        drinkIT.clearTheGame();


        List<Player> players = drinkIT.getPlayers();
        cats = drinkIT.getCategories();
        int indexOfActivePlayer = drinkIT.getIndexOfActivePlayer();
        int numberOfRounds = drinkIT.getNumberOfRounds();
        int indexOfActiveCategory = drinkIT.getIndexOfActiveCategory();

        assert (playersList.isEmpty());
        assert (players.isEmpty());
        assert (indexOfActivePlayer == 0);
        assert (numberOfRounds == 0);
        assert (indexOfActiveCategory == -1);
        assert (cats.isEmpty());
    }
}
