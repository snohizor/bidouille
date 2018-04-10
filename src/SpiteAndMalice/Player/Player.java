package SpiteAndMalice.Player;

public class Player {
    private String name;
    private Hand hand;
    private Storage storage;
    private ObjectiveDeck obj;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
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
