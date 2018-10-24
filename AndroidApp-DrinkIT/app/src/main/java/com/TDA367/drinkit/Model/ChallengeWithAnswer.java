package com.TDA367.drinkit.Model;

public class ChallengeWithAnswer extends Challenge {

    String answer;

    public ChallengeWithAnswer(String challenge, String answer, int point) {
        super(challenge, null, point);
        this.answer = answer;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

}
