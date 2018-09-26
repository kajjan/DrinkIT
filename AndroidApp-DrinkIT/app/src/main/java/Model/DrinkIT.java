package Model;

import java.util.ArrayList;
import java.util.List;

public class DrinkIT {
    private List<Player> players;
    private List<Card> cards;
    private List<Challenge> challenges;
    private int duration;

    public DrinkIT(List<Player> players, List<Card> cards, List<Challenge> challenges, int duration) {
        this.players = players;
        this.cards = cards;
        this.challenges = challenges;
        this.duration = duration;
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void setDuration(List<Player> players, int duration){

        duration = players.size()*duration;
    }

    //medtod för test
    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        for (Player p : players) {
            names.add(p.getName());
        }

        return names;
    }
}
