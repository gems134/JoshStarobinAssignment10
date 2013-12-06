import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
   This class runs the rules of the game
**/
public class WarGame{
   
   //Player objects for the Player and the Computer
   public Player human = new Player();
   public Player ai = new Player();
   //piles of cards the players have played
   public Deck humanPile = new Deck();
   public Deck aiPile = new Deck();
   //Cards used to store the current face-up card
   public Card currentHumanCard;
   public Card currentAiCard;
   
   /**
      This constructor deals the cards to the two players
   **/
   public WarGame(){
      
      dealCards();
   
   }
   
   /**
      This method creates a new deck, shuffles it, and deals it to the players
   **/
   public void dealCards(){
   
      Deck fullDeck = new Deck();
      
      //Creates a fresh deck
      fullDeck.makeNewDeck();
      
      //Shuffles the deck 7 times
      for(int i = 0; i < 7; i++){
      
         fullDeck.shuffleDeck();
      
      }
      
      //Splits the deck between the two players
      int j = 0;
      while(fullDeck.isEmpty() == false){
      
         if(j % 2 == 0){
            
            Card tempCard = ((Card)fullDeck.dequeue());
            human.addCard(tempCard);
            j++;
         
         }
         else{
         
            Card tempCard = ((Card)fullDeck.dequeue());
            ai.addCard(tempCard);
            j++;
         
         }
      
      }
   
   }
   
   /**
      This method flips over the top cards of each deck  
   **/
   public void flipCards(){
      
      //If one of the decks is empty and cant flip a card, makes one player a winner
      if(human.getDeck().isEmpty() || ai.getDeck().isEmpty()){
      
         if(human.getDeck().isEmpty()){
         
            ai.setIsWinner(true);
            return;
         
         }
         
         else if(ai.getDeck().isEmpty()){
         
            human.setIsWinner(true);
            return;
         
         }
      
      }
      
      //copies top card from each deck for reference
      currentHumanCard = human.getTopCard();
      currentAiCard = ai.getTopCard();
      
      //places top card from each deck into the player's pile and removes them from the deck
      humanPile.enqueue(human.flipTopCard());
      aiPile.enqueue(ai.flipTopCard());
   }
   
   /**
      This method compares the piles and puts them into the winner's deck
   **/
   public void compareTakeCards(Player human, Player ai, Deck humanPile, Deck aiPile){
   
      //if human's card is higher, places cards in his deck
      if(currentHumanCard.isHigherCard(currentAiCard) == 1){
      
         human.addPile(humanPile);
         human.addPile(aiPile);
      
      }
      //if ai's card is higher, places cards in his deck
      else if(currentHumanCard.isHigherCard(currentAiCard) == 0){
      
         ai.addPile(humanPile);
         ai.addPile(aiPile);
      
      }
      //if there's a tie, places a card in each pile and recursively starts another turn
      else{
      
         humanPile.enqueue(human.flipTopCard());
         aiPile.enqueue(ai.flipTopCard());
         flipCards();
      
      }      
   
   }
   
   /**
      This method checks to see if one of the players has won the game
   **/
   public static boolean checkWinner(Player human, Player ai){
   
      if(human.getIsWinner() || ai.getIsWinner()){
      
         return true;
      
      }
      
      else{
      
         return false;
      
      }
   
   }
   
}