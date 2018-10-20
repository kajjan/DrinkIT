package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;


public class DurationActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duration);
    }

    public void shortDuration(View view) {
        getCtrl().setDuration(3);
        String nextCategory = getCtrl().getNextCategory();
        startActivity(new Intent(DurationActivity.this, ChallengeActivity.class));

    }

    public void mediumDuration(View view) {
        getCtrl().setDuration(5);
        String nextCategory = getCtrl().getNextCategory();
        startActivity(new Intent(DurationActivity.this, ChallengeActivity.class));

    }

    public void longDuration(View view) {
        getCtrl().setDuration(10);
        String nextCategory = getCtrl().getNextCategory();
    }

    }



}

