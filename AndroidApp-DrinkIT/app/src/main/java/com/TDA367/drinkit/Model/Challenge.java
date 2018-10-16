package com.TDA367.drinkit.Model;

public abstract class Challenge {
    private String challenge;
    private int point;

    public Challenge(String challenge, int point) {
        this.challenge = challenge;
        this.point = point;
    }

    public String getChallenge() {
        return challenge;
    }

    public int getPoint() { return point; }

    public String getAnswer() {
        return null;
    }


}
