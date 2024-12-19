public class Card {
    
    // instance variables
    private String suit;
    private String rank;
    private int value;
    
    //constructor
    public Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
        String faceCards = "KingQueenJack10";
        if (rank.equals("Ace")){
            value = 11;
        }
        else if (faceCards.indexOf(rank) != -1){
            value = 10;
        }
        else{
            value = Integer.parseInt(rank);
        }
    }
    
    // getters
    public String getSuit(){
        return suit;
    }
    
    public String getrank(){
        return rank;
    }
    
    public int getValue(){
        return value;
    }
    
    // setter (maybe used for changing the Ace value)
    public void setValue(int value){
        this.value = value;
    }
    
    //toString
    public String toString(){
        return rank + " of " + suit + ", value of " + value;
    }
}