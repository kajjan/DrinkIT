package com.TDA367.drinkit.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
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
        setChallengePoint();
        setChallengeText();
        setSucceedFailbutton();
    }
    private void printPlayersName() {
        TextView playersName = new TextView(this);
        layoutParams =  new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
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
        layoutParams =  new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.topMargin = 560;
        activeCategoryText.setGravity(Gravity.CENTER);
        activeCategoryText.setLayoutParams(layoutParams);
        activeCategoryText.setTextSize(22);
        relativeLayoutChallengeView2.addView(activeCategoryText);
        activeCategoryText.setText(getCtrl().getActiveCategory());
    }


    protected void setChallengeText(){
        TextView challengeText = new TextView(this);
        layoutParams = new LinearLayout.LayoutParams(1000,200);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        layoutParams.topMargin = 820;
        layoutParams.leftMargin = 20;
        challengeText.setLayoutParams(layoutParams);
        challengeText.setTextSize(20);
        challengeText.setGravity(Gravity.CENTER_HORIZONTAL);
        relativeLayoutChallengeView2.addView(challengeText);
        challengeText.setText(getCtrl().getActiveChallengesAnswer());
    }

    private void setChallengePoint(){
        TextView challengePoints = new TextView(this);
        LinearLayout.LayoutParams layoutPoints = new LinearLayout.LayoutParams(200, 50);
        layoutPoints.setMargins(450, 1550, 0, 0); // left, top, right, bottom
        challengePoints.setLayoutParams(layoutPoints);
        challengePoints.setTextSize(18);
        relativeLayoutChallengeView2.addView(challengePoints);
        challengePoints.setText(getCtrl().getActiveChallengePoints() + " Points");       // view.setBackground(context.getResources().getDrawable(drawableId));
    }

    public void setSucceedFailbutton(){
        Button failButton = new Button(this);
        failButton.setText("Fail");
        failButton.setTextSize(25);
        LinearLayout.LayoutParams layoutParamsDare = new LinearLayout.LayoutParams(380, 180);
        layoutParamsDare.setMargins(600, 1100, 0, 0); // left, top, right, bottom
        failButton.setLayoutParams(layoutParamsDare);
        relativeLayoutChallengeView2.addView(failButton);
        failButton.setOnClickListener(buttonToNextPageListenerFail);

        Button succeedButton = new Button(this);
        succeedButton.setText("Truth");
        succeedButton.setTextSize(25);
        LinearLayout.LayoutParams layoutParamsTruth = new LinearLayout.LayoutParams(380, 180);
        layoutParamsTruth.setMargins(100, 1100, 0, 0); //left, top, right, bottom
        succeedButton.setLayoutParams(layoutParamsTruth);
        relativeLayoutChallengeView2.addView(succeedButton);
        succeedButton.setOnClickListener(buttonToNextPageListenerSucceed);
    }

    private View.OnClickListener buttonToNextPageListenerFail = new View.OnClickListener() {
        public void onClick(View v) {
            getCtrl().failedChallenge();
            if(nextRound()) {
                startActivity(new Intent(ChallengeView2.this, ChallengeView1.class));
            }
            else{
                startActivity(new Intent(ChallengeView2.this, FinishPageActivity.class));
            }
        }
    };

    private View.OnClickListener buttonToNextPageListenerSucceed = new View.OnClickListener() {
        public void onClick(View v) {
            getCtrl().succeededChallenge();
            if(nextRound()) {
                startActivity(new Intent(ChallengeView2.this, ChallengeView1.class));
            }
            else{
                startActivity(new Intent(ChallengeView2.this, FinishPageActivity.class));

            }
        }
    };

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeView2.this, ChallengeInstructionActivity.class));
    }

    public void optionsDuringGamePage(View view) {
        startActivity(new Intent(ChallengeView2.this, OptionsDuringGameActivity.class));
    }
    public boolean nextRound(){
        return getCtrl().nextRound();
    }

}
