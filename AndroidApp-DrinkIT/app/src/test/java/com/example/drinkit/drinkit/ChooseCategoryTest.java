package com.example.drinkit.drinkit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import Model.Category;
import Model.CategoryFactory;
import Model.Challenge;
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
        String category2 = "Truth or dare";


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
        String category2 = "Truth or dare";

        //categories.add(new Category(category));
        //categories.add(new Category(category2));

        int initialLength = categories.size();

        //model.unSelectCategory(category);

        int endLength = categories.size();

        assert(endLength==initialLength-1);
        assert(categories.size()==1);


    }

    @Test
    public void chooseCategory(){

        List<Category> cats = new ArrayList<>();
        List<String> challenges = new ArrayList<>();

        Category quiz = CategoryFactory.createCategory("quiz", "this is an instruction", challenges);
        Category charades = CategoryFactory.createCategory("charades", "this is an instruction", challenges);


        DrinkIT drinkIT = new DrinkIT(null, 0, null, null,
                0, cats, 0, null, null,
                null, null, null, null);

        cats.add(quiz);
        cats.add(charades);

        quiz.setInActive();
        drinkIT.chooseCategory("quiz");

        charades.setActive();
        drinkIT.chooseCategory("charades");

        assert(quiz.isActive());
        assert(!charades.isActive());

    }

}