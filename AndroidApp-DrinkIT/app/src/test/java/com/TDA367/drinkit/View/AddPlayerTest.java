package com.TDA367.drinkit.View;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import com.TDA367.drinkit.Model.DrinkIT;
import com.TDA367.drinkit.Model.Player;
import com.TDA367.drinkit.Controller.Controller;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddPlayerTest {
    String name = "Viktoria";
    String name2 = "Kajsa";
    boolean b = false;
    boolean c = true;
    boolean d = true;
    List<Player> playersList = new ArrayList<>();
    int initialLength = playersList.size();
    int countName = 0;

    Player noOne = new Player("Arya Stark");
    Player khaleesi = new Player("Daenerys Targaryen");
    Player redViper = new Player("Oberyn Martell");

    DrinkIT model = new DrinkIT(playersList);
    Controller ctrl = new Controller(model);

    @Test
    public void addPlayer() {
        model.addPlayer(name);

        for (String s : model.getPlayerNames()) {
            if (name.equals(s)) {        //Checks if name exists in list
                b = true;
                countName++;
            }
            if (name2.equals(s)) {       //Check that name who's not added does not exist in list
                c = false;
            }
        }
        int endLength = playersList.size();

        assert (b);
        assert (c);
        assert (countName == 1);           //Name only exists once in list of players
        assert (initialLength + 1 == endLength);
    }


    @Test
    public void testPutListInOrder() {

        playersList.add(khaleesi);
        playersList.add(noOne);
        playersList.add(redViper);

        noOne.setPoint(3);
        khaleesi.setPoint(2);
        redViper.setPoint(0);

         List<String> playersInPointOrder = new ArrayList<>();
         List<Player> testList = new ArrayList<>();

        DrinkIT drinkit = new DrinkIT(playersList, 0, playersInPointOrder,0, null, 0, null, null);

            drinkit.putListInPointOrder();

            testList.add(noOne);
            testList.add(khaleesi);
            testList.add(redViper);

            testList.toString();
            playersInPointOrder.toString();

          //  assert(playersInPointOrder.equals(testList)); //TODO FIX HERE


        System.out.println(playersInPointOrder.toString());

        }

    }


