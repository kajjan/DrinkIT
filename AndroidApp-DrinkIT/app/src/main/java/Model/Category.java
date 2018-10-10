package Model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;

    //Kajjan härjar
    public String instruction;
   // private String charades, neverhaveiever;
    //private List<Challenge> charadChallenges = new ArrayList<>();
    //private List<Challenge> neverHaveIEverChallenges = new ArrayList<>();
    public List<Challenge> challenges = new ArrayList<>();
    public boolean active;

    /*
    public Category(String name) { //I think Alice and Elin uses this method?
        this.name = name;
    }
*/
    public Category() {
    }

    public Category(String instruction, List<Challenge> challenges, boolean active){
        this.instruction = instruction;
        this.challenges = challenges;
        this.active = active;
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

    /*
    private void setName(String name){
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

*/
}
