package com.TDA367.drinkit.Model;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;


public class DurationTest {

    @Test
    public void durationTest(){

        List<Player> playerlist = new ArrayList<>();

        DrinkIT model = new DrinkIT(playerlist);
        model.addPlayer("one");
        model.addPlayer("two");
        model.addPlayer("three");
        int duration = 3;

        model.setNumberOfRounds(duration);


        System.out.println("List size: "+playerlist.size());
        System.out.println("Duration: "+duration);
        System.out.println("Duration of the game: "+model.getNumberOfRounds());
        assert(model.getNumberOfRounds()==9);
        assert(model.getNumberOfRounds()!=duration);

    }
}