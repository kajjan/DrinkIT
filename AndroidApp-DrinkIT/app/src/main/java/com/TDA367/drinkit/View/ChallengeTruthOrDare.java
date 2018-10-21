package com.TDA367.drinkit.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.TDA367.drinkit.Controller.Controller;

public class ChallengeTruthOrDare extends ChallengeDecorator {

    protected RelativeLayout challengeTruthOrDare;



    public ChallengeTruthOrDare(View view, Context context, Controller controller) {
        super(view, context, controller);
    }


    @Override
    public void decorate() {
       // challengeTruthOrDare.setVisibility(challengeTruthOrDare.VISIBLE);

        RelativeLayout truthOrDare = (RelativeLayout) view.findViewById(R.id.challenge_base);
        Button dareButton = new Button(context);
        dareButton.setText("Dare");
        dareButton.setTextSize(25);
        LinearLayout.LayoutParams layoutParamsDare = new LinearLayout.LayoutParams(380, 180);
        layoutParamsDare.setMargins(600, 1100, 0, 0); // left, top, right, bottom
        dareButton.setLayoutParams(layoutParamsDare);
        truthOrDare.addView(dareButton);

        Button truthButton = new Button(context);
        truthButton.setText("Truth");
        truthButton.setTextSize(25);
        LinearLayout.LayoutParams layoutParamsTruth = new LinearLayout.LayoutParams(380, 180);
        layoutParamsTruth.setMargins(100, 1100, 0, 0); //left, top, right, bottom
        truthButton.setLayoutParams(layoutParamsTruth);
        truthOrDare.addView(truthButton);

        TextView orText = new TextView(context);
        orText.setText("or");
        orText.setTextSize(24);
        LinearLayout.LayoutParams layoutParamsOrText = new LinearLayout.LayoutParams(500, 200);
        layoutParamsOrText.setMargins(510, 1150, 0, 0);
        orText.setLayoutParams(layoutParamsOrText);
        truthOrDare.addView(orText);



    }







}
