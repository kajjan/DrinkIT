package com.TDA367.drinkit.Services;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class CategoryStoreTest {

    Context appContext = InstrumentationRegistry.getTargetContext();


    @Test
    public void jsonTest() {
        CategoryStore catstore = new CategoryStore();
        String file = "/Users/elineriksson/Documents/Github/DrinkIT/AndroidApp-DrinkIT/app/src/main/assets/charades.json";

        try {
            InputStream stream = new FileInputStream(file);
            String txt = catstore.readStream(stream);

            JSONObject categoryJSON = new JSONObject(txt);

            System.out.println(categoryJSON.getString("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void readChallengesTest() {
        CategoryStore catstore = new CategoryStore();

        try {
            catstore.readChallenges(appContext);

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
