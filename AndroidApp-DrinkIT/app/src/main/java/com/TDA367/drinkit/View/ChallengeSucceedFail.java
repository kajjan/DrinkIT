package com.TDA367.drinkit.View;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import com.TDA367.drinkit.Controller.Controller;

public class ChallengeSucceedFail extends ChallengeDecorator {

    protected RelativeLayout succeedFailView;


    public ChallengeSucceedFail(View view, Context context, Controller controller) {
        super(view, context, controller);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void decorate() {
        succeedFailView = (RelativeLayout) view.findViewById(R.id.challenge_base);

        //Succeed - Button
        Button succeedButton = new Button(context);
        succeedButton.setText("Succeed");
        succeedButton.setTextSize(20);
        succeedButton.setBackgroundColor(0xFF48CB70);
        LinearLayout.LayoutParams layoutParamsSuccedButton = new LinearLayout.LayoutParams(380, 180);
        layoutParamsSuccedButton.setMargins(600, 1200, 0, 0); // left, top, right, bottom
        succeedButton.setLayoutParams(layoutParamsSuccedButton);
        succeedFailView.addView(succeedButton);

        //Dare - Button
        Button failButton = new Button(context);
        failButton.setText("Fail");
        failButton.setTextSize(20);
        failButton.setBackgroundColor(0xFFFF6666);
        LinearLayout.LayoutParams layoutParamsFailButton = new LinearLayout.LayoutParams(380, 180);
        layoutParamsFailButton.setMargins(100, 1200, 0, 0); //left, top, right, bottom
        failButton.setLayoutParams(layoutParamsFailButton);
        succeedFailView.addView(failButton);
    }


}