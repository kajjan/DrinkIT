package com.TDA367.drinkit.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridLayout;

import com.TDA367.drinkit.Controller.Controller;

/**
 * This Activity is the MainView which contains a controller from the controller class
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

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

