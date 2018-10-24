package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

/**
 * This Activity handles the different options during the game
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class OptionsDuringGameActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_during_game);
    }

    /**
     * Method which TODO
     * @param view
     */
    //TODO player and category can be the same as earlier, but we haven't yet solved so it's the same challenge
    public void exitOptionsPage(View view) {
        String currentPlayer = getCtrl().getNameOfPlayer();
        List<String> playerNames = getCtrl().getAllPlayerNames();
        String category;

        if (playerNames.contains(currentPlayer)) {
            category = getCtrl().getCurrentCategory();

        } else {
            category = getCtrl().getNextCategory();
        }

        startNextActivity(category);
    }

    /**
     * Method which starts the new activity addPlayerDuringGameActivity
     * @param view View
     */
    public void addNewPlayerDuringGame(View view) {
        startActivity(new Intent(OptionsDuringGameActivity.this, AddPlayerDuringGameActivity.class));
    }

    /**
     * Method starts the new Activity RemovePlayerDuringGamePageOneActivity
     * @param view View
     */

    public void removeExistingPlayerDuringGame(View view) {
        startActivity(new Intent(OptionsDuringGameActivity.this, RemovePlayerDuringGamePageOneActivity.class));
    }

    /**
     * Method to quit the game, starts new activity QuitDuringGameActivity
     * @param view View
     */
    public void quitDuringGame(View view) {
        startActivity(new Intent(OptionsDuringGameActivity.this, QuitDuringGameActivity.class));
    }

    /**
     * Method to resume the game and exits optionsPage
     * @param view
     */
    public void resumeGame(View view) {
        exitOptionsPage(view);
    }

    /**
     * Starts new activity based on next category
     * @param category String
     */
    public void startNextActivity(String category){
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades") ){
            //Dubbelvy med poäng
            startActivity(new Intent(OptionsDuringGameActivity.this, ChallengeWithAnswerPageOneActivity.class));
        }
        else if(category.equals("Truth or Dare")){
            //Enkelvy med poäng
            startActivity(new Intent(OptionsDuringGameActivity.this, TruthOrDarePageActivity.class));
        }
        else if(category.equals("Most Likely To") || category.equals("Rules")  || category.equals("Never Have I Ever") || category.equals("Themes") || category.equals("This or That") )
            //en vy utan poäng (ingen spelar)
            startActivity(new Intent(OptionsDuringGameActivity.this, ChallengeWithoutPointActivity .class));
        else{
            System.out.println("Something is wrong with the code in OptionsDuringGameActivity..." + category);
        }

    }

}
