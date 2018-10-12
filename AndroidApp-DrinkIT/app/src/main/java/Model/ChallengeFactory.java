package Model;

import java.util.List;

public class ChallengeFactory {

    public static Challenge createChallenge(String categoryName, String challenge){
        switch (categoryName){
            case "charades": return createChallengeWithAnswer(challenge);
            case "neverHaveIEver": return createChallengeWithPoints(challenge);
            case "mostLikelyTo": return createChallengeWithoutPoint(challenge);
            case "quiz": return createChallengeWithAnswer(challenge);
            case "rules": return createChallengeWithoutPoint(challenge);
            case "songs": return createChallengeWithAnswer(challenge);
            case "themes": return createChallengeWithoutPoint(challenge);
            case "thisOrThat": return createChallengeWithoutPoint(challenge);
            case "truthOrDare": return createChallengeWithPoints(challenge);
        }
        return null;
    }

    private static Challenge createChallengeWithPoints(String challenge) {
        String numberInString = challenge.replaceAll("[^0-9]+", "");
        int num = Integer.parseInt(numberInString);
        String textInString = challenge.replaceAll("[0-9]+", "");

        return (new ChallengeWithPoints(textInString, num));
    }

    private static Challenge createChallengeWithAnswer(String challenge) {
        String numberInString = challenge.replaceAll("[^0-9]+", "");
        int num = Integer.parseInt(numberInString);
        String textInString = challenge.replaceAll("[0-9]+", "");

        //answer också

        return (new ChallengeWithAnswer(textInString, num));
    }

    private static Challenge createChallengeWithoutPoint(String challenge) {
        return (new ChallengeWithoutPoint(challenge, 0));
    }



}
