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
    String name="Viktoria";
    String name2="Kajsa";
    boolean b = false;
    boolean c = true;
    boolean d = true;
    List<Player> playersList=new ArrayList<>();
    int initialLength = playersList.size();
    int countName = 0;

    DrinkIT model= new DrinkIT(playersList, null,null);

    @Test
    public void addPlayer() {
        model.addPlayer(name);

        for(String s:model.getPlayerNames()){
            if (name.equals(s)){        //Checks if name exists in list
                b=true;
                countName++;
            }
            if (name2.equals(s)){       //Check that name who's not added does not exist in list
                c=false;
            }
        }
        int endLength = playersList.size();

        assert(b);
        assert(c);
        assert(countName==1);           //Name only exists once in list of players
        assert(initialLength+1==endLength);
    }





}