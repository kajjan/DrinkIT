package com.TDA367.drinkit.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ChallengeTruthOrDare extends ChallengeDecorator {

  static ChallengeActivity challengeActivity;

    public ChallengeTruthOrDare() {
        super(challengeActivity);
    }


        public void hereAreButtons() {
            RelativeLayout truthOrDare = (RelativeLayout) findViewById(R.id.challenge_base);
            Button dareButton = new Button(this);
            dareButton.setText("Dare");
            dareButton.setTextSize(25);
            LinearLayout.LayoutParams layoutParamsDare = new LinearLayout.LayoutParams(380, 180);
            layoutParamsDare.setMargins(600, 1100, 0, 0); // left, top, right, bottom
            dareButton.setLayoutParams(layoutParamsDare);
            truthOrDare.addView(dareButton);

            Button truthButton = new Button(this);
            truthButton.setText("Truth");
            truthButton.setTextSize(25);
            LinearLayout.LayoutParams layoutParamsTruth = new LinearLayout.LayoutParams(380, 180);
            layoutParamsTruth.setMargins(100, 1100, 0, 0); //left, top, right, bottom
            truthButton.setLayoutParams(layoutParamsTruth);
            truthOrDare.addView(truthButton);
        }


    @Override
    public void decorate() {
        // challengeTruthOrDare.setVisibility(challengeTruthOrDare.VISIBLE);
        hereAreButtons();

    }

}
