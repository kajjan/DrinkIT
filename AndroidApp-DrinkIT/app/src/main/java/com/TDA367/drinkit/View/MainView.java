package com.TDA367.drinkit.View;
import android.support.v7.app.AppCompatActivity;

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
}

