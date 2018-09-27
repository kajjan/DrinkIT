package com.example.drinkit.drinkit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import Model.Category;
import Model.DrinkIT;
import Model.Player;

import static org.junit.Assert.*;

public class ChooseCategoryTest {

    @Test
    public void selectCategory() {


        DrinkIT model = new DrinkIT(null, null, null);
        boolean b = false;
        List<Category> categories = model.getCategories();
        int initialLength = categories.size();


        String category = "category1";
        String CategoryTwo = "category2";
        String three = "category3";

        model.selectCategory(category);

        for (String s:model.getCategoryNames()){
            if (category.equals(s)){
                b=true;
            }
        }

        int endLength = categories.size();

        assert(b);
        assert(initialLength+1==endLength);

    }


}