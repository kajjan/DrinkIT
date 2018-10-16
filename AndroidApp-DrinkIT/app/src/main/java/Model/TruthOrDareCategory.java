package Model;

import java.util.List;

public class TruthOrDareCategory extends Category {
    protected TruthOrDareCategory(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);
    }

    @Override
    public String getPresentableName() {return "Truth or Dare"; }

}
