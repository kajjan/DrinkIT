package Model;

import java.util.List;

public class ThemeCategory extends Category {
    protected ThemeCategory(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);
    }
}
