package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A Class which handles the option to add a player during a game
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class AddPlayerDuringGameActivity extends MainView implements TextWatcher {

    String playerName;
    List<String> players = new ArrayList<>();
    EditText playerToAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player_during_game);

        playerToAdd = findViewById(R.id.playerToAdd);
        playerToAdd.addTextChangedListener(this);

        players = getCtrl().getAllPlayerNames();
    }


    public void exitOptionAddPlayerPage(View view) {
        finish();
    }

    /**
     * Method which checks if player already exist in list of players
     *
     * @param name String
     * @return numberOfTimes int
     */
    public int sameName(String name) {
        int numberOfTimes = 0;
        for (String s : players) {
            if (name.equals(s)) {
                numberOfTimes++;
            }
        }
        return numberOfTimes;
    }

    /**
     * Listener
     *
     * @param s     CharSequence
     * @param start int
     * @param count int
     * @param after int
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(this, "before changes", Toast.LENGTH_SHORT).show();
    }

    /**
     * Listener
     *
     * @param s      CharSequence
     * @param start  int
     * @param before int
     * @param count  int
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this, "during chances", Toast.LENGTH_SHORT).show();
    }

    /**
     * checks if the new player to add already exist and then sets the name
     *
     * @param s editable
     */
    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(this, "after changes", Toast.LENGTH_SHORT).show();
        String name;

        if (playerToAdd.getText().hashCode() == s.hashCode()) {
            name = playerToAdd.getText().toString().trim();

            if (sameName(name) >= 1) {
                playerToAdd.setError("A new player cannot have the same name as an existing player");
            } else {
                playerName = name;
            }
        }
    }

    /**
     * Calls upon the controller and adds the player to playerslist
     *
     * @param view View
     */
    public void addPlayerToGame(View view) {
        getCtrl().addPlayerDuringGame(playerName);
        startActivity(new Intent(AddPlayerDuringGameActivity.this, OptionsDuringGameActivity.class));
    }

}
