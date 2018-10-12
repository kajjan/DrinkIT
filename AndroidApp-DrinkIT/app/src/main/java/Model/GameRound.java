package Model;

public class GameRound {

    private Player player;
    private Challenge challenge;
    private boolean succeded;

    public GameRound(Player player, Challenge challenge) {
        this.player = player;
        this.challenge = challenge;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public boolean isSucceded() {
        return succeded;
    }

    public void setSucceded(boolean succeded) {
        this.succeded = succeded;
    }
}
