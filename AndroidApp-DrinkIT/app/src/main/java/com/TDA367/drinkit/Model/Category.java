package com.TDA367.drinkit.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** This class represents a Category and has a players name, challenge instruction, list of challenges as strings,
 *  a boolean active set to false, a list of Challenges, and the index of active challenge set to 0.
 *
 * The class mostly sets and gets its instances. (????)
 * VAD SKA MAN SÄGA?
 *
 *  * @author Kajsa Bjäräng, Viktoria Enderstein, Elin Eriksson, Lisa Fahlbeck, Alice Olsson
 */

public class Category {

    private String name;
    private String instruction;
    private List<String> challengesStrings = new ArrayList<>();
    private boolean active = false;
    private List<Challenge> challenges = new ArrayList<>();
    private int indexOfActiveChallenge = 0;


    public Category() { }

    public Category(String name){
        this.name=name;
    }

    public Category(String name, String instruction, List<String> challengesStrings, boolean active){
        this.name = name;
        this.instruction = instruction;
        this.challengesStrings = challengesStrings;
        this.active = active;
        setListOfChallenges(challengesStrings);
    }

    /**
     * Looks throgh challengeString list and then adds to challenges list via ChallengeFactory
     * @param challengeString
     */
    private void setListOfChallenges(List<String> challengeString) {
        for(String s: challengeString){
            challenges.add(ChallengeFactory.createChallenge(name, s));
        }
    }

    public void setActive() {
        this.active = true;
    }

    public void setInActive() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getName() {
        return name;
    }

    /**
     * @return's gets ChallengeText from indexOfActiveChallenge, from the list challenges,
     */
    public String getChallengeToPlay() {
        return challenges.get(indexOfActiveChallenge).getChallengeText();
    }

    //want to get rid of this one
    public String getPreviousChallenge() {
        return challenges.get(indexOfActiveChallenge-1).getChallengeText();
    }

    /**
     * @return's the active challenge's point
     */
    public int getActiveChallengePoint(){
        return challenges.get(indexOfActiveChallenge).getPoint();
    }

    /**
     * Increases the index of the active challenge, and then shufles the challenges to then set the index of the
     * active challenge to 0
     */
    public void increaseIndexOfActiveChallenge() {
        indexOfActiveChallenge++;

        if(indexOfActiveChallenge==challenges.size()-1){
            Collections.shuffle(challenges);
            indexOfActiveChallenge=0;
        }
    }

    /**
     * @return's the index of the active challenge
     */
    public Challenge getActiveChallenge(){
        return challenges.get(indexOfActiveChallenge);
    }

}
