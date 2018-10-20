package com.TDA367.drinkit.View;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

public class ChallengeTruthOrDare extends ChallengeDecorator {

    protected RelativeLayout challengeTruthOrDare;


    public ChallengeTruthOrDare(View view, Context context) {
        super(view, context);
    }


    @Override
    public void decorate() {
        challengeTruthOrDare.setVisibility(challengeTruthOrDare.VISIBLE);
    }

}
