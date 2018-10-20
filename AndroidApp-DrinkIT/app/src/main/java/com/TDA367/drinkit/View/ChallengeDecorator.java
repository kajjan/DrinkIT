package com.TDA367.drinkit.View;

import android.content.Context;
import android.view.View;

public abstract class ChallengeDecorator implements Decorator {
    protected View view;
    protected Context context;



    public ChallengeDecorator(View view, Context context){
        super();
        this.view=view;
        this.context=context;
        decorate();
    }

}
