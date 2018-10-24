package com.TDA367.drinkit.Model;

/**
 * This abstract class represents a challenge and consist of a String challengeText and a point
 *
 * @authors Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public abstract class Challenge {
    private String challengeText;
    private int point;

    public Challenge(String challenge, int point) {
        this.challengeText = challenge;
        this.point = point;
    }

    /**
     * @return string challengeText
     */
    public String getChallengeText() {
        return challengeText;
    }

    /**
     * @return int point
     */
    public int getPoint() { return point; }

    /**
     * @returns null since the answer get set later SE HIT NÄR CHALLENGES ÄR FIXAT
     */
    public String getAnswer() {
        return null;
    }


}
