package com.TDA367.drinkit.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChallengeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_base);

    }

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeActivity.this, ChallengeInstructionActivity.class));
    }

    public void toAnswerPage(View view) {
    }

    public void truthButton(View view) {
    }

    public void dareButton(View view) {
    }


    public void failChallenge(View view) {
    }

    public void succeededChallenge(View view) {
    }
}
