package com.TDA367.drinkit.Model;

import java.util.List;

public class QuizCategory extends Category {
    public QuizCategory(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);
    }
}
