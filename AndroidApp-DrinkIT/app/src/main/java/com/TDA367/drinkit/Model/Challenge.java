package com.TDA367.drinkit.Model;

public class Challenge {
    private String challengeText;
    String answerText;
    private int point;

    public Challenge(String challenge, String answer, int point) {
        this.challengeText = challenge;
        this.answerText = answer;
        this.point = point;
    }

    public String getChallengeText() {
        return challengeText;
    }

    public String getAnswer() { return answerText; }

    public int getPoint() { return point; }


}
