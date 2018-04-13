package SpiteAndMalice;

import SpiteAndMalice.Board.Storage;
import SpiteAndMalice.Player.Player;

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


    public Game() {

        Card.newCard();

        starter();

        while (!someoneWon) {
            fullTurn();
        }

        endGame();

    }

    public static void logp(String string) {
        System.out.println(string);
    }

    /**
     * ONE PLAYER TURN
     */


    private void onePlayerRound(Player player) {
        fillHand(player);
        //playHand(player);
        endTurn();
    }

    /**
     * OTHER FUNCTIONS
     */

    public void starter() {

        logp("Welcome to Spite & Malice");
        inputInt("How many players ? (2 to 5)", 2, 5);
        logp(nbPlayers + " players.");

        createPlayers();

        displayPlayersNames(players);

        setUpCards();

        getStartPlayer();

    }

    private void setUpCards() {
        players.forEach(Player::createHand);
    }

    private void inputInt(String message, int min, int max) {
        boolean inputIsOk = false;
        int nbErrors = 0;

        while (!inputIsOk) {
            logp(message);
            try {
                Scanner sc = new Scanner(System.in);
                inputInt = sc.nextInt();
            } catch (Exception e) {
            }
            if (min <= inputInt && inputInt <= max) {
                nbPlayers = inputInt;
                inputIsOk = true;
            } else {
                nbErrors = getErrorMessages(nbErrors);
            }
        }

    }


    private void fullTurn() {
        for (Player player : players) {
            player = currentPlayer;
            onePlayerRound(player);
        }
    }

    private int getErrorMessages(int nbErrors) {
        String msg1 = "This is not a correct answer.";
        String msg2 = "This is not a correct answer, please stop trying to fuck my code, thank you.";
        String msg3 = "Bro.";
        String msg4 = "Bro !";
        String msg5 = "Welcome to Spite & Malice Retard edition ! Press any key to press any key.";
        switch (nbErrors) {
            case 0:
            case 1:
            case 2:
                logp(msg1);
                nbErrors++;
                break;
            case 3:
                logp(msg2);
                nbErrors++;
                break;
            case 4:
                logp(msg3);
                nbErrors++;
                break;
            case 5:
                logp(msg4);
                nbErrors++;
                break;
            default:
                logp(msg5);
        }
        return nbErrors;
    }

    private void createPlayers() {
        for (int i = 1; i <= nbPlayers; i++) {
            String newPlayersName;
            ArrayList<Card> emptyHand = new ArrayList<>();
            logp("What is player " + i + "'s name ?");
            Scanner sc = new Scanner(System.in);
            newPlayersName = sc.nextLine();
            Player player = new Player();
            player.setName(newPlayersName);
            player.setHand(emptyHand);
            players.add(player);
        }
    }

    private void displayPlayersNames(ArrayList<Player> player) {
        player.forEach(p -> logp("Player " + (player.indexOf(p) + 1) + " : " + p.getName()));
        /*for(int i=0;i<nbPlayers;i++){
            logp("Player " + (i+1) + " : " + player.get(i).getName());
        }*/
    }

    private void getStartPlayer() {
        currentPlayerIndex = (int) (Math.random() * nbPlayers);
        currentPlayer = players.get(currentPlayerIndex);
        logp("currentPlayer : " + currentPlayer.getName());
    }

    private void fillHand(Player player) {
        //savoir combien ya de cartes dans sa main


        //ajouter jusqu a en avoir 5
    }

    private void endTurn() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= nbPlayers) {
            currentPlayerIndex = 0;
        }
        currentPlayer = players.get(currentPlayerIndex);
    }

    /**
     * MISCELLANEOUS
     */

    public void endGame() {
        System.out.println("GG, the winner is " + winner.getName() + " !!!");
    }

}
