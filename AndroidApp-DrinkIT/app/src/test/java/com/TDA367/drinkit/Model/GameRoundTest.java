package com.TDA367.drinkit.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameRoundTest {

    List<Player> players = new ArrayList<>();
    List<Category> cats = new ArrayList<>();
    List<GameRound> playedRounds = new ArrayList<>();
    List<Challenge> challengesOne = new ArrayList<>();
    List<Challenge> challengesTwo = new ArrayList<>();
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

        challengesOne.add(new Challenge("Here is a challenge", null, 0));
        challengesOne.add(new Challenge("Here is a second challeng", null, 0));
        challengesTwo.add(new Challenge("Here is a third challeng", null, 0));
        challengesTwo.add(new Challenge("Here is a forth challeng", null, 0));

        neverHaveIever = new Category("NeverHaveIEver", "this is an instruction", challengesOne);
        ToD = new Category("TruthOrDare", "this is an instruction", challengesTwo);

        cats.add(neverHaveIever);
        cats.add(ToD);

        model = new DrinkIT(players, 0, null, 0,  cats, 0, playedRounds, null);
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

    @Test
    public void isAlreadyPlayedTest(){
        model.addGameRound();
        System.out.println(cats.get(0).getActiveChallenge().getChallengeText());
        System.out.println(playedRounds.get(0).getChallenge().getChallengeText());

        System.out.println(model.isAlreadyPlayed(players.get(0), cats.get(0).getActiveChallenge().getChallengeText()));

        assert (playedRounds.get(0).getPlayer()== players.get(0));
    }

}
