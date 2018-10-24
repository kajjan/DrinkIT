package com.TDA367.drinkit.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChooseCategoryTest {

    List<Category> cats = new ArrayList<>();
    List<Challenge> challenges = new ArrayList<>();
    DrinkIT model;


    Category quiz = new Category("Quiz", "this is an instruction", challenges);
    Category charades = new Category("Charades", "this is an instruction", challenges);

    public ChooseCategoryTest() {

        cats.add(quiz);
        cats.add(charades);

        model = new DrinkIT(null, 0, null, 0, cats,-1, null);
    }

    @Test
    public void getNextCategory(){

        for(Category c: cats){
            if(c.getName().equals("Charades")){
                c.setActive();
            }
            if(c.getName().equals("Quiz")){
                c.setInActive();
            }
        }

        String nextCategory = model.getNextCategory();
        assert(nextCategory.equals("Charades"));

        for(Category c: cats){
            if(c.getName().equals("Charades")){
               c.setInActive();
            }
            if(c.getName().equals("Quiz")){
                c.setActive();
            }
        }

        nextCategory = model.getNextCategory();
        assert(!nextCategory.equals("Charades"));
        assert(nextCategory.equals("Quiz"));
   }

    @Test
    public void chooseCategory() {

        quiz.setInActive();
        model.chooseCategory("Quiz");

        charades.setActive();
        model.chooseCategory("Charades");

        assert (quiz.isActive());
        assert (!charades.isActive());

    }

    /*
    @Test
    public void atLeastOneCategoryChosen(){

        cats.get(0).setActive();

        assert(model.atLeastOneCategoryChosen());

        for(Category c: cats){
            if(c.getName().equals("Charades")){
                c.setInActive();
            }
            if(c.getName().equals("Quiz")){
                c.setInActive();
            }
        }
        assert(!model.atLeastOneCategoryChosen());
    }
*/
}