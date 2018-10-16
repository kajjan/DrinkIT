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


        DrinkIT model = new DrinkIT();
        boolean b = false;
        List<Category> categories = model.getCategories();
        int initialLength = categories.size();


        String category = "Charades";
        String category2 = "Truth or truthordare";


        //categories.add(new Category(category));
        //categories.add(new Category(category2));

        /*
        for (String s:model.getCategoryNames()){
            if (category.equals(s)){
                b=true;
            }
            System.out.println(s);
        }
        */

        int endLength = categories.size();

        assert(b);
        assert(initialLength+2==endLength);

    }

    @Test
    public void removeCategory() {
        DrinkIT model = new DrinkIT( );
        List<Category> categories = model.getCategories();

        String category = "Charades";
        String category2 = "Truth or truthordare";

        //categories.add(new Category(category));
        //categories.add(new Category(category2));

        int initialLength = categories.size();

        //model.unSelectCategory(category);

        int endLength = categories.size();

        assert(endLength==initialLength-1);
        assert(categories.size()==1);


    }


}