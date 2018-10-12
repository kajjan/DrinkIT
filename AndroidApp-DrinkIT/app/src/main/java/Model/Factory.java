package Model;
import java.util.List;

public class Factory {

    public static Category createCategory(String categoryName, String instruction, List<String> challenges){
        switch (categoryName){
            case "charades": return createCharade(categoryName, instruction, challenges);
            case "neverHaveIEver": return createNeverHaveIEver(categoryName, instruction, challenges);
            case "mostLikelyTo": return createMostLikelyto(categoryName, instruction, challenges);
            case "quiz": return createQuiz(categoryName, instruction, challenges);
            case "rules": return createRules(categoryName, instruction, challenges);
            case "songs": return createSongs(categoryName, instruction, challenges);
            case "theme": return createTheme(categoryName, instruction, challenges);
            case "thisOrThat": return createThisOrThat(categoryName, instruction, challenges);
            case "truthOrDare": return createTruthOrDare(categoryName, instruction, challenges);
        }
        return null;
    }

    private static Category createTruthOrDare(String categoryName, String instruction, List<String> challenges) {
        return (new TruthOrDare(categoryName, instruction, challenges, false));
    }

    private static Category createThisOrThat(String categoryName, String instruction, List<String> challenges) {
        return (new ThisOrThat(categoryName, instruction, challenges, false));
    }

    private static Category createTheme(String categoryName, String instruction, List<String> challenges) {
        return (new Theme(categoryName, instruction, challenges, false));
    }

    private static Category createSongs(String categoryName, String instruction, List<String> challenges) {
        return (new Songs(categoryName, instruction, challenges, false));
    }

    private static Category createRules(String categoryName, String instruction, List<String> challenges) {
        return (new Rules(categoryName, instruction, challenges, false));
    }

    private static Category createQuiz(String categoryName, String instruction, List<String> challenges) {
        return (new Quiz(categoryName, instruction, challenges, false));
    }

    private static Category createMostLikelyto(String categoryName, String instruction, List<String> challenges) {
        return (new MostLikelyTo(categoryName, instruction, challenges, false));
    }

    private static Category createCharade(String categoryName, String instruction, List<String> challenges){
        return (new CharadeCategory(categoryName, instruction, challenges, false));
    }

    private static Category createNeverHaveIEver(String categoryName, String instruction, List<String> challenges){
        return (new NeverHaveIEver(categoryName, instruction, challenges, false));
    }
}
