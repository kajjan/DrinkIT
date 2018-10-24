package com.TDA367.drinkit.View;

import android.content.Context;
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
import com.TDA367.drinkit.Services.CategoryStore;

/**
 * This is the mainAppActivity class which starts the whole game
 *
 * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class MainAppActivity extends AppCompatActivity {

    DrinkIT model = new DrinkIT();
    Controller ctrl = new Controller(model);

    CategoryStore categoryStore = new CategoryStore(ctrl);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

 /*       List<InputStream> inputStream = new ArrayList<>();

        InputStream charades = getResources().openRawResource(getResources().getIdentifier("charades", "raw", getPackageName())); inputStream.add(charades);
        InputStream neverHaveIEver = getResources().openRawResource(getResources().getIdentifier("neverhaveiever", "raw", getPackageName())); inputStream.add(neverHaveIEver);
        InputStream mostLikelyto = getResources().openRawResource(getResources().getIdentifier("mostlikelyto", "raw", getPackageName())); inputStream.add(mostLikelyto);
        InputStream quiz = getResources().openRawResource(getResources().getIdentifier("quiz", "raw", getPackageName())); inputStream.add(quiz);
        InputStream rules = getResources().openRawResource(getResources().getIdentifier("rules", "raw", getPackageName())); inputStream.add(rules);
        InputStream songs = getResources().openRawResource(getResources().getIdentifier("songs", "raw", getPackageName())); inputStream.add(songs);
        InputStream themes = getResources().openRawResource(getResources().getIdentifier("themes", "raw", getPackageName())); inputStream.add(themes);
        InputStream thisOrThat = getResources().openRawResource(getResources().getIdentifier("thisorthat", "raw", getPackageName())); inputStream.add(thisOrThat);
        InputStream truthOrDare = getResources().openRawResource(getResources().getIdentifier("truthordare", "raw", getPackageName())); inputStream.add(truthOrDare);
*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showStartPage();
        model.clearTheGame();

        try{
            categoryStore.readChallenges(getApplicationContext());
        }catch (Exception e){
            e.printStackTrace();
        }

  /*      for (InputStream is : inputStream) {
            textFileScanner(is);
        }*/
    }

    /**
     * Method which creates and the startpage
     */
    void showStartPage() {
        Intent intent = new Intent(this, StartPageActivity.class);
        startActivity(intent);
    }

    MainView view = new MainView(ctrl);
/*
    //TODO ska denna vara kvar efter fixet med nya JSON filerna
    public void textFileScanner(InputStream is){
        Scanner scan = new Scanner(is);
        List<String> challengesToClass = new ArrayList<>();
        String categoryName = scan.nextLine();
        String instruction = scan.nextLine();
        System.out.println(instruction);
        while (scan.hasNextLine()) { //as long as there are challenges to get
            String challenge = scan.nextLine();
            challengesToClass.add(challenge);
        }
        model.createCategoryListOnCreate(categoryName, instruction, challengesToClass);
    }
*/

}
