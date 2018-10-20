package com.TDA367.drinkit.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ChallengeActivity extends MainView {

   // RelativeLayout challengeTask;
   /* RelativeLayout challengeTruthOrDare = (RelativeLayout)findViewById(R.id.challenge_truth_or_dare);
    RelativeLayout challengePageOne = (RelativeLayout)findViewById(R.id.challenge_page_one_of_two);
    RelativeLayout challengeSucceedFailed = (RelativeLayout)findViewById(R.id.challenge_succeed_fail);
    View challengePoints = (View) findViewById(R.id.challenge_points);
    *///RelativeLayout challengeNextButton;



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//setContentView(R.layout.activity_challenge_task);
        setContentView(R.layout.activity_challenge_base);
        setTheme(R.style.Theme_Transparent);


        RelativeLayout row2 = (RelativeLayout) findViewById(R.id.challenge_base);
        Button ivBowl = new Button(this);
        ivBowl.setText("hi");
        LinearLayout.LayoutParams layoutParams = new  LinearLayout.LayoutParams(200, 200);
        layoutParams.setMargins(200, 300, 0, 0); // left, top, right, bottom
        ivBowl.setLayoutParams(layoutParams);
        row2.addView(ivBowl);
        activate();

        //getCtrl().getNextCategory();

   //     decorateNextActivity("Rules");
    }

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeActivity.this, ChallengeInstructionActivity.class));
    }

    public void toAnswerPage(View view) {
    }

    public void truthButton(View view) {

    }

    public void dareButton(View view) {

    }


    public void failChallenge(View view) {
    }

    public void succeededChallenge(View view) {
    }


    public void activate(){
      //  challengeTask=(RelativeLayout)findViewById(R.id.challenge_task);
        //challengeNextButton=(RelativeLayout)findViewById(R.id.challenge_next_button);
    }


    public void decorateNextActivity(String category) {
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades")) {
           // new ChallengeWithoutPointView(challengeTask,challengeNextButton);
            //kalla på svarssidan, vart???

            //startActivity(new Intent(.this, ChallengeWithAnswerPageOneActivity.class));
        }else if (category.equals("Truth or Dare")) {
         //   new ChallengeTruthOrDare(challengeTruthOrDare);

            //startActivity(new Intent(ChallengeWithAnswerPageTwoActivity.this, TruthOrDarePageActivity.class));
        }else if (category.equals("Most Likely To") || category.equals("Rules") || category.equals("Never Have I Ever") || category.equals("Themes") || category.equals("This or That")) {
//            new ChallengeWithoutPointView(challengeTask,challengeNextButton);

        }else{
            System.out.println("Something is wrong with the code in ChallengeWithAnswerActivity..." + category);
        }
    }

    public void optionsDuringGamePage(View view) {
    }
}
