package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrinkIT {
    protected List<Player> players = new ArrayList<>();
    private List<Card> cards;
    private List<Challenge> challenges;
    private int durationOfGame;
    private List<Player> completeListOfPlayers;


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
        // completeListOfPlayers =createCompletedPlayersList(players, durationOfGame);
        // completeListOfPlayers= shufflePlayerList(completeListOfPlayers);
    }

    public int getDurationOfGame() {
        return durationOfGame;
    }


    //method to create a complete list with all the players multiplide with the duration time.
    //connected from setDuration maybe not the best solution?
    public List<Player> createCompletedPlayersList (List<Player> listOfPlayers, int durationOfGame){
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

    //shuffle the completePlayerList
    public List<Player>shufflePlayerList (List<Player>listOfPlayers){
        Collections.shuffle(listOfPlayers);
        return listOfPlayers;
    }


    //method to get the name of the player in the list. Need to get so that the index is controlled somewhere else.
    public String getNameOfPlayer (List<Player>listOfPlayer, int index){
        String name= listOfPlayer.get(index).getName();
        System.out.println(name);
        return name;
    }

    //Write a method that keep track of what index in the list of players we are at and wich should be shown. Now it only shows the firt in the list to se that the other methods works.
    public int getIndexForChallenge(){
        int i=0;
        return i;
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
