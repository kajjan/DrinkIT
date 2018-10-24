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
 * View class: ChallengeView1
 *
 * ChallengeView1 is the class that is the view of the challenge. (The first view of the challenge if it's a challenge with 2 views.)
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 *
 *
 */
public class ChallengeView1 extends MainView {

    RelativeLayout relativeLayoutChallengeView1;
    LinearLayout.LayoutParams layoutParams;


    /**
     * calls the method decorate which in its turn calls the methods that should be called depending on the activeCategory.
     * calls the method printPlayer and printActiveCategory which are the only thing that is always shown independently of the active category
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        relativeLayoutChallengeView1 = findViewById(R.id.relativeLayoutChallengeView1);
        decorate(getCtrl().getNextCategory());

        printPlayersName();
        printActiveCategory();
    }

    /**
     * A method that gets the active player of the challenge and prints it on the view.
     */
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

    /**
     * A method that gets the active category of the challenge and prints it on the view.
     */
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

    /**
     * A method that gets the active challenge task of the challenge and prints it on the view.
     */
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

    /**
     * A method that gets the point for the active challenge and prints it on the view.
     */
    private void setChallengePoint(){
        TextView challengePoints = new TextView(this);
        LinearLayout.LayoutParams layoutPoints = new LinearLayout.LayoutParams(200, 50);
        layoutPoints.setMargins(450, 1550, 0, 0); // left, top, right, bottom
        challengePoints.setLayoutParams(layoutPoints);
        challengePoints.setTextSize(18);
        relativeLayoutChallengeView1.addView(challengePoints);
        challengePoints.setText(getCtrl().getActiveChallengePoints() + " Points");       // view.setBackground(context.getResources().getDrawable(drawableId));
    }

    /**
     * A method that makes a button to get to the next challenge. The button has a listener.
     */
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


    /**
     * an onClickListener that if clicked calls the failedChallenge method so that the active player and category increases with one.
     * Recreates the view if there is a next challenge otherwise changes to the finishpage view
     */
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


    /**
     * A method that checks if the game has a next challenges or if the game is done.
     * @return true if there is a next challenge
     */
    private boolean nextRound(){
        return getCtrl().nextRound();
    }


    /**
     * A method that creates a button to take the player to the second view of it's challenge. The button has an onClickListener buttonToNextPageListener.
     */
    private void setNextViewButton(){
        Button nextChallengeButton = new Button(this);
        layoutParams = new LinearLayout.LayoutParams(1200, 180);
        layoutParams.topMargin = 1300;
        layoutParams.leftMargin = 50;
        layoutParams.rightMargin = 50;
        nextChallengeButton.setTextSize(20);
        nextChallengeButton.setText("Next Page");
        nextChallengeButton.setLayoutParams(layoutParams);
        relativeLayoutChallengeView1.addView(nextChallengeButton);
        nextChallengeButton.setOnClickListener(buttonToNextPageListener);
    }


    /**
     * A method that makes 2 buttons Truth- and DareButton which bboth are connected to the onCLickListner buttonToNextPageListener. And sets a text or between the buttons.
     */
    private void setTruthOrDareButtons(){
        Button dareButton = new Button(this);
        dareButton.setText("Dare");
        dareButton.setTextSize(25);
        LinearLayout.LayoutParams layoutParamsDare = new LinearLayout.LayoutParams(380, 180);
        layoutParamsDare.setMargins(600, 1100, 0, 0); // left, top, right, bottom
        dareButton.setLayoutParams(layoutParamsDare);
        relativeLayoutChallengeView1.addView(dareButton);
        dareButton.setOnClickListener(buttonToNextPageListener);

        Button truthButton = new Button(this);
        truthButton.setText("Truth");
        truthButton.setTextSize(25);
        LinearLayout.LayoutParams layoutParamsTruth = new LinearLayout.LayoutParams(380, 180);
        layoutParamsTruth.setMargins(100, 1100, 0, 0); //left, top, right, bottom
        truthButton.setLayoutParams(layoutParamsTruth);
        relativeLayoutChallengeView1.addView(truthButton);
        truthButton.setOnClickListener(buttonToNextPageListener);


        TextView orText = new TextView(this);
        orText.setText("or");
        orText.setTextSize(24);
        LinearLayout.LayoutParams layoutParamsOrText = new LinearLayout.LayoutParams(500, 200);
        layoutParamsOrText.setMargins(510, 1150, 0, 0);
        orText.setLayoutParams(layoutParamsOrText);
        relativeLayoutChallengeView1.addView(orText);

    }

    /**
     * An onClickListener that if clicked changes the view too ChallengeView2. The second view of the same challenge.
     */
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

    /**
     * A method which depending of the input string calls different methods that sets buttons and texts on the view for the active challenge. Different view for the different categories
     * @param category is a string of the games activeCategory.
     */
    private void decorate(String category){
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades") ){
            setChallengePoint();
            setChallengeText();
            setNextViewButton();
        }
        else if(category.equals("Truth or Dare")){
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
