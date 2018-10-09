package com.example.drinkit.drinkit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import Controller.Controller;
import Model.DrinkIT;
import Model.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AddPlayerTest {
    String name = "Viktoria";
    String name2 = "Kajsa";
    String name3 = "Alice";
    boolean b = false;
    boolean c = true;
    boolean d = true;
    List<Player> playersList = new ArrayList<>();
    int initialLength = playersList.size();
    int countName = 0;

    Player noOne = new Player("Arya Stark");
    Player khaleesi = new Player("Daenerys Targaryen");
    Player redViper = new Player("Oberyn Martell");

    DrinkIT model = new DrinkIT(playersList, null, null);
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

    @Test //Tests if the list expands to the right size based duration
    public void createCompleteListOfPlayers() {
        //int duration = 3;
        //int duration = 5;
        int duration = 10;
        Player galadriel = new Player("Galadriel");
        Player arwen = new Player("Arwen");
        Player aragorn = new Player("Aragorn");
        Player elrond = new Player("Lord Elrond");

        playersList.add(galadriel);
        playersList.add(arwen);
        playersList.add(aragorn);
        playersList.add(elrond);

        duration = playersList.size() * duration; //Copied method setDuration()

        model.createCompletedPlayersList(playersList, duration);

        int endlenght = model.getCompleteListOfPlayers().size();

       // assert (endlenght == 12);
       // assert(endlenght == 20);
        assert(endlenght == 40);

    }

    @Test
    public void setPointOfPlayer(){

    playersList.add(noOne);
    playersList.add(khaleesi);
    playersList.add(redViper);

    int index = 2;

    model.setPointOfPlayer(playersList, index);
    //Should increase point of Player on index index in list of players

    int points = redViper.getPoint();

    assert(points==1);

    }

    @Test
    public void getScoreBoardText(){

     playersList.add(noOne);
     playersList.add(khaleesi);
     playersList.add(redViper);

     noOne.setPoint(3);
     khaleesi.setPoint(2);
     redViper.setPoint(0);


 }






}