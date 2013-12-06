public class Card{

   private int value = 0;
   private String suit = "";
   
   /**
      this is the empty constructor
   **/
   public Card(){

   }
   
   /**
      This constructor takes the cards value and suit as a parameter
   **/
   public Card(int newValue, String newSuit){
   
      value = newValue;
      suit = newSuit;
   
   }
   
   /**
      This method returns the face value of the card
   **/
   public int getValue(){
   
      return value;
   
   }
   
   /**
      This method returns the suit of the card
   **/
   public String getSuit(){
   
      return suit;
   
   }
   
   /**
      This method takes a face value as a parameter and assigns it to the card
   **/
   public void setValue(int newValue){
   
      value = newValue;
   
   }
   
   /**
      This method takes a suit as a parameter and assigns it to the card
   **/
   public void setSuit(String newSuit){
   
      suit = newSuit;
   
   }
   
   /**
      This method compares this card to another.  It returns 1 if greater, 0 if lower, 2 if equal
   **/
   public int isHigherCard(Card otherCard){
   
      if(value > otherCard.getValue()){
      
         return 1;
      
      }
      
      else if(value < otherCard.getValue()){
      
         return 0;
        
      }
      
      else{
      
         return 2;
        
      }
   
   }
   
   /**
      Returns the card face value and suit as a String
   **/
   public String toString(){
   
      if(value < 11){
      
         String tempValue = String.valueOf(value);
         String temp = tempValue + suit;
         return temp;
      
      }
      else if(value == 11){
      
         String temp = "jack" + suit;
         return temp;
      
      }
      else if(value == 12){
      
         String temp = "queen" + suit;
         return temp;
      
      }
      else if(value == 13){
      
         String temp = "king" + suit;
         return temp;
      
      }
      else{
      
         String temp = "ace" + suit;
         return temp;
      
      }
   
   }

}