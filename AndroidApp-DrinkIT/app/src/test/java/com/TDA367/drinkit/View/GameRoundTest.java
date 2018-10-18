package com.TDA367.drinkit.View;

import com.TDA367.drinkit.Model.Category;
import com.TDA367.drinkit.Model.DrinkIT;
import com.TDA367.drinkit.Model.GameRound;
import com.TDA367.drinkit.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameRoundTest {

    List<Player> completeListOfPlayers = new ArrayList<>();
    List<Category> cats = new ArrayList<>();
    List<GameRound> playedRounds = new ArrayList<>();

    DrinkIT model = new DrinkIT(null, 0, completeListOfPlayers,
            null, 0, cats, 0, playedRounds, null,
            null, null, null, null);



    /*public DrinkIT(List<Player> players, int numberOfRounds, List<Player> completeListOfPlayers,
                   List<String> playerInPointOrder, int indexOfActivePlayer, List<Category> cats,
                   int indexOfActiveCategory, List<GameRound> playedRounds, String activeChallenge,
                   List<String> categoryNames, List<String> completelistOfPlayerNames,
                   List<Category> categories, List<String> playerList) {*/
}
