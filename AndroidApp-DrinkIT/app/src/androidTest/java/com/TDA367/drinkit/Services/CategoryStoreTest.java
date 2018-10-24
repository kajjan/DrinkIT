package com.TDA367.drinkit.Services;

import com.TDA367.drinkit.Controller.Controller;
import com.TDA367.drinkit.Model.DrinkIT;

import org.json.JSONObject;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.InputStream;


public class CategoryStoreTest {

    //is it correct to add these here?
    DrinkIT model = new DrinkIT();
    Controller ctrl = new Controller(model);

    @Test
    public void jsonTest() {
        CategoryStore catstore = new CategoryStore(ctrl);
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
}
