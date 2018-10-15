package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TruthOrDarePageActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_or_dare_page);
    }

    public void printPlayersName(){
        TextView text=((TextView)findViewById(R.id.playerName));
        text.setText(getCtrl().getPlayersName());
    }


    public void truthButton(View view) {
        getCtrl().setTruthChallenge();
        startActivity(new Intent(TruthOrDarePageActivity.this, ChallengeWithoutPointActivity .class));
    }

    public void dareButton(View view) {
        getCtrl().setDareChallenge();
        startActivity(new Intent(TruthOrDarePageActivity.this, ChallengeWithoutPointActivity .class));

    }
}
