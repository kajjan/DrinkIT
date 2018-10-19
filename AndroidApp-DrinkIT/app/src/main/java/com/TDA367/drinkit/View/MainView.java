package com.TDA367.drinkit.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridLayout;

import com.TDA367.drinkit.Controller.Controller;
public class MainView extends AppCompatActivity {

    private static Controller ctrl;

    public MainView(Controller ctrl) {
        this.ctrl = ctrl;
    }

    public MainView(){}

    public Controller getCtrl() {
        return ctrl;
    }

    //public boolean previousPageWasOptions;

    //public void setPreviousPageWasOptions(boolean previousPageWasOptions) { this.previousPageWasOptions = previousPageWasOptions; }

    //public boolean getPreviousPageWasOptions() { return previousPageWasOptions; }
}

