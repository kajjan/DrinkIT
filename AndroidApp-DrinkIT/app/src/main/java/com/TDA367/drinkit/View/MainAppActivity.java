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
    MainView view = new MainView(ctrl);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showStartPage();
        model.clearTheGame();

        try{
            categoryStore.readChallenges(getApplicationContext());
        }catch (Exception e){
            e.printStackTrace();
        }
   }

    /**
     * Method which creates and the startpage
     */
    void showStartPage() {
        Intent intent = new Intent(this, StartPageActivity.class);
        startActivity(intent);
    }



}
