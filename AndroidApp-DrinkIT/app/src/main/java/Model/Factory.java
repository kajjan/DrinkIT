package Model;

import java.util.List;

public class Factory {

    public static Category createCategory(String categoryName, String instruction, List<String> challenges){
        if (categoryName.equals("Charades")){
            return createCharade(instruction, challenges);
        }
        if (categoryName.equals("NeverHaveIEver")){
            return createNeverHaveIEver(instruction, challenges);
        }
        return null;
    }

    private static Category createCharade(String instruction, List<String> challenges){
        Charade charade = new Charade(instruction, challenges, false);
        return charade;
    }

    private static Category createNeverHaveIEver( String instruction, List<String> challenges){
        NeverHaveIEver neverHaveIEver  = new NeverHaveIEver(instruction, challenges, false);
        return neverHaveIEver;
    }
}
