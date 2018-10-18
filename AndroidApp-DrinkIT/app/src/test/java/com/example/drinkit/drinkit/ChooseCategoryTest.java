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

    List<Category> cats = new ArrayList<>();
    List<String> challenges = new ArrayList<>();

    Category quiz = CategoryFactory.createCategory("quiz", "this is an instruction", challenges);
    Category charades = CategoryFactory.createCategory("charades", "this is an instruction", challenges);


    /* @Test
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


        int endLength = categories.size();

        assert (b);
        assert (initialLength + 2 == endLength);

    }
*/
   /* @Test
    public void getNextCategory() {
        DrinkIT drinkIT = new DrinkIT(null, 0, null, null,
                0, cats, 0, null, null,
                null, null, null, null);

        cats.add(quiz);
        cats.add(charades);

        String nextCategory = drinkIT.getNextCategory();


        assert(nextCategory.equals("charades"));




    } */

    @Test
    public void chooseCategory() {

        DrinkIT drinkIT = new DrinkIT(null, 0, null, null,
                0, cats, 0, null, null,
                null, null, null, null);

        cats.add(quiz);
        cats.add(charades);

        quiz.setInActive();
        drinkIT.chooseCategory("quiz");

        charades.setActive();
        drinkIT.chooseCategory("charades");

        assert (quiz.isActive());
        assert (!charades.isActive());

    }

}