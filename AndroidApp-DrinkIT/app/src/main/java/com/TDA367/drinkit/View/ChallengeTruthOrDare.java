package com.TDA367.drinkit.View;

import android.widget.RelativeLayout;

public class ChallengeTruthOrDare extends ChallengeDecorator {

    protected RelativeLayout challengeTruthOrDare;


    public ChallengeTruthOrDare(RelativeLayout challengeTruthOrDare) {
        super();
        this.challengeTruthOrDare=challengeTruthOrDare;
    }


    @Override
    public void decorate() {
        challengeTruthOrDare.setVisibility(challengeTruthOrDare.VISIBLE);
    }

}
