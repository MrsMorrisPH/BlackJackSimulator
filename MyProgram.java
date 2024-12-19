import java.util.Scanner;
public class MyProgram
{
    public static void main(String[] args)
    {
        boolean playAgain = true;
        
        while(playAgain){
        // game setup
        
        Scanner input = new Scanner(System.in);
        
        // list all suits and all ranks
        String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
        String[] ranks = {"Ace", "2", "3", "4",  "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        
        // create the deck
        CardPile deck = new CardPile();
        // generate all 52 cards 
        for (int s = 0; s < suits.length; s++){
            for (int r = 0; r < ranks.length; r++){
                Card card = new Card(suits[s], ranks[r]);
                // add the card to the deck
                deck.addCard(card);
            }
        }
        
        // create a player hand by removing cards from the deck
        CardPile playerHand = new CardPile();
        playerHand.addCard(deck.removeCard());
        playerHand.addCard(deck.removeCard());
        
        // create a hand for the dealer
        CardPile dealerHand = new CardPile();
        dealerHand.addCard(deck.removeCard());
        dealerHand.addCard(deck.removeCard());
        
        
        // game play
        
        System.out.println("The Dealer deals out all the cards.\nYou look at your hand.\n");
        // show the player their hand
        System.out.println("You have: ");
        playerHand.showHand();
        //System.out.println(playerHand.getTotal());
        // show dealer hand
        dealerHand.showFirstCard();
        
        // player portion
        while(!playerHand.isBusted()){
            // ask for input
            System.out.println("What would you like to do?\nHit or Stay?");
            String response = input.nextLine();
            System.out.println();
            // hit
            if("Hithit".indexOf(response) != -1){
                playerHand.addCard(deck.removeCard());
                if (playerHand.isBusted()){
                    playerHand.showHand();
                    System.out.println("\nBUST!!!\nYou Lose =[");
                    break;
                }
                System.out.println("You have: ");
                playerHand.showHand();
                //System.out.println(playerHand.getTotal());
            }
            else if("Staystay".indexOf(response) != -1){
                break;
            }
            else{
                System.out.println("please enter Hit or Stay\n");
            }
        }
            
            // continue to dealer portion if player is not busted
            if(!playerHand.isBusted()){
                // while the dealer's hand is less than 17
                while(dealerHand.getTotal() < 17){
                    // show hand
                    System.out.println("Dealer has: ");
                    dealerHand.showHand();
                    // add card to dealer's hand
                    dealerHand.addCard(deck.removeCard());
                    if (dealerHand.isBusted()){
                        System.out.println("Dealer has:");
                        dealerHand.showHand();
                        System.out.println("The Dealer Busted!\nYou win!!!");
                        break;
                    }
                }
                // end game if neither busted
                if(!dealerHand.isBusted() && dealerHand.getTotal() > playerHand.getTotal()){
                    System.out.println("The Dealer has:");
                    dealerHand.showHand();
                    System.out.println("\nThe Dealer wins!!!\n");
                }
                else if(dealerHand.getTotal() == playerHand.getTotal()){
                    System.out.println("The Dealer has:");
                    dealerHand.showHand();
                    System.out.println("\nYou tie.\n");
                }
                else if (!dealerHand.isBusted() && dealerHand.getTotal() < playerHand.getTotal()){
                    System.out.println("The Dealer has:");
                    dealerHand.showHand();
                    System.out.println("\nYOU WIN!!!!!!\n");
                }
            }
            
            System.out.println("\nWould you like to play again? Y/N");
            if("Nono".indexOf(input.nextLine()) > -1){
                playAgain = false;
            }
            System.out.println();
            
    }
        
    }
}