package com.TDA367.drinkit.Model;

public class WithAnswer extends ChallengeDecorator {

    Challenge challenge;

    String answer;

    public WithAnswer(String challenge, int point, String answer, Challenge c) {
        super(challenge, point);
        this.answer = answer;
        this.challenge = c;
    }
}
