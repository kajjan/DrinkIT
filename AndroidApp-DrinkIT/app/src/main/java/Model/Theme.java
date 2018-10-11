package Model;

import java.util.List;

public class Theme extends Category {
    protected Theme(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);
    }
}
