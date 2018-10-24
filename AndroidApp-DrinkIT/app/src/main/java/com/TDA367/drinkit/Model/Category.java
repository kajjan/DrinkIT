package com.TDA367.drinkit.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** This class represents a Category
 *
 * The class mostly sets and gets its instances.
 *
 *  * @authors Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class Category {

    private String name;
    private String instruction;
    private boolean active = false;
    private List<Challenge> challenges = new ArrayList<>();
    private int indexOfActiveChallenge = 0;

    public Category() { }

    public Category(String name){
        this.name=name;
    }

    public Category(String name, String instruction, List<Challenge> challenges){
        this.name = name;
        this.instruction = instruction;
        this.challenges = challenges;
        this.active = false;
    }

    public void setActive() {
        this.active = true;
    }

    public void setInActive() {
        this.active = false;
    }

    public boolean isActive() { return active; }

    public String getInstruction() {
        return instruction;
    }

    public String getName() {
        return name;
    }

    /**
     * @return's gets ChallengeText from indexOfActiveChallenge, from the list challenges,
     */
    public String getChallengeToPlay() { return challenges.get(indexOfActiveChallenge).getChallengeText(); }

    /**
     * @return's the active challenge's point
     */
    public int getActiveChallengePoint(){ return challenges.get(indexOfActiveChallenge).getPoint(); }

    /**
     * Increases the index of the active challenge, and then shufles the challenges to then set the index of the
     * active challenge to 0
     */
    public void increaseIndexOfActiveChallenge() {
        indexOfActiveChallenge++;
        if(indexOfActiveChallenge==challenges.size()){
            Collections.shuffle(challenges);
            indexOfActiveChallenge=0;
        }
    }

    /**
     * @return's the index of the active challenge
     */
    public Challenge getActiveChallenge(){ return challenges.get(indexOfActiveChallenge); }

    public void shuffleChallenges() { Collections.shuffle(challenges); }

}
