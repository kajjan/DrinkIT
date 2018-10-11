package Model;

import java.util.List;

public class Quiz extends Category {
    protected Quiz(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);
    }
}
