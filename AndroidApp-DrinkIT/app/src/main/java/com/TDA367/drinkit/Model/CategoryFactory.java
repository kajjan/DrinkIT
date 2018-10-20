package com.TDA367.drinkit.Model;
import java.util.List;

public class CategoryFactory {

    public static Category createCategory(String categoryName, String instruction, List<String> challenges) {
        switch (categoryName) {
            case "NeverHaveIEver": return createCategory("Never Have I Ever", instruction, challenges);
            case "MostLikelyTo": return createCategory("Most Likely To", instruction, challenges);
            case "ThisOrThat": return createCategory("This or That", instruction, challenges);
            case "TruthOrDare": return createCategory("Truth or Dare", instruction, challenges);
        }
        return (new Category(categoryName, instruction, challenges, false));
    }


    /*
    public static Category createCategory(String categoryName, String instruction, List<String> challenges){
        switch (categoryName){
            case "Charades": return createCharade(categoryName, instruction, challenges);
            case "NeverHaveIEver": return createNeverHaveIEver("Never Have I Ever", instruction, challenges);
            case "MostLikelyTo": return createMostLikelyto("Most Likely To", instruction, challenges);
            case "Quiz": return createQuiz(categoryName, instruction, challenges);
            case "Rules": return createRules(categoryName, instruction, challenges);
            case "Songs": return createSongs(categoryName, instruction, challenges);
            case "Themes": return createTheme(categoryName, instruction, challenges);
            case "ThisOrThat": return createThisOrThat("This or That", instruction, challenges);
            case "TruthOrDare": return createTruthOrDare("Truth or Dare", instruction, challenges);
            default: System.out.println("Category dose not exist");
        }
        return null;
    }

    private static Category createTruthOrDare(String categoryName, String instruction, List<String> challenges) {
        return (new TruthOrDareCategory(categoryName, instruction, challenges, false));
    }

    private static Category createThisOrThat(String categoryName, String instruction, List<String> challenges) {
        return (new ThisOrThatCategory(categoryName, instruction, challenges, false));
    }

    private static Category createTheme(String categoryName, String instruction, List<String> challenges) {
        return (new ThemesCategory(categoryName, instruction, challenges, false));
    }

    private static Category createSongs(String categoryName, String instruction, List<String> challenges) {
        return (new SongsCategory(categoryName, instruction, challenges, false));
    }

    private static Category createRules(String categoryName, String instruction, List<String> challenges) {
        return (new RulesCategory(categoryName, instruction, challenges, false));
    }

    private static Category createQuiz(String categoryName, String instruction, List<String> challenges) {
        return (new QuizCategory(categoryName, instruction, challenges, false));
    }

    private static Category createMostLikelyto(String categoryName, String instruction, List<String> challenges) {
        return (new MostLikelyToCategory(categoryName, instruction, challenges, false));
    }

    private static Category createCharade(String categoryName, String instruction, List<String> challenges){
        return (new CharadeCategory(categoryName, instruction, challenges, false));
    }

    private static Category createNeverHaveIEver(String categoryName, String instruction, List<String> challenges){
        return (new NeverHaveIEverCategory(categoryName, instruction, challenges, false));
    }
    */

}
