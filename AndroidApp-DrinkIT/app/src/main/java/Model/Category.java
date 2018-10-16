package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Category {

    private String name;
    public String instruction;
    public List<String> challengesStrings = new ArrayList<>();
    public boolean active = false;
    private List<Challenge> challenges = new ArrayList<>();
    public int indexOfActiveChallenge = 0;


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

    public void setListOfChallenges(List<String> challengeString) {
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

    public String getPresentableName() {return name; }

    public String getChallengeToPlay(){
        if(indexOfActiveChallenge==challenges.size()-1){
            Collections.shuffle(challenges);
            indexOfActiveChallenge=0;
        }
        indexOfActiveChallenge++;
        return challenges.get(indexOfActiveChallenge).getChallenge();
    }

    public int getActiveChallengePoint(){
        return challenges.get(indexOfActiveChallenge).getPoint();
    }

    public Challenge getActiveChallenge(){
        return challenges.get(indexOfActiveChallenge);
    }
}
