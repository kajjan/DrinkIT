package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Class that handles the instructions of the challenges
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class ChallengeInstructionActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_instruction);
        printChallengeInstruction();
        printCategory();
    }

    /**
     * Method which prints the category of the challenge
     */
    private void printCategory() {
        TextView text=((TextView)findViewById(R.id.textChallengeCategory));
        text.setText(getCtrl().getActiveCategory());
    }

    /**
     * Method which prints the challenge instruction
     */
    public void printChallengeInstruction(){
        TextView text=((TextView)findViewById(R.id.challengeInstructionsText));
        text.setText(getCtrl().getInstructions());
    }

    /**
     * exits the challenge onClick()
     * @param view View
     */
    public void exitChallengeInstruction(View view) {
        finish();
    }
}
