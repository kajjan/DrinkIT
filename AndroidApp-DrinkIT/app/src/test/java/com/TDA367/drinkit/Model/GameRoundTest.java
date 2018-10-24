package com.TDA367.drinkit.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameRoundTest {

    List<Player> players = new ArrayList<>();
    List<Category> cats = new ArrayList<>();
    List<GameRound> playedRounds = new ArrayList<>();
    List<String> challengesOne = new ArrayList<>();
    List<String> challengesTwo = new ArrayList<>();
    Category neverHaveIever;
    Category ToD;
    DrinkIT model;
    String activeChallenge;

    Player firstPlayer = new Player ("Zlatan");
    Player secondPlayer = new Player ("Captain America");
    Player thirdPlayer = new Player ("Severus Snape");






    public GameRoundTest() {
        players.add(firstPlayer);
        players.add(secondPlayer);
        players.add(thirdPlayer);

        challengesOne.add("test1");
        challengesOne.add("test2");
        challengesTwo.add("test3");
        challengesTwo.add("test4");

        neverHaveIever = CategoryFactory.createCategory("NeverHaveIEver", "this is an instruction", challengesOne);
        ToD = CategoryFactory.createCategory("TruthOrDare", "this is an instruction", challengesTwo);

        cats.add(neverHaveIever);
        cats.add(ToD);

        model = new DrinkIT(players, 0, null, 0,  cats, 0, playedRounds);
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
        model.addGameRound(true);

        assert(playedRounds.size()==1);
        assert(playedRounds.get(0).getPlayer()==firstPlayer);
        assert(!playerNotInGameRounds(firstPlayer,playedRounds));
        assert(playerNotInGameRounds(secondPlayer,playedRounds));
        assert(playedRounds.get(0).getChallenge()==cats.get(0).getActiveChallenge());

        model.setIndexOfActiveCategory(1);
        model.setIndexOfActivePlayer(1);

        model.addGameRound(true);

        assert(playedRounds.size()==2);
        assert(!playerNotInGameRounds(secondPlayer,playedRounds));
        assert(playerNotInGameRounds(thirdPlayer,playedRounds));
        assert(playedRounds.get(1).getChallenge()==cats.get(1).getActiveChallenge());


    }

    @Test
    public void isAlreadyPlayedTest(){
        players.clear();
        players.add(firstPlayer);
        players.add(secondPlayer);


        neverHaveIever = CategoryFactory.createCategory("NeverHaveIEver", "this is an instruction", challengesOne);
        ToD = CategoryFactory.createCategory("TruthOrDare", "this is an instruction", challengesTwo);

        cats.clear();
        cats.add(neverHaveIever);
        cats.add(ToD);

        GameRound gameRound1= new GameRound(firstPlayer, neverHaveIever.getActiveChallenge());
        GameRound gameRound2= new GameRound(secondPlayer, ToD.getActiveChallenge());

        challengesOne.add("test1");
        challengesTwo.add("test2");

        playedRounds.add(gameRound1);
        playedRounds.add(gameRound2);

        DrinkIT drinkIT = new DrinkIT(players, 0, null, 0, cats, 0, playedRounds);


        drinkIT.succeededChallenge(); //Increases the Point of player redViper.
        drinkIT.succeededChallenge();

        System.out.println(cats.get(0).getActiveChallenge().getChallengeText());
        System.out.println(playedRounds.get(0).getChallenge().getChallengeText());
        System.out.println(gameRound1.getPlayedRounds().size());
        System.out.println(firstPlayer.getName());
        System.out.println(neverHaveIever.getActiveChallenge().getChallengeText());
        System.out.println(gameRound1.getPlayedRounds().get(0).getPlayer().getName());
        System.out.println(gameRound1.getPlayedRounds().get(0).getChallenge().getChallengeText());

        assert (model.isAlreadyPlayed(gameRound1));


    }

}
