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

    Player firstPlayer = new Player("Zlatan");
    Player secondPlayer = new Player("Captain America");
    Player thirdPlayer = new Player("Severus Snape");


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

        model = new DrinkIT(players, 0, 0, cats, 0);
    }

    public boolean playerNotInGameRounds(Player p, List<GameRound> r) {
        for (GameRound gr : r) {
            if (gr.getPlayer() == p) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void addGameRound() {
        players.clear();
        players.add(firstPlayer);
        players.add(secondPlayer);


        neverHaveIever = new Category("NeverHaveIEver", "this is an instruction", challengesOne);
        ToD = new Category("TruthOrDare", "this is an instruction", challengesTwo);

        cats.clear();
        cats.add(neverHaveIever);
        cats.add(ToD);

        GameRound gameRound1 = new GameRound(firstPlayer, neverHaveIever.getActiveChallenge());
        GameRound gameRound2 = new GameRound(secondPlayer, ToD.getActiveChallenge());

        challengesOne.add(new Challenge("test1", null, 2));
        challengesTwo.add(new Challenge("test2", null, 5));

        playedRounds.add(gameRound1);
        playedRounds.add(gameRound2);

        DrinkIT drinkIT = new DrinkIT(players, 0, 0, cats, 0);


        drinkIT.succeededChallenge(); //Increases the Point of player redViper.
        drinkIT.succeededChallenge();


        assert (playedRounds.size() == 2);
        assert (!playerNotInGameRounds(secondPlayer, playedRounds));
        assert (playerNotInGameRounds(thirdPlayer, playedRounds));
        assert (playedRounds.get(1).getChallenge() == cats.get(1).getActiveChallenge());
    }

    @Test
    public void isAlreadyPlayedTest() {
        players.clear();
        players.add(firstPlayer);
        players.add(secondPlayer);


        neverHaveIever = new Category("NeverHaveIEver", "this is an instruction", challengesOne);
        ToD = new Category("TruthOrDare", "this is an instruction", challengesTwo);

        cats.clear();
        cats.add(neverHaveIever);
        cats.add(ToD);

        GameRound gameRound1 = new GameRound(firstPlayer, neverHaveIever.getActiveChallenge());
        GameRound gameRound2 = new GameRound(secondPlayer, ToD.getActiveChallenge());

        challengesOne.add(new Challenge("test1", null, 2));
        challengesTwo.add(new Challenge("test2", null, 5));

        playedRounds.add(gameRound1);
        playedRounds.add(gameRound2);

        DrinkIT drinkIT = new DrinkIT(players, 0, 0, cats, 0);


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
