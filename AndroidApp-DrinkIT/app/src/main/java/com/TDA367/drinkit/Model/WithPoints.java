package com.TDA367.drinkit.Model;

public class WithPoints extends ChallengeDecorator {

    Challenge challenge;

    public WithPoints(String challengeString, int point, Challenge c) {
        super(challengeString, point);
        this.challenge = c; //DET HÄR ÄR NOG VIKTIGT KOM IHÅG 40:40 I UPPSALA VIDEON
    }
}
