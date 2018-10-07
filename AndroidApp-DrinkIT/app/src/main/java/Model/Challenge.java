package Model;

public class Challenge {
    private String challenge;
    private int point;

    public Challenge(String challenge, int point) {
        this.challenge = challenge;
        this.point = point;
    }

    public String getChallenge() {
        return challenge;
    }

    public int getPoint() {
        return point;
    }

}
