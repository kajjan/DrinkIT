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
import android.widget.TextView;

import com.TDA367.drinkit.Controller.Controller;

public class ChallengePointsView extends ChallengeDecorator {

    protected RelativeLayout challengePointsView;


    public ChallengePointsView(View view, Context context, Controller controller) {
        super(view, context, controller);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void decorate() {
        challengePointsView = (RelativeLayout) view.findViewById(R.id.challenge_base);

        TextView challengePoints = new TextView(context);
        LinearLayout.LayoutParams layoutPoints = new LinearLayout.LayoutParams(200, 50);
        layoutPoints.setMargins(450, 1450, 0, 0); // left, top, right, bottom
        challengePoints.setLayoutParams(layoutPoints);
        challengePoints.setTextSize(17);
        challengePointsView.addView(challengePoints);
        challengePoints.setText(controller.getActiveChallengePoints() + " Points");       // view.setBackground(context.getResources().getDrawable(drawableId));

    }

}