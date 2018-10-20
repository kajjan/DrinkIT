package com.TDA367.drinkit.Model;

public abstract class ChallengeDecorator extends Challenge {

    Challenge challenge; //"Is a Challenge and has a challenge" vet inte om den ska med i konstruktorn
                        // men vad gör den annars här liksom

    public ChallengeDecorator(String challenge, int point) {
        super(challenge, point);
    }
}
