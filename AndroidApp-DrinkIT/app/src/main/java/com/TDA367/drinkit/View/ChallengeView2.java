package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
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
        //printCategory();
        //decorate(getCtrl().getActiveCategory());
    }
    private void printPlayersName() {
        TextView playersName = new TextView(this);
        layoutParams = new LinearLayout.LayoutParams(500, 200);
        layoutParams.setMargins(200, 200, 0, 0); // left, top, right, bottom
        playersName.setLayoutParams(layoutParams);
        relativeLayoutChallengeView2.addView(playersName);
        playersName.setText(getCtrl().getNameOfPlayer());
    }

    private void printCategory() {
        TextView playersName = new TextView(this);
        layoutParams = new LinearLayout.LayoutParams(500, 200);
        layoutParams.setMargins(200, 300, 0, 0); // left, top, right, bottom
        playersName.setLayoutParams(layoutParams);
        relativeLayoutChallengeView2.addView(playersName);
        playersName.setText(getCtrl().getActiveCategory());
    }


    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeView2.this, ChallengeInstructionActivity.class));
    }

    public void optionsDuringGamePage(View view) {
        startActivity(new Intent(ChallengeView2.this, OptionsDuringGameActivity.class));
    }
}
