package com.TDA367.drinkit.Model;

/**
 * This is the GameRound class which connects a Player and a Challenge to make a GameRound
 *
 *  @authors Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

import java.util.ArrayList;
import java.util.List;

public class GameRound {

    private Player player;
    private Challenge challenge;
    private boolean succeded;
    private static List<GameRound>playedRounds= new ArrayList<>();

    public GameRound(Player player, Challenge challenge) {
        this.player = player;
        this.challenge = challenge;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public void setSucceded(boolean succeded) {
        this.succeded = succeded;
    }

    public void addPlayedRound(GameRound gameRound){
        playedRounds.add(gameRound);
    }

    public List<GameRound> getPlayedRounds() {
        return playedRounds;
    }
}
