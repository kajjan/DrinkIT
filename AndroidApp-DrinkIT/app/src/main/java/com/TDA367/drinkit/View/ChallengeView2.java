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



/**
 * View class: ChallengeView
 *
 * Some challenges has 2 views.
 * This view is the second view of those categories.
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 *
 *
 */
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

    /**
     * A method that gets the active player of the challenge and prints it on the view.
     */
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

    /**
     * A method that gets the active category of the challenge and prints it on the view.
     */
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


    /**
     * A method that gets the active challenge task of the challenge and prints it on the view.
     * the method checks if the active category is a truth or a dare challenge if so we set the corresponding challenge as the text. Otherwise it gets the challenge answer from the model that is connected to the previous view.
     */
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
        if (getCtrl().getActiveCategory().equals("Truth or Dare")){
            challengeText.setText(getCtrl().getActiveChallenge());
        }
        else {
            challengeText.setText(getCtrl().getActiveChallengesAnswer());
        }
    }

    /**
     * A method that gets the point for the active challenge and prints it on the view.
     */
    private void setChallengePoint(){
        TextView challengePoints = new TextView(this);
        LinearLayout.LayoutParams layoutPoints = new LinearLayout.LayoutParams(200, 50);
        layoutPoints.setMargins(450, 1550, 0, 0); // left, top, right, bottom
        challengePoints.setLayoutParams(layoutPoints);
        challengePoints.setTextSize(18);
        relativeLayoutChallengeView2.addView(challengePoints);
        challengePoints.setText(getCtrl().getActiveChallengePoints() + " Points");       // view.setBackground(context.getResources().getDrawable(drawableId));
    }


    /**
     * A method that makes two buttons, succeed and fail button. The bbuttons are connected to an onClickListener buttonToNextPageListenerfail and buttonToNextPage
     */
    public void setSucceedFailbutton(){
        //Succeed - Button
        Button succeedButton = new Button(this);
        succeedButton.setText("Succeed");
        succeedButton.setTextSize(20);
        succeedButton.setBackgroundColor(0xFF48CB70);
        LinearLayout.LayoutParams layoutParamsSuccedButton = new LinearLayout.LayoutParams(380, 180);
        layoutParamsSuccedButton.setMargins(600, 1200, 0, 0); // left, top, right, bottom
        succeedButton.setLayoutParams(layoutParamsSuccedButton);
        relativeLayoutChallengeView2.addView(succeedButton);
        succeedButton.setOnClickListener(buttonToNextPageListenerSucceed);

        //Dare - Button
        Button failButton = new Button(this);
        failButton.setText("Fail");
        failButton.setTextSize(20);
        failButton.setBackgroundColor(0xFFFF6666);
        LinearLayout.LayoutParams layoutParamsFailButton = new LinearLayout.LayoutParams(380, 180);
        layoutParamsFailButton.setMargins(100, 1200, 0, 0); //left, top, right, bottom
        failButton.setLayoutParams(layoutParamsFailButton);
        relativeLayoutChallengeView2.addView(failButton);
        failButton.setOnClickListener(buttonToNextPageListenerFail);

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
