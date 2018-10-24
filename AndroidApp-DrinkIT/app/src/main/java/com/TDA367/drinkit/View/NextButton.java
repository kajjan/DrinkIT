package com.TDA367.drinkit.View;

import android.content.Context;
import android.widget.Button;


public class NextButton extends ChallengeDecorator{
    String text = "Next Challenge";

    protected NextButton(Decorator d) {
        super(d);

    }

    @Override
    public void decorate() {
        Button nextButton = new Button(context);
        nextButton.setText(text);
        layoutParams.setMargins(200, 1300, 0, 0); // left, top, right, bottom
        nextButton.setLayoutParams(layoutParams);
        row2.addView(nextButton);
        super.decorate();
    }
}
