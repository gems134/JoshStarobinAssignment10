/**
   This class simulates a player   
**/
public class Player{
   
   //The player's deck, and whether or not he's a winner
   private Deck deck = new Deck();
   private boolean isWinner = false;
   
   /**
      This is an empty copy constructor
   **/
   public Player(){
   
   }
   
   /**
      This constructor takes a Deck as a parameter and assigns it to this player
   **/
   public Player(Deck newDeck){
      
      name = newName;
      deck = newDeck;
   
   }
   
   /**
      This method returns whether or not the player has won
   **/
   public boolean hasWon(){
   
      return isWinner;
   
   }
   
   /**
      This method returns the player's deck
   **/
   public Deck getDeck(){
   
      return deck;
   
   }
   
   /**
      This method sets whether or not the player has won
   **/
   public void setIsWinner(boolean newIsWinner){
   
      isWinner = newIsWinner;
   
   }
   
   /**
      This method sets a new deck as the player's deck
   **/
   public void Deck(Deck newDeck){
   
      deck = newDeck;
   
   }
   
   /**
      This method flips over the top card of the player's deck and removes it
   **/
   public Card flipTopCard(){
   
      Object toPlay = deck.dequeue();
      return (Card)toPlay;
      
   }
   
   /**
      This method gets the top card of the deck without removing it
   **/
   public Card getTopCard(){
      
      Object toPlay = deck.peek();
      return (Card)toPlay;
   
   }
   
   /**
      This method adds a pile of cards (deck) to the player's deck
   **/
   public void addPile(Deck pile){
   
      deck.addPile(pile);
   
   }
   
   /**
      This method adds a single card to the player's deck.
   **/
   public void addCard(Object newCard){
   
      deck.enqueue(newCard);
   
   }
   
}