package Model;

import java.util.List;

public class ThisOrThatCategory extends Category {
    protected ThisOrThatCategory(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);
    }

    @Override
    public String getPresentableName() {return "This or That"; }
}
