package SpiteAndMalice.Player;

import SpiteAndMalice.Card;

import java.util.ArrayList;

import static SpiteAndMalice.Card.newCard;
import static SpiteAndMalice.Game.logp;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private Storage storage;
    private ObjectiveDeck obj;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();

    }

    public Player() {
    }

    public void createHand() {
        for (int i = 0; i <= 5; i++) {
            try {
                this.hand.add(newCard());
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public void adminShowHand() {
        for (Card card : hand) {
            logp(card.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public ObjectiveDeck getObj() {
        return obj;
    }

    public void setObj(ObjectiveDeck obj) {
        this.obj = obj;
    }
}
