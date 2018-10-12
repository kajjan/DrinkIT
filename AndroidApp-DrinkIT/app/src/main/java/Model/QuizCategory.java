package Model;

import java.util.List;

public class QuizCategory extends Category {
    protected QuizCategory(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);
    }
}
