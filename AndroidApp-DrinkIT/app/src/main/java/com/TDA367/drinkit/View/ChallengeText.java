package com.TDA367.drinkit.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChallengeText extends ChallengeDecorator{


    public ChallengeText(Decorator d) {
        super(d);
    }

    @Override
    public void decorate() {
      super.decorate();
        TextView challengeText = new TextView(context);
        layoutParams = new LinearLayout.LayoutParams(500, 200);
        layoutParams.setMargins(200, 800, 0, 0); // left, top, right, bottom
        challengeText.setLayoutParams(layoutParams);
        row2.addView(challengeText);
        challengeText.setText(controller.getActiveChallenge());
    }
}
