package com.TDA367.drinkit.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import com.TDA367.drinkit.Model.Category;
import com.TDA367.drinkit.Model.DrinkIT;
import com.TDA367.drinkit.Model.Player;


import com.TDA367.drinkit.Model.CategoryFactory;

import static org.junit.Assert.*;

public class ChooseCategoryTest {

    List<Category> cats = new ArrayList<>();
    List<String> challenges = new ArrayList<>();
    DrinkIT model;


    Category quiz = CategoryFactory.createCategory("quiz", "this is an instruction", challenges);
    Category charades = CategoryFactory.createCategory("charades", "this is an instruction", challenges);

    public ChooseCategoryTest() {

        cats.add(quiz);
        cats.add(charades);

        model = new DrinkIT(null, 0, null, null,
                0, cats, -1, null, null,
                null, null, null, null);


    }
/*
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


        for (String s:model.getCategoryNames()){
            if (category.equals(s)){
                b=true;
            }
            System.out.println(s);
        }

        int endLength = categories.size();

        assert (b);
        assert (initialLength + 2 == endLength);

    }*/

    @Test
    public void getNextCategory(){

        for(Category c: cats){
            if(c.getName().equals("charades")){
                c.setActive();
            }
            if(c.getName().equals("quiz")){
                c.setInActive();
            }
        }

        String nextCategory = model.getNextCategory();
        assert(nextCategory.equals("charades"));

        for(Category c: cats){
            if(c.getName().equals("charades")){
               c.setInActive();
            }
            if(c.getName().equals("quiz")){
                c.setActive();
            }
        }

        nextCategory = model.getNextCategory();
        assert(!nextCategory.equals("charades"));
        assert(nextCategory.equals("quiz"));
   }


    @Test
    public void chooseCategory() {

        quiz.setInActive();
        model.chooseCategory("quiz");

        charades.setActive();
        model.chooseCategory("charades");

        assert (quiz.isActive());
        assert (!charades.isActive());

    }


    @Test
    public void atLeastOneCategoryChosen(){

        cats.get(0).setActive();

        assert(model.atLeastOneCategoryChosen());

        for(Category c: cats){
            if(c.getName().equals("charades")){
                c.setInActive();
            }
            if(c.getName().equals("quiz")){
                c.setInActive();
            }
        }
        assert(!model.atLeastOneCategoryChosen());
    }

}