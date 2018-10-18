package com.example.drinkit.drinkit;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridLayout;

import Controller.Controller;
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

