package com.TDA367.drinkit.Model;

import java.util.List;

public class ChallengeFactory {

    public static Challenge createChallenge(String categoryName, String challenge){
        switch (categoryName){
            case "Charades": return createChallengeWithAnswer(challenge);
            case "Never Have I Ever": return createChallengeWithoutPoint(challenge);
            case "Most Likely To": return createChallengeWithoutPoint(challenge);
            case "Quiz": return createChallengeWithAnswer(challenge);
            case "Rules": return createChallengeWithoutPoint(challenge);
            case "Songs": return createChallengeWithAnswer(challenge);
            case "Themes": return createChallengeWithoutPoint(challenge);
            case "This or That": return createChallengeWithoutPoint(challenge);
            case "Truth or Dare": return createChallengeWithPoints(challenge);
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
