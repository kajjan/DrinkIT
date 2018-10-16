package Model;

public class ChallengeWithAnswer extends Challenge {

    String answer;

    public ChallengeWithAnswer(String challenge, String answer, int point) {
        super(challenge, point);
        this.answer = answer;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

}
