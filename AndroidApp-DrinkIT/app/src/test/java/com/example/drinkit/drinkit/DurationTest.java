package com.example.drinkit.drinkit;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;
import Model.DrinkIT;
import Model.Player;

public class DurationTest {

    @Test
    public void durationTest(){

        List<Player> playerlist = new ArrayList<>();

        DrinkIT model = new DrinkIT(playerlist, null, null);
        model.addPlayer("one");
        model.addPlayer("two");
        model.addPlayer("three");
        int duration = 3;

        model.setDuration(playerlist, duration);

        int newDuration = duration*playerlist.size();

        System.out.println("List size: "+playerlist.size());
        System.out.println("Duration: "+duration);
        System.out.println("Duration of the game: "+model.getDurationOfGame());
        assert(model.getDurationOfGame()==9);
        assert(model.getDurationOfGame()!=duration);

    }
}