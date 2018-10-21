package com.TDA367.drinkit.View;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;


import com.TDA367.drinkit.Controller.Controller;

public class ChallengeWithoutPointView extends ChallengeDecorator {


    public ChallengeWithoutPointView(View view, Context context, Controller controller, Boolean hasButton, Boolean hasChallenge) {
        super(view,context,controller, hasButton, hasChallenge);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void decorate() {
        if (hasButton) {
            makeNextButton("Next challenge");
        }
        if(hasChallenge){
            setChallengeText();
        }
    }

       /* nextButton.setOnClickListener(new View.OnClickListener()
        {


            public void onClick(View v)
            {   controller.failedChallenge();
                if(nextRound()) {
                    String nextcategoy=controller.getNextCategory();
                    new ChallengeActivity();
                }
                else{
                    //toFinishPage(view);
                }
            }

        });    }


        public boolean nextRound(){
        return controller.nextRound();
    }
*/
}
