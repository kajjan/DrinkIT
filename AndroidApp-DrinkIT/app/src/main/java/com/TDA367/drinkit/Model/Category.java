package com.TDA367.drinkit.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    //for JSON
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

    public boolean isActive() {
        return active;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getName() {
        return name;
    }

    public String getChallengeToPlay() {
        return challenges.get(indexOfActiveChallenge).getChallengeText();
    }

    //want to get rid of this one
    public String getPreviousChallenge() {
        return challenges.get(indexOfActiveChallenge-1).getChallengeText();
    }

    public int getActiveChallengePoint(){
        return challenges.get(indexOfActiveChallenge).getPoint();
    }

    public void increaseIndexOfActiveChallenge() {
        indexOfActiveChallenge++;

        if(indexOfActiveChallenge==challenges.size()-1){
            Collections.shuffle(challenges);
            indexOfActiveChallenge=0;
        }
    }

    public Challenge getActiveChallenge(){
        return challenges.get(indexOfActiveChallenge);
    }
}
