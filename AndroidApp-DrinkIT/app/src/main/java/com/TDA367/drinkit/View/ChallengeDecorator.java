package com.TDA367.drinkit.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.TDA367.drinkit.Controller.Controller;

public class ChallengeDecorator extends AppCompatActivity implements Decorator {
    protected Context context;
    protected Controller controller;
    protected Decorator decorator;


    RelativeLayout row2;
    LinearLayout.LayoutParams layoutParams;


    public ChallengeDecorator(Decorator d){
        this.decorator=d;
    }


    @Override
    public void decorate() {
        this.decorator.decorate();

    }

}
