package com.TDA367.drinkit.Model;

import java.util.List;

public class MostLikelyToCategory extends Category {

    protected MostLikelyToCategory(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);

    }

    @Override
    public String getPresentableName() {return "Most Likely To"; }

}
