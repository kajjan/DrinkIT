package com.TDA367.drinkit.View;

import android.view.View;
import android.widget.RelativeLayout;

public class ChallengeWithoutPointView extends ChallengeDecorator {
    protected RelativeLayout challengeTask;
    protected RelativeLayout challengeNextButton;


    public ChallengeWithoutPointView(RelativeLayout challengeTask, RelativeLayout challengeNextButton) {
        super();
        this.challengeTask=challengeTask;
        this.challengeNextButton=challengeNextButton;
    }


    @Override
    public void decorate() {
        challengeTask.setVisibility(challengeTask.VISIBLE);
        challengeNextButton.setVisibility(challengeNextButton.VISIBLE);
    }

}
