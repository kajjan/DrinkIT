package Model;

import java.util.ArrayList;
import java.util.List;

public class DrinkIT {
    protected List<Player> players = new ArrayList<>();
    private List<Card> cards;
    private List<Challenge> challenges;
    private int durationOfGame;


    public DrinkIT(List<Player> players, List<Card> cards, List<Challenge> challenges, int durationOfGame) {
        this.players = players;
        this.cards = cards;
        this.challenges = challenges;
        this.durationOfGame = durationOfGame;
    }
    public DrinkIT() {

    }



    //Temporary constructor för duartion method
    public DrinkIT(List<Player> players) {
        this.players = players;
    }


    public void addPlayer(String name) {
        players.add(new Player(name));
    }



    public void setDuration(List<Player> players, int duration){
        System.out.println("Knappen för vald tid är tryckt och antalet spelare multipliceras med "+ duration);

        durationOfGame = players.size()*duration;

    }

    public int getDurationOfGame() {
        return durationOfGame;
    }


    //method to create a complete list with all the players multiplide with the duration time.
    //Not connected to anything yet. But works!!!!
    public List<Player> completedPlayersList (List<Player> listOfPlayers, int durationOfGame){
        List<Player>completePlayerList = new ArrayList<>(durationOfGame);
        int challengePerPlayer = durationOfGame/listOfPlayers.size();
        int i=0;
        for(Player player: listOfPlayers){

            while(i!=challengePerPlayer) {
                completePlayerList.add(player);
                i++;
            }
            if(i==challengePerPlayer){
                i=0;
            }
        }
        System.out.println(completePlayerList);
        return completePlayerList;
    }





    public List<Player> getPlayers() {
        return players;
    }



    //Helpmethods for tests below


    //method for test
    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        for (Player p : players) {
            names.add(p.getName());
        }

        return names;
    }

    //Constructor for tests
    public DrinkIT(List<Player> players, List<Card> cards, List<Challenge> challenges) {
        this.players = players;
        this.cards = cards;
        this.challenges = challenges;
    }
}
