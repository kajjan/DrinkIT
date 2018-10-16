package Model;

import java.util.List;

public class NeverHaveIEverCategory extends Category {

    protected NeverHaveIEverCategory(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);

    }

    @Override
    public String getPresentableName() {return "Never Have I Ever"; }

}
