package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
        //startActivity(new Intent(AddPlayerDuringGameActivity.this, OptionsDuringGameActivity.class));
    }

    public int sameName(String name) {
        int numberOfTimes = 0;
        for (String s : players) {
            if (name.equals(s)) {
                numberOfTimes++;
            }
        }
        return numberOfTimes;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(this, "before changes", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this, "during chances", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(this, "after changes", Toast.LENGTH_SHORT).show();
        String name;

        if (playerToAdd.getText().hashCode() == s.hashCode()) {
            name = playerToAdd.getText().toString().trim();

            if (sameName(name) > 1) {
                playerToAdd.setError("A new player cannot have the same name as an existing player");
            } else {
                playerName =name;

            }
        }
    }

        public void addPlayerToGame (View view){
            getCtrl().addPlayerDuringGame(playerName);
            startActivity(new Intent(AddPlayerDuringGameActivity.this, OptionsDuringGameActivity.class));
        }

    }
