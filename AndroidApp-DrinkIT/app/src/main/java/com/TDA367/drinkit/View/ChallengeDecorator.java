package com.TDA367.drinkit.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class ChallengeDecorator extends MainView {
    RelativeLayout challengeTask = (RelativeLayout) findViewById(R.id.challenge_task);
    RelativeLayout challengeTruthOrDare = (RelativeLayout) findViewById(R.id.challenge_truth_or_dare);
    RelativeLayout challengePageOne = (RelativeLayout) findViewById(R.id.challenge_page_one);
    RelativeLayout challengeSucceedFail = (RelativeLayout) findViewById(R.id.challenge_succeed_fail);
    RelativeLayout challengePoints = (RelativeLayout) findViewById(R.id.challenge_points);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_base);
    }

    public void createChallengeWithoutPoint(){



    }
}
