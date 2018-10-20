package com.TDA367.drinkit.View;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.TDA367.drinkit.Controller.Controller;

public class ChallengeWithoutPointView extends ChallengeDecorator {
    protected RelativeLayout challengeTask;
    protected RelativeLayout challengeNextButton;


    public ChallengeWithoutPointView(View view, Context context, Controller controller) {
        super(view,context, controller);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void decorate() {
        RelativeLayout row2 = (RelativeLayout) view.findViewById(R.id.challenge_base);
        Button nextButton = new Button(context);
        nextButton.setText("Next challenge");
        LinearLayout.LayoutParams layoutParams = new  LinearLayout.LayoutParams(500, 200);
        layoutParams.setMargins(200, 1300, 0, 0); // left, top, right, bottom
        nextButton.setLayoutParams(layoutParams);
        row2.addView(nextButton);

        TextView challengeText = new TextView(context);
        layoutParams = new LinearLayout.LayoutParams(500, 200);
        layoutParams.setMargins(200, 800, 0, 0); // left, top, right, bottom
        challengeText.setLayoutParams(layoutParams);
        row2.addView(challengeText);
        challengeText.setText(controller.getActiveChallenge());       // view.setBackground(context.getResources().getDrawable(drawableId));

    }

}
