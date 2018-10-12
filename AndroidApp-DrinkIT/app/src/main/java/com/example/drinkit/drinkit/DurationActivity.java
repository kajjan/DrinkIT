package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class DurationActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duration);

    }


    public void shortDuration(View view) {
        getCtrl().setDuration(3);
        String s = getCtrl().getNextCategory();
        startActivity(new Intent(DurationActivity.this, ChallengeActivity.class));
    }

    public void mediumDuration(View view) {
        getCtrl().setDuration(5);
        startActivity(new Intent(DurationActivity.this, ChallengeActivity.class));

    }

    public void longDuration(View view) {
        getCtrl().setDuration(10);
        startActivity(new Intent(DurationActivity.this, ChallengeActivity.class));
    }


}

