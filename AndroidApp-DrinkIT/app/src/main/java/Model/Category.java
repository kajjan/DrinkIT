package Model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;

    //Kajjan härjar
    private String instruction;
    private String charades, neverhaveiever;
    private List<Challenge> charadChallenges = new ArrayList<>();
    private List<Challenge> neverHaveIEverChallenges = new ArrayList<>();

    public Category(String name) { //I think Alice and Elin uses this method?
        this.name = name;
    }

    public Category() {
    }

    public Category(String name, String instruction){
        setNameAndList(name);
        this.instruction = instruction;
    }

    private void setNameAndList(String name){
        if (name.equals("charades")){
            this.charades = name;
        }
        if (name.equals("neverHaveIEver")){
            this.neverhaveiever = name;
        }
        else {
            //skip for now
        }

    }

    public void addChallenge(String name, Challenge challenge){ //Adds challenge to the right list
        if (name.equals("charades")){
            charadChallenges.add(challenge);
        }
        if (name.equals("neverHaveIEver")){
            neverHaveIEverChallenges.add(challenge);
        }
    }

    public String getCategoryName() {
        return name;
    }

    public String getName(String name) {
        if (name.equals(charades)) {
            return charades;
        }
        if (name.equals(neverhaveiever)) {
            return neverhaveiever;
        } else {
            return "Hello";
        }
    }

    public List<Challenge> getCharadChallenges() {
        return charadChallenges;
    }

    public List<Challenge> getNeverHaveIEverChallenges() {
        return neverHaveIEverChallenges;
    }

    public String getInstruction() {
        return instruction;
    }


}
