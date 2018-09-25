package com.example.drinkit.drinkit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import Model.DrinkIT;
import Model.Player;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AddPlayerTest {

    @Test
    public void addPlayer() {

        String name="Viktoria";
        boolean b = false;
        List<Player> playersList=new ArrayList<>();
        int initialLength = playersList.size();

        DrinkIT model= new DrinkIT(playersList, null,null);
        model.addPlayer(name);

        for(String s:model.getPlayerNames()){
            if (name.equals(s)){
                b=true;
            }
        }
        int endLength = playersList.size();

        assert(b);
        assert(initialLength+1==endLength);
    }


}