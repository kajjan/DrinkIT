package com.example.drinkit.drinkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import Controller.Controller;

public class finishPageActivity extends AppCompatActivity {

    Controller ctrl = new Controller();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_page);
        //ctrl.putInPointOrder();

        printScoreBoard();
    }



    public void printScoreBoard(){
        TextView text=((TextView)findViewById(R.id.printScoreBoard));
        text.setText(ctrl.putInPointOrder());
    }

}
