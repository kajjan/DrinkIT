package Model;

import java.util.List;

public class TruthOrDare extends Category {
    protected TruthOrDare(String name, String instruction, List<String> challenges, boolean active) {
        super(name, instruction, challenges, active);
    }
}
