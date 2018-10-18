package com.TDA367.drinkit.Model;

import java.util.List;

public class TruthOrDareCategory extends Category {
    public TruthOrDareCategory(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);
    }

    @Override
    public String getPresentableName() {return "Truth or Dare"; }

}
