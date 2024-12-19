import java.util.ArrayList;
public class CardPile {
    
    // instance variables
    int total;
    ArrayList<Card> cardList = new ArrayList<Card>(); // default to an empty list
    //
    
    // maybe add bet amount as a static variable
    
    // no constuctor needed since variables are initialized to default values
    
    // methods
    public void addCard(Card card){
        // add a card (parameter) to the cardList
        cardList.add(card);
        // update the total each time you add a card
        calculateTotal();
    }
    
    public int getTotal(){
        return total;
    }
    
    public Card removeCard(){
        // removes a random card from the current pile and returns the card
        return cardList.remove((int)(Math.random()*cardList.size() + 1));
    }
    
    private void calculateTotal(){
        // calculates the total value of the card pile 
        int sum = 0;
        for (int i = 0; i < cardList.size(); i++){
            sum += cardList.get(i).getValue();
        }
        total = sum;
    }
    
    public void showHand(){
        
        for (int i = 0; i < cardList.size(); i++){
            System.out.println(cardList.get(i));
        }
        System.out.println();
    }
    
    public void showFirstCard(){
        System.out.println("The dealer shows: ");
        System.out.println(cardList.get(0));
        System.out.println();
    }
    
    public boolean isBusted(){
        return total > 21;
    }
    
    
}