package com.TDA367.drinkit.View;

import org.junit.Test;

import com.TDA367.drinkit.Model.Category;
import com.TDA367.drinkit.Model.Challenge;
import com.TDA367.drinkit.Model.DrinkIT;
import com.TDA367.drinkit.Model.Player;
import java.util.ArrayList;
import java.util.List;


public class PlayerDuringGameTest {


    List<Player> playersList = new ArrayList<>();
    Player player1 = new Player("Emil");
    Player player2 = new Player("Ida");
    Player player3 = new Player("Klas");

    List<Challenge> challenges = new ArrayList<>();
    List<Category> cats = new ArrayList<>();

    Boolean a= true;



    @Test
    public void removePlayerDuringGame(){
        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);
        boolean nameNotInList=true;

        Challenge challenge = new Challenge("here is the first challenge", "here is the anser", 0);
        Challenge challenge1 = new Challenge("here is the second challenge", "here is the anser", 0);


        challenges.add(challenge);
        challenges.add(challenge1);

        Category truthOrDare = new Category("truthOrDare", "how to play", challenges);
        Category truthOrDare1 = new Category("truthOrDare", "how to play", challenges);

        //TruthOrDareCategory truthOrDare = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a);
        //TruthOrDareCategory truthOrDare1 = new TruthOrDareCategory("truthOrDare", "how to play", challenges, a );

        cats.add(truthOrDare);
        cats.add(truthOrDare1);

        DrinkIT drinkIT = new DrinkIT(playersList, 0, null, 0, null, 0, null, null);
        drinkIT.setNumberOfRounds(3);
        //drinkIT.createCompletedPlayersList();
        drinkIT.removePlayerDuringGame(player2.getName());

        for(Player p: playersList){
            if(p.equals(player2)){
                nameNotInList=false;
            }
        }
        assert (nameNotInList);
        assert(playersList.size()==2);
    }


    @Test
    public void addPlayerDuringGame(){


    }

}
