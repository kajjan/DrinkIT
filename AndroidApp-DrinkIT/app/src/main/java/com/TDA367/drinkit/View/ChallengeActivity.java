package com.TDA367.drinkit.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChallengeActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_base);

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

    public void startNextActivity(String category) {
        if (category.equals("Quiz") || category.equals("Songs") || category.equals("Charades")) {
            //Dubbelvy med poäng
            //startActivity(new Intent(.this, ChallengeWithAnswerPageOneActivity.class));
        } else if (category.equals("Truth or Dare")) {
            //Enkelvy med poäng
            //startActivity(new Intent(ChallengeWithAnswerPageTwoActivity.this, TruthOrDarePageActivity.class));
        } else if (category.equals("Most Likely To") || category.equals("Rules") || category.equals("Never Have I Ever") || category.equals("Themes") || category.equals("This or That")) {
            //en vy utan poäng (ingen spelar)
            //startActivity(new Intent(ChallengeWithAnswerPageTwoActivity.this, ChallengeWithoutPointActivity .class));
        }else{
            System.out.println("Something is wrong with the code in ChallengeWithAnswerActivity..." + category);
        }
    }

    public void optionsDuringGamePage(View view) {
    }
}
