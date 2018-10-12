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
        int number = Integer.parseInt(numberInString);
        String text = challenge.replaceAll("[0-9]+", "");

        return (new ChallengeWithPoints(text, number));
    }

    private static Challenge createChallengeWithAnswer(String challenge) {
        String numberInString = challenge.replaceAll("[^0-9]+", "");
        int number = Integer.parseInt(numberInString);
        String textInString = challenge.replaceAll("[0-9]+", "");

        String[] parts = textInString.split("-");
        String challengeText = parts[0];
        String answerText = parts[1];

        return (new ChallengeWithAnswer(challengeText, answerText, number));
    }

    private static Challenge createChallengeWithoutPoint(String challenge) {
        return (new ChallengeWithoutPoint(challenge, 0));
    }



}
