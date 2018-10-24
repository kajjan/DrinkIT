package com.TDA367.drinkit.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Activity which handles help Instruction for the game
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
    }

    /**
     * Exits the instructionspage and goes to StartPageActivity
     * @param view View
     */
    public void exitInstructions(View view) { startActivity(new Intent(InstructionsActivity.this, StartPageActivity.class)); }
}
