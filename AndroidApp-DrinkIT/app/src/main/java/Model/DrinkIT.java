package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DrinkIT {
    static List<Player> players = new ArrayList<>();
    private List<Card> cards;
    private List<Challenge> challenges;
    static int durationOfGame;
    private List<Player> completeListOfPlayers;
    private List<Category> categories = new ArrayList<>();
    private List<Player>playerInPointOrder= new ArrayList<>();
    static List<String> playerList = new ArrayList<>();



    public DrinkIT() {}


    public void addPlayer(String name) {
        players.add(new Player(name));
    } //ok


    public void setDuration(List<Player> players, int duration) {//ta bara in duration och hämta lämgden från listan som ka finnas här i modellen.
        System.out.println("Knappen för vald tid är tryckt och antalet spelare multipliceras med "+ duration);

        durationOfGame = players.size() * duration;
    }


    public int getDurationOfGame() {
        return durationOfGame;
    }

    public List<Player> getCompleteListOfPlayers() {
        return completeListOfPlayers;
    } //se över, ev bara skick lista av namn

    //method to create a complete list with all the players multiplide with the duration time.
    //connected from setDuration maybe not the best solution?
    public void createCompletedPlayersList (List<Player> listOfPlayers, int durationOfGame){ //privet
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
        completeListOfPlayers = completePlayerList;
    }

    //shuffle the completePlayerList
    public List<Player>shufflePlayerList (List<Player>listOfPlayers){ //ev privet, bör va void
        Collections.shuffle(listOfPlayers);
        return listOfPlayers;
    }


    //method to get the name of the player in the list. Need to get so that the index is controlled somewhere else.
    public String getNameOfPlayer (List<Player>listOfPlayer, int index){ //om kallas från controller ta bara in index
        String name= listOfPlayer.get(index).getName();
        System.out.println(name);
        return name;
    }

    public void setPointOfPlayer (List<Player>listOfPlayer, int index){ //samma som ovn, bara index in
        int point = listOfPlayer.get(index).getPoint();
        point++;
        listOfPlayer.get(index).setPoint(point);
        System.out.println("Points: " + point);
    }




    public List<Player> getPlayers() {
        return players;
    } //tveksamt, får denna användas? kanske för test



    public void chooseCategory(String category) { //ska ev inte va string, beror på vad katergori är
        if (isInList(category)) {//contains istället
            unSelectCategory(category);
        } else {
            selectCategory(category);
            System.out.println(getCategoryNames());
        }

    }

    //Adds chosen category to categories list
    public void selectCategory(String category) { //samma som ovan, ev inte en string

        categories.add(new Category(category));
    }

    //Method for removing a category, removes the choosen category
    public void unSelectCategory(String category) { // se ovan
        for (int i = 0; i < categories.size(); i++) {
            if (category.equals(categories.get(i).getCategoryName())) {
                categories.remove(i);
                System.out.println(getCategoryNames());
            }
        }
    }

    //Checks if chosen category already is in the categories list
    private boolean isInList(String category) { //ersätt med contains
        boolean b = false;
        for (Category c : categories) {
            if (category.equals(c.getCategoryName())) {
                b = true;
            }
        }
        return b;
    }



    public List<Category> getCategories() { //se var den används, returnera istället namn eller int
        return categories;
    }


    //method that puts every player in the players list in order of highest point to smallest.
    public String putListInPointOrder(List<Player>players) { //ny indata, du får inget men du har allt här i modellen

        for (int i = 0; i < players.size(); i++) {
            Player s = players.get(i);
            int nextIndex=i+1;
            if(i<players.size()-1) {
                for (int j = i; j <players.size() ; j++) {

                    while (s.getPoint() < players.get(j).getPoint()) {
                        Collections.swap(players, i, j);
                    }

                }
            }

        }
        List<String>lista= playerListString();
        String scoreText= getScoreBoardText(lista);
        return scoreText;
    }

    //creates a list of strings with the players in a order after points.
    public List<String> playerListString(){ //private
        for (Player c : players) {
            playerList.add(playerToString(c));
        }
        return playerList;
    }


    //method that makes a list that write the players name and its point in a list of strings.
    public String playerToString(Player player){ //private
        String playerToString =player.getName() + " " + player.getPoint() + " Points";

        return playerToString;
    }


    public String getScoreBoardText(List<String>playerInOrder){ //private
        String scoreText= "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <playerInOrder.size(); i++) {

           sb.append(playerInOrder.get(i) + "\n");
        }
        scoreText= sb.toString();
        return scoreText;
    }

    //Method that keep track if the game is done and if the view should change to the finishPage
    public boolean nextRound(int roundOfChallenge){ //om round of challenges ligger i modellen löser det denna
        if(durationOfGame>roundOfChallenge){
            return true;
        }
        return false;
    }

    public void endTheGame(){
        playerList.clear();
        players.clear();

    }

    //Helpmethods for tests below

    //method for test
    public List<String> getCategoryNames() {
        List<String> categoryNames = new ArrayList<>();
        for (Category c : categories) {
            categoryNames.add(c.getCategoryName());
        }
        return categoryNames;
    }

    //Constructor for tests
    public DrinkIT(List<Player> players, List<Card> cards, List<Challenge> challenges) {
        this.players = players;
        this.cards = cards;
        this.challenges = challenges;
    }

    //method for test
    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        for (Player p : players) {
            names.add(p.getName());
        }

        return names;
    }
}
