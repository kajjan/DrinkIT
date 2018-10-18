package com.example.drinkit.drinkit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import Controller.Controller;
import Model.Category;
import Model.CategoryFactory;
import Model.Challenge;
import Model.ChallengeFactory;
import Model.ChallengeWithAnswer;
import Model.ChallengeWithPoints;
import Model.CharadeCategory;
import Model.DrinkIT;
import Model.GameRound;
import Model.Player;
import Model.QuizCategory;
import Model.TruthOrDareCategory;

import static org.junit.Assert.assertArrayEquals;
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

    @Test //Tests if the list expands to the right size based duration
    public void createCompleteListOfPlayers() {
        Player galadriel = new Player("Galadriel");
        Player arwen = new Player("Arwen");
        Player aragorn = new Player("Aragorn");
        Player elrond = new Player("Lord Elrond");

        List<Player> completeListOfPlayers = new ArrayList<>();

        playersList.add(galadriel);
        playersList.add(arwen);
        playersList.add(aragorn);
        playersList.add(elrond);

        int duration = 3;
        // int duration = 5;
        // int duration = 10;

        DrinkIT drinkit = new DrinkIT(playersList, 0, completeListOfPlayers, null,
                0, null, 0, null, null,
                null, null, null, null);


        drinkit.setNumberOfRounds(duration); //multiplies players size with the chosen duration
        drinkit.createCompletedPlayersList(); //

        int endlenght = completeListOfPlayers.size();

        assert (endlenght == 12);
        //assert(endlenght == 20);
        //assert(endlenght == 40);


    }

}


   /* @Test
    public void testPutListInOrder() {

        playersList.add(khaleesi);
        playersList.add(noOne);
        playersList.add(redViper);

        noOne.setPoint(3);
        khaleesi.setPoint(2);
        redViper.setPoint(0);

         List<String> playersInPointOrder = new ArrayList<>();
         List<Player> testList = new ArrayList<>();

        DrinkIT drinkit = new DrinkIT(playersList, 0, null, playersInPointOrder,
                0, null, 0, null, null,
                null, null, null, null);


            drinkit.putListInPointOrder();

            testList.add(noOne);
            testList.add(khaleesi);
            testList.add(redViper);

            assert(playersInPointOrder.equals(testList)); //TODO FIX HERE ALICEEE



        System.out.println(playersInPointOrder.toString());

        }

    } */


