package com.TDA367.drinkit.Services;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.TDA367.drinkit.Controller.Controller;
import com.TDA367.drinkit.Model.Category;
import com.TDA367.drinkit.Model.DrinkIT;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class CategoryStoreTest {

    Context appContext = InstrumentationRegistry.getTargetContext();

    //is it correct to add these here?
    DrinkIT model = new DrinkIT();
    Controller ctrl = new Controller(model);

    CategoryStore catstore = new CategoryStore(ctrl);

    @Test
    public void jsonTest() {
        //String file = "/Users/elineriksson/Documents/Github/DrinkIT/AndroidApp-DrinkIT/app/src/main/assets/charades.json";

        String file = "/Users/lisaf/Desktop/TDA367/DrinkIT/AndroidApp-DrinkIT>/app/src/main/assets/charades.json";
        try {
            InputStream stream = new FileInputStream(file);
            String txt = catstore.readStream(stream);

            JSONObject categoryJSON = new JSONObject(txt);

            System.out.println(categoryJSON.getString("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readChallengesTest() {

        try {
            catstore.readChallenges(appContext);
            System.out.println("LOOK HERE--> " + catstore.getCategories().get(2).getName());

        }
        catch (Exception e){
            e.printStackTrace();
        }

        for (Category c : catstore.getCategories()){
            System.out.println(c.getName());
        }
        assert(catstore.getCategories().size()==9);
        assert(model.getCategories().size()==9);
      /*  assert(catstore.getCategories().get(0).getName().equals("Charades"));
        assert(catstore.getCategories().get(5).getInstruction().equals("Here are the instructions for the category Songs"));
*/

    }
}
