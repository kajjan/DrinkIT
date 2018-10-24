package com.TDA367.drinkit.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.TDA367.drinkit.Controller.Controller;

public class ChallengeDecorator extends AppCompatActivity implements Decorator {
    protected View view;
    protected Context context;
    protected Controller controller;
    protected Decorator decorator;

    boolean hasChallenge;
    boolean hasButton;
    RelativeLayout row2;
    LinearLayout.LayoutParams layoutParams;


    public ChallengeDecorator(Decorator d){
        this.decorator=d;

    }

    protected ChallengeDecorator(View view, Context context, Controller controller, Boolean hasButton, Boolean hasChallenge){
        this.view=view;
        this.context=context;
        this.controller=controller;
        this.hasChallenge=hasChallenge;
        this.hasButton=hasButton;
        this.row2 = (RelativeLayout) view.findViewById(R.id.challenge_base);
        this.layoutParams = new LinearLayout.LayoutParams(500, 200);
        decorate();
    }

    @Override
    public void decorate() {
        this.decorator.decorate();

    }


    protected void makeNextButton(String text){
        if(hasButton) {
            Button nextButton = new Button(context);
            nextButton.setText(text);
            layoutParams.setMargins(200, 1300, 0, 0); // left, top, right, bottom
            nextButton.setLayoutParams(layoutParams);
            row2.addView(nextButton);
        }
    }

    protected void setChallengeText(){
        TextView challengeText = new TextView(context);
        layoutParams = new LinearLayout.LayoutParams(500, 200);
        layoutParams.setMargins(200, 800, 0, 0); // left, top, right, bottom
        challengeText.setLayoutParams(layoutParams);
        row2.addView(challengeText);
        challengeText.setText(controller.getActiveChallenge());
    }


}
