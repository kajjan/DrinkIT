package com.TDA367.drinkit.View;

import android.content.Context;
import android.view.View;

import com.TDA367.drinkit.Controller.Controller;

public abstract class ChallengeDecorator implements Decorator {
    protected View view;
    protected Context context;
    protected Controller controller;


    public ChallengeDecorator(View view, Context context, Controller controller){
        super();
        this.view=view;
        this.context=context;
        this.controller=controller;
        decorate();
    }

}
