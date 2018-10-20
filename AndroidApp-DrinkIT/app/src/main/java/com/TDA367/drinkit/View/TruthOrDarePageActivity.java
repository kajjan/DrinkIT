package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TruthOrDarePageActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_or_dare_page);
        printPlayersName();

    }

    public void printPlayersName(){
        TextView text=((TextView)findViewById(R.id.nameOfPlayer));
        text.setText(getCtrl().getNameOfPlayer());
    }


    public void truthButton(View view) {
        getCtrl().setTruthChallenge();
        startActivity(new Intent(TruthOrDarePageActivity.this, ChallengeWithPointActivity .class));
    }

    public void dareButton(View view) {
        getCtrl().setDareChallenge();
        startActivity(new Intent(TruthOrDarePageActivity.this, ChallengeWithPointActivity .class));

    }

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(TruthOrDarePageActivity.this, ChallengeInstructionActivity.class));
    }

    public void optionsDuringGamePage(View view) {
        startActivity(new Intent(TruthOrDarePageActivity.this, OptionsDuringGameActivity.class));
    }
}
