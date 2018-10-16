package com.TDA367.drinkit.Model;

import java.util.ArrayList;
import java.util.List;


public class CharadeCategory extends Category {


    protected CharadeCategory(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);

    }

    @Override
    public String getPresentableName() {return "Charades"; }

}
