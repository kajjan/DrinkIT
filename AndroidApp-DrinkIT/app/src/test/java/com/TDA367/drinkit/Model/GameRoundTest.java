package com.TDA367.drinkit.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameRoundTest {

    List<Player> completeListOfPlayers = new ArrayList<>();
    List<Category> cats = new ArrayList<>();
    List<GameRound> playedRounds = new ArrayList<>();
    List<String> challengesOne = new ArrayList<>();
    List<String> challengesTwo = new ArrayList<>();
    Category neverHaveIever;
    Category ToD;
    DrinkIT model;


    Player firstPlayer = new Player ("firstPlayer");
    Player secondPlayer = new Player ("Captain America");
    Player thirdPlayer = new Player ("Severus Snape");


    public GameRoundTest() {
        completeListOfPlayers.add(firstPlayer);
        completeListOfPlayers.add(secondPlayer);
        completeListOfPlayers.add(thirdPlayer);

        challengesOne.add("test1");
        challengesOne.add("test2");
        challengesTwo.add("test3");
        challengesTwo.add("test4");

        neverHaveIever = CategoryFactory.createCategory("NeverHaveIEver", "this is an instruction", challengesOne);
        ToD = CategoryFactory.createCategory("TruthOrDare", "this is an instruction", challengesTwo);

        cats.add(neverHaveIever);
        cats.add(ToD);

        model = new DrinkIT(null, 0, completeListOfPlayers,
                null, 0, cats, 0, playedRounds, null,
                null, null);
    }

    public boolean playerNotInGameRounds(Player p, List<GameRound> r){
        for(GameRound gr: r){
            if(gr.getPlayer()==p){
                return false;
            }
        }return true;
    }


    @Test
    public void addGameRound(){
        model.addGameRound();

        assert(playedRounds.size()==1);
        assert(playedRounds.get(0).getPlayer()==firstPlayer);
        assert(!playerNotInGameRounds(firstPlayer,playedRounds));
        assert(playerNotInGameRounds(secondPlayer,playedRounds));
        assert(playedRounds.get(0).getChallenge()==cats.get(0).getActiveChallenge());

        model.setIndexOfActiveCategory(1);
        model.setIndexOfActivePlayer(1);

        model.addGameRound();

        assert(playedRounds.size()==2);
        assert(!playerNotInGameRounds(secondPlayer,playedRounds));
        assert(playerNotInGameRounds(thirdPlayer,playedRounds));
        assert(playedRounds.get(1).getChallenge()==cats.get(1).getActiveChallenge());


    }

}
