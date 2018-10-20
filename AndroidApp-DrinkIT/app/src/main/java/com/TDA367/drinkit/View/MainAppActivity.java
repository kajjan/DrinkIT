package com.TDA367.drinkit.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.TDA367.drinkit.Controller.Controller;
import com.TDA367.drinkit.Model.DrinkIT;

public class MainAppActivity extends AppCompatActivity {


    DrinkIT model = new DrinkIT();
    Controller ctrl = new Controller(model);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        InputStream charades = getResources().openRawResource(getResources().getIdentifier("charades", "raw", getPackageName()));
        InputStream neverHaveIEver = getResources().openRawResource(getResources().getIdentifier("neverhaveiever", "raw", getPackageName()));
        InputStream mostLikelyto = getResources().openRawResource(getResources().getIdentifier("mostlikelyto", "raw", getPackageName()));
        InputStream quiz = getResources().openRawResource(getResources().getIdentifier("quiz", "raw", getPackageName()));
        InputStream rules = getResources().openRawResource(getResources().getIdentifier("rules", "raw", getPackageName()));
        InputStream songs = getResources().openRawResource(getResources().getIdentifier("songs", "raw", getPackageName()));
        InputStream theme = getResources().openRawResource(getResources().getIdentifier("themes", "raw", getPackageName()));
        InputStream thisOrThat = getResources().openRawResource(getResources().getIdentifier("thisorthat", "raw", getPackageName()));
        InputStream truthOrDare = getResources().openRawResource(getResources().getIdentifier("truthordare", "raw", getPackageName()));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showStartPage();

        model.clearTheGame();

        textFileScanner(rules);
        textFileScanner(neverHaveIEver);
        textFileScanner(quiz);
        textFileScanner(mostLikelyto);
        textFileScanner(theme);
        textFileScanner(truthOrDare);
        textFileScanner(songs);
        textFileScanner(thisOrThat);
        textFileScanner(charades);

    }


    // MainView view = new MainView(ctrl);


    void showStartPage() {
        Intent intent = new Intent(this, StartPageActivity.class);
        startActivity(intent);
    }

    public void textFileScanner(InputStream is){
        Scanner scan = new Scanner(is);
        List<String> challengesToClass = new ArrayList<>();
        String categoryName = scan.nextLine();
        String instruction = scan.nextLine();
        System.out.println(instruction);
        //ctrl.setChallengeInstruction(categoryName, instruction);
        while (scan.hasNextLine()) { //as long as there are challenges to get
            String challenge = scan.nextLine();
            challengesToClass.add(challenge);
            //ctrl.setChallenge(categoryName, challenge);
            System.out.println("hello" + challenge);
        }
        model.createCategoryListOnCreate(categoryName, instruction, challengesToClass);
    }

    MainView view = new MainView(ctrl);

}
