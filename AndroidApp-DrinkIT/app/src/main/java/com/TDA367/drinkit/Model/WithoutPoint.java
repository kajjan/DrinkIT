package com.TDA367.drinkit.Model;

public class WithoutPoint extends ChallengeDecorator {

    Challenge challenge;

    public WithoutPoint(String challengeString, int point, Challenge c) {
        super(challengeString, point);
        this.challenge = c;
    }
}
