package SpiteAndMalice.Player;

import SpiteAndMalice.Card;

import java.util.ArrayList;

public class Hand {

    ArrayList<Player> cards = new ArrayList<>();

    private void fillHand(){
       int nbCardsInHand = cards.size();
       for(int i=0;i>nbCardsInHand;i--){
           //cards.add(Card.newCard);
           System.out.println("coucou");
        }
    }

}
