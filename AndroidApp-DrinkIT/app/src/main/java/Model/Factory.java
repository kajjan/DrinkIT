package Model;

import java.util.List;

public class Factory {

    public static Category createCategory(String categoryName, String instruction, List<String> challenges){
        if (categoryName.equals("Charades")){
            return createCharade(categoryName, instruction, challenges);
        }
        if (categoryName.equals("NeverHaveIEver")){
            return createNeverHaveIEver(categoryName, instruction, challenges);
        }
        return null;
    }

    private static Category createCharade(String categoryName, String instruction, List<String> challenges){
        Charade charade = new Charade(categoryName, instruction, challenges, false);
        return charade;
    }

    private static Category createNeverHaveIEver(String categoryName, String instruction, List<String> challenges){
        NeverHaveIEver neverHaveIEver  = new NeverHaveIEver(categoryName, instruction, challenges, false);
        return neverHaveIEver;
    }
}
