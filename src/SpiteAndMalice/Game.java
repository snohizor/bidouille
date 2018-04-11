package SpiteAndMalice;

import SpiteAndMalice.Player.Player;
import SpiteAndMalice.Board.Storage;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Storage boardStorage;

    boolean someoneWon = false;

    ArrayList<Player> players = new ArrayList<>();
    int nbPlayers;
    int currentPlayerIndex = 0;
    Player currentPlayer;
    Player winner;

    int inputInt;
    Exception myLastError;


    public Game() {

        starter();

        while(!someoneWon){
            fullTurn();
        }

       endGame();

    }

    /**
     *  ONE PLAYER TURN
     */

    private void onePlayerRound(Player player){
        fillHand(player);
        //playHand(player);
        endTurn();
    }

    /**
     * OTHER FUNCTIONS
     */

    public void starter() {

        log("Welcome to Spite & Malice");
        inputInt("How many players ? (1 to 5)",1,5);
        log(nbPlayers + " players.");

        createPlayers();

        displayPlayersNames(players);

        setUpCards();

        getStartPlayer();

    }

    private void setUpCards(){

    }

    private void inputInt(String message, int min, int max){
        boolean inputIsOk = false;
        int nbErrors = 0;

        while(!inputIsOk) {
            log(message);
            try{
                Scanner sc = new Scanner(System.in);
                inputInt = sc.nextInt();
            }catch(Exception e){myLastError = e;}
                if (min <= inputInt && inputInt <= max) {
                    nbPlayers = inputInt;
                    inputIsOk = true;
                } else {
                    String msg1 = "This is not a correct answer.";
                    String msg2 = "This is not a correct answer, please stop trying to fuck my code, thank you.";
                    String msg3 = "Bro.";
                    String msg4 = "Bro !";
                    String msg5 = "Welcome to Spite & Malice Retard edition ! Press any key to press any key.";
                    switch (nbErrors) {
                        case 0:
                        case 1:
                        case 2:
                            log(msg1);
                            nbErrors++;
                            break;
                        case 3:
                            log(msg2);
                            nbErrors++;
                            break;
                        case 4:
                            log(msg3);
                            nbErrors++;
                            break;
                        case 5:
                            log(msg4);
                            nbErrors++;
                            break;
                        case 6:
                            log(msg5);
                            nbErrors++;
                            break;
                        default:
                            log("error 001");
                    }
                }
        }

    }


    private void fullTurn() {

        for (Player player : players) {
            player = currentPlayer;
            onePlayerRound(player);
        }
    }

    private void createPlayers(){
        for(int i=1;i<=nbPlayers;i++){
            String newPlayersName;
            log("What is player " + i + "'s name ?");
            Scanner sc = new Scanner(System.in);
            newPlayersName = sc.nextLine();
            Player player = new Player();
            player.setName(newPlayersName);
            players.add(player);
        }
    }

    private void displayPlayersNames(ArrayList<Player> player){
        for(int i=0;i<nbPlayers;i++){
            log("Player " + (i+1) + " : " + player.get(i).getName());
        }
    }

    private void getStartPlayer(){
       currentPlayerIndex = (int)(Math.random() * nbPlayers);
       currentPlayer = players.get(currentPlayerIndex);
       log("currentPlayer : " + currentPlayer.getName());
    }

    /**
     * TEMP SHIT
     */
    /*private void playOneTurn(Player player){
        System.out.println(player.getName() + " plays his turn.");
        System.out.println("Press any key to continue.");
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        endTurn();
    }*/

    private void fillHand(Player player){

    }

    private void endTurn(){
        currentPlayerIndex++;
        if(currentPlayerIndex >= nbPlayers){
            currentPlayerIndex = 0;
        }
        currentPlayer = players.get(currentPlayerIndex);
    }

    /**
     *
     * CARD CREATOR
     *
     */

    public Card newCard(){
        int rng = getRandom();
        Card card = new Card(rng, getRealName(rng));
        System.out.println("new card : " + card.getName());
        return card;
    }

    private String getRealName(int value){
        String realName;
        switch (value)
        {
            case 1:
                realName = "Ace";
                break;
            case 11:
                realName = "J";
                break;
            case 12:
                realName = "Q";
                break;
            case 13:
                realName = "K";
                break;
            default:
                realName = String.valueOf(value);
        }
        return realName;
    }

    public int getRandom() {
        return (int)(Math.random() * (14 - 1)) + 1;
    }

    /**
     * MISCELLANEOUS
     */

    public void endGame(){
        System.out.println("GG, the winner is " + winner.getName() + " !!!");
    }

    public void log(String string){System.out.println(string);}

}
