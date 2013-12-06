/**
   This class runs the game and the window
**/
public class GameControl{

   private static WarGame game;
   private static GameWindow gameWindow; 
   
   public static void main(String [] args){
   
      game = new WarGame();
      gameWindow = new GameWindow();
   
   }

}