package com.TDA367.drinkit.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChallengeView1 extends MainView {

    RelativeLayout relativeLayoutChallengeView1;
    LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        relativeLayoutChallengeView1 = findViewById(R.id.relativeLayoutChallengeView1);
        decorate(getCtrl().getNextCategory());

        printPlayersName();
        printActiveCategory();
    }


    private void printPlayersName() {
        TextView playersName = new TextView(this);
        layoutParams =  new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.topMargin = 370;
        playersName.setGravity(Gravity.CENTER);
        playersName.setTextColor(Color.BLACK);
        playersName.setLayoutParams(layoutParams);
        playersName.setTextSize(50);
        relativeLayoutChallengeView1.addView(playersName);
        playersName.setText(getCtrl().getNameOfPlayer());
    }

    private void printActiveCategory(){
        TextView activeCategoryText = new TextView(this);
        layoutParams =  new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.topMargin = 530;
        activeCategoryText.setGravity(Gravity.CENTER);
        activeCategoryText.setLayoutParams(layoutParams);
        activeCategoryText.setTextSize(22);
        relativeLayoutChallengeView1.addView(activeCategoryText);
        activeCategoryText.setText(getCtrl().getActiveCategory());
    }


    private void setChallengeText(){
        TextView challengeText = new TextView(this);
        layoutParams = new LinearLayout.LayoutParams(1000,200);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        layoutParams.topMargin = 820;
        layoutParams.leftMargin = 20;
        challengeText.setLayoutParams(layoutParams);
        challengeText.setTextSize(20);
        challengeText.setGravity(Gravity.CENTER_HORIZONTAL);
        relativeLayoutChallengeView1.addView(challengeText);
        challengeText.setText(getCtrl().getActiveChallenge());
    }


    private void setChallengePoint(){
        TextView challengePoints = new TextView(this);
        LinearLayout.LayoutParams layoutPoints = new LinearLayout.LayoutParams(200, 50);
        layoutPoints.setMargins(450, 1550, 0, 0); // left, top, right, bottom
        challengePoints.setLayoutParams(layoutPoints);
        challengePoints.setTextSize(18);
        relativeLayoutChallengeView1.addView(challengePoints);
        challengePoints.setText(getCtrl().getActiveChallengePoints() + " Points");       // view.setBackground(context.getResources().getDrawable(drawableId));
    }


    private void setNextChallengeButton(){
        Button nextChallengeButton = new Button(this);
        layoutParams =  new LinearLayout.LayoutParams(1200, 180);
        layoutParams.topMargin=1300;
        layoutParams.leftMargin=50;
        layoutParams.rightMargin=50;
        nextChallengeButton.setTextSize(20);
        nextChallengeButton.setText("Next Challenge");
        nextChallengeButton.setLayoutParams(layoutParams);
        relativeLayoutChallengeView1.addView(nextChallengeButton);
        nextChallengeButton.setOnClickListener(nextChallengeButtonListener);
    }

    private View.OnClickListener nextChallengeButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            getCtrl().failedChallenge();
            if(nextRound()) {
                recreate();
            }
            else{
                startActivity(new Intent(ChallengeView1.this, FinishPageActivity.class));

            }
        }
    };

    private boolean nextRound(){
        return getCtrl().nextRound();
    }


    private void setNextViewButton(){
        Button nextChallengeButton = new Button(this);
        layoutParams = new LinearLayout.LayoutParams(1200, 180);
        layoutParams.topMargin = 1300;
        layoutParams.leftMargin = 50;
        layoutParams.rightMargin = 50;
        nextChallengeButton.setTextSize(20);
        nextChallengeButton.setText("Next Page");
        nextChallengeButton.setLayoutParams(layoutParams);
        nextChallengeButton.setOnClickListener(buttonToNextPage);
        relativeLayoutChallengeView1.addView(nextChallengeButton);
        nextChallengeButton.setOnClickListener(buttonToNextPageListener);
    }

    private View.OnClickListener buttonToNextPage = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(ChallengeView1.this, ChallengeView2.class));
        }
    };

    private void setTruthOrDareButtons(){
        Button dareButton = new Button(this);
        dareButton.setText("Dare");
        dareButton.setTextSize(25);
        LinearLayout.LayoutParams layoutParamsDare = new LinearLayout.LayoutParams(380, 180);
        layoutParamsDare.setMargins(600, 1100, 0, 0); // left, top, right, bottom
        dareButton.setLayoutParams(layoutParamsDare);
        relativeLayoutChallengeView1.addView(dareButton);
        dareButton.setOnClickListener(nextChallengeButtonListener);

        Button truthButton = new Button(this);
        truthButton.setText("Truth");
        truthButton.setTextSize(25);
        LinearLayout.LayoutParams layoutParamsTruth = new LinearLayout.LayoutParams(380, 180);
        layoutParamsTruth.setMargins(100, 1100, 0, 0); //left, top, right, bottom
        truthButton.setLayoutParams(layoutParamsTruth);
        relativeLayoutChallengeView1.addView(truthButton);
        truthButton.setOnClickListener(nextChallengeButtonListener);


        TextView orText = new TextView(this);
        orText.setText("or");
        orText.setTextSize(24);
        LinearLayout.LayoutParams layoutParamsOrText = new LinearLayout.LayoutParams(500, 200);
        layoutParamsOrText.setMargins(510, 1150, 0, 0);
        orText.setLayoutParams(layoutParamsOrText);
        relativeLayoutChallengeView1.addView(orText);

    }

    private View.OnClickListener buttonToNextPageListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(ChallengeView1.this, ChallengeView2.class));
        }
    };

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeView1.this, ChallengeInstructionActivity.class));
    }

    public void optionsDuringGamePage(View view) {
        startActivity(new Intent(ChallengeView1.this, OptionsDuringGameActivity.class));
    }

    private void decorate(String category){
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades") ){
            setChallengePoint();
            setChallengeText();
            setNextViewButton();
        }
        else if(category.equals("Truth or Dare")){
            setChallengeText();
            setTruthOrDareButtons();
            setChallengePoint();
        }
        else if(category.equals("Most Likely To") || category.equals("Rules")  || category.equals("Never Have I Ever") || category.equals("Themes") || category.equals("This or That") ) {
            setChallengeText();
            setNextChallengeButton();
        }
        else{
            System.out.println("Something is wrong with the code in ChallengeWithAnswerActivity..." + category);
        }
    }



}
