package SpiteAndMalice;

import static SpiteAndMalice.Game.logp;

public class Card {
    private int value;
    private String name;

    public Card(int value, String name) {
        this.value = value;
        this.name = name;
    }

    //Functions

    /**
     * CARD CREATOR
     */

    public static Card newCard() {
        int rng = getRandom();
        System.out.println(rng);
        Card card = new Card(rng, getRealName(rng));
        logp("new card : " + card.getName());
        return card;
    }

    private static String getRealName(int value) {
        String realName;
        switch (value) {
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

    public static int getRandom() {
        return (int) (Math.random() * (14 - 1)) + 1;
    }


    //Getters Setters

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}