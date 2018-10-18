package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChallengeInstructionActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_instruction);
        printChallengeInstruction();
    }

    public void printChallengeInstruction(){
        TextView text=((TextView)findViewById(R.id.challengeInstructionsText));
        text.setText(getCtrl().getInstructions());
    }

    public void exitChallengeInstruction(View view) {
        finish();
    }
}
