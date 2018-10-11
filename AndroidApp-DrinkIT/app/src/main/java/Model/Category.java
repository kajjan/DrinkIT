package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Category {

    private String name;

    //Kajjan härjar
    public String instruction;
    public List<String> challengesStrings = new ArrayList<>();
    public boolean active;
    private List<Challenge> challenges = new ArrayList<>();
    public int indexOfActiveChallenge = -1;


    public Category() { }

    public Category(String name){
        this.name=name;
    }

    public Category(String instruction, List<String> challengesStrings, boolean active){
        this.instruction = instruction;
        this.challengesStrings = challengesStrings;
        this.active = active;
        setListOfChallenges(challengesStrings);
    }

    public void setListOfChallenges(List<String> challengeString) {
        for(String s: challengeString){
            String numberInString = s.replaceAll("[^0-9]+", "");
            int num = Integer.parseInt(numberInString);
            String textInString = s.replaceAll("[0-9]+", "");
            challenges.add(new Challenge(textInString, num)); //Creates a new challenge
        }
        System.out.println("LOOK HERE!!!!!! --->>>" +challenges.get(0).getChallenge());
        System.out.println("LOOK HERE!!!!!! --->>>" +challenges.get(1).getChallenge());
        System.out.println("LOOK HERE!!!!!! --->>>" +challenges.get(2).getChallenge());
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getCategoryName() {
        return name;
    }

    public String getActiveChallenge(){
        indexOfActiveChallenge++;
        if(indexOfActiveChallenge==challenges.size()){
            Collections.shuffle(challenges);
            indexOfActiveChallenge=0;
        }
        return challenges.get(indexOfActiveChallenge).getChallenge();
    }

}
