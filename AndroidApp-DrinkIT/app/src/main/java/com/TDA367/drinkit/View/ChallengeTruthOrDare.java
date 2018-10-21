package com.TDA367.drinkit.View;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import com.TDA367.drinkit.Controller.Controller;

public class ChallengeTruthOrDare extends ChallengeDecorator {

    protected RelativeLayout challengeTruthOrDare;


    public ChallengeTruthOrDare(View view, Context context, Controller controller, Boolean hasButton, Boolean hasChallenge) {
        super(view, context,controller, hasButton, hasChallenge);
    }


    @Override
    public void decorate() {
        challengeTruthOrDare.setVisibility(challengeTruthOrDare.VISIBLE);
    }

}
