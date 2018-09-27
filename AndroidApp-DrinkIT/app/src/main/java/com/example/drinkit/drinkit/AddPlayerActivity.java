package com.example.drinkit.drinkit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import java.util.ArrayList;

public class AddPlayerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        //setContentView(R.layout.activity_choose_category);
    }

    public void nextToCategoryPage(View view) {
        startActivity(new Intent(AddPlayerActivity.this, ChooseCategoryActivity.class));
    }


}
