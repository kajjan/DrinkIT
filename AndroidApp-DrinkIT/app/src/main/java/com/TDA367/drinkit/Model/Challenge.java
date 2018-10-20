package com.TDA367.drinkit.Model;

public abstract class Challenge {
    private String challengeText;
    private int point;

    public Challenge(String challenge, int point) {
        this.challengeText = challenge;
        this.point = point;
    }

    public String getChallengeText() {
        return challengeText;
    }

    public int getPoint() { return point; }

    public String getAnswer() {
        return null;
    }


}
