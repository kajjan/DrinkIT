package com.TDA367.drinkit.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class ChallengeDecorator extends AppCompatActivity implements Decorator {

   public ChallengeActivity challengeActivity;


    public ChallengeDecorator(ChallengeActivity ca){
        super();
        this.challengeActivity = ca;
        decorate();
    }


    public ChallengeDecorator() {

    }
}
