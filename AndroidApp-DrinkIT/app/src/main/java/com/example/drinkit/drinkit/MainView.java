package com.example.drinkit.drinkit;
import android.support.v7.app.AppCompatActivity;

import Controller.Controller;

/**
 * MainView - superclass to most views used in the application so as to avoid for example duplicate controllers being instansiated.
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 *
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
}

