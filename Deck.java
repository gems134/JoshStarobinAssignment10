import java.util.Random;

/**
   This class simulates a deck of cards   
**/
public class Deck extends QueueReferenceBased{

   /**
      This is an empty constructor   
   **/
   public Deck(){
   
   }
   
   /**
      This is a copy constructor
   **/
   public Deck(Deck oldDeck){
   
      while(oldDeck.isEmpty() == false){
      
         this.enqueue(oldDeck.dequeue());
      
      }
   
   }  
   
   /**
      This method shuffles the deck.  
      It randomly splits the deck into three smaller decks and then re-combines them
   **/
   public void shuffleDeck(){
      
      //the piles the deck is split into
      Deck pileOne = new Deck();
      Deck pileTwo = new Deck();
      Deck pileThree = new Deck();
      
      Random shuffle = new Random();
      
      while(this.isEmpty() == false){
      
         int pile = shuffle.nextInt(3);
         
         if(pile == 0){
            
            pileOne.enqueue(this.dequeue());
            
         }
         
         else if(pile == 1){
         
            pileTwo.enqueue(this.dequeue());
         
         }
         
         else{
         
            pileThree.enqueue(this.dequeue());
         
         }
      
      }
      //recombine piles
      this.addPile(pileOne);
      this.addPile(pileTwo);
      this.addPile(pileThree);
      
   }
   
   /**
      This method creates a new deck of cards, unshuffled
   **/
   public void makeNewDeck(){
      
      //remove all cards from the current deck
      this.dequeueAll();
   
      //loops through the suits
      for(int i=0; i < 3; i++){
      
         //loops through the faces
         for(int j = 0; j < 13; j++){
         
            if(i == 0 ){
            
               Card newCard = new Card(j+1,"h");
               this.enqueue(newCard);
            
            }
            else if(i == 1){
            
               Card newCard = new Card(j+1,"c");
               this.enqueue(newCard);
            
            }
            else if(i == 2){
            
               Card newCard = new Card(j+1,"d");
               this.enqueue(newCard);
            
            }
            else{
            
               Card newCard = new Card(j+1,"s");
               this.enqueue(newCard);
            
            }
         
         }
      
      }
   
   }
   
   /**
      This method adds another deck to this one
   **/
   public void addPile(Deck pile){
   
      while(pile.isEmpty() == false){
      
         this.enqueue(pile.dequeue());
      
      }
   
   }


}