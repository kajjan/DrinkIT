package com.TDA367.drinkit.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChallengeView2 extends MainView{


    RelativeLayout relativeLayoutChallengeView2;
    LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_with_answer_page_two);
        relativeLayoutChallengeView2 = findViewById(R.id.relativeLayoutChallengeView2);

        printPlayersName();
        printCategory();
        //decorate(getCtrl().getActiveCategory());
    }
    private void printPlayersName() {
        TextView playersName = new TextView(this);
        layoutParams =  new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.topMargin = 390;
        playersName.setGravity(Gravity.CENTER);
        playersName.setTextColor(Color.BLACK);
        playersName.setLayoutParams(layoutParams);
        playersName.setTextSize(50);
        relativeLayoutChallengeView2.addView(playersName);
        playersName.setText(getCtrl().getNameOfPlayer());
    }

    private void printCategory() {
        TextView activeCategoryText = new TextView(this);
        layoutParams =  new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.topMargin = 560;
        activeCategoryText.setGravity(Gravity.CENTER);
        activeCategoryText.setLayoutParams(layoutParams);
        activeCategoryText.setTextSize(22);
        relativeLayoutChallengeView2.addView(activeCategoryText);
        activeCategoryText.setText(getCtrl().getActiveCategory());
    }


    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeView2.this, ChallengeInstructionActivity.class));
    }

    public void optionsDuringGamePage(View view) {
        startActivity(new Intent(ChallengeView2.this, OptionsDuringGameActivity.class));
    }
}
