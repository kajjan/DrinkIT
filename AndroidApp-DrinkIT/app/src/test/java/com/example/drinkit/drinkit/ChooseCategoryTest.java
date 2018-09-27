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


        String category = "Charades";
        String category2 = "Truth or dare";

        model.selectCategory(category);
        model.selectCategory(category2);

        for (String s:model.getCategoryNames()){
            if (category.equals(s)){
                b=true;
            }
            System.out.println(s);
        }

        int endLength = categories.size();

        assert(b);
        assert(initialLength+2==endLength);

    }


}