import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
   This class creates and runs the game window.
**/
public class GameWindow implements  ActionListener{
   
   //Instantiates the panels, labels, and buttons for the game.
   JPanel cardPanel, buttonPanel, labelPanel;
   JLabel humanDeckLabel, humanCardLabel;
   JLabel humanDeck, aiDeck, humanCard, aiCard;
   JButton flipButton, newGameButton;
   WarGame game = new WarGame();
   
   ImageIcon back = new ImageIcon("back.jpg");
   
   /**
      This constructor creates the game window and deals cards to the players.
   **/
   public GameWindow(){

      this.createAndShowGUI();
      game.dealCards();
   
   }
   
   /**
      This method creates the frames and populates them.
   **/
   public JPanel createContentPane(){
   
      //Creates a JPanel to place everything on.
      JPanel totalGUI = new JPanel();
      totalGUI.setLayout(null);
        
    //Creates a panel to contain cards.
      cardPanel = new JPanel();
      cardPanel.setLayout(null);
      cardPanel.setLocation(0, 0);
      cardPanel.setSize(360, 648);
      totalGUI.add(cardPanel);
      
      //Creates a panel to hold the card for the human deck
      humanDeck = new JLabel();
      humanDeck.setLocation(30, 400);
      humanDeck.setSize(154, 216);
      humanDeck.setHorizontalAlignment(0);
      humanDeck.setIcon(back);
      cardPanel.add(humanDeck);

      //Creates a panel to hold the card for the computer's deck
      aiDeck = new JLabel();
      aiDeck.setLocation(30, 30);
      aiDeck.setSize(154, 216);
      aiDeck.setHorizontalAlignment(0);
      aiDeck.setIcon(back);
      cardPanel.add(aiDeck);
      
      //Creates a panel to hold the face-up card for the player
      humanCard = new JLabel(/**some card**/);
      humanCard.setLocation(200, 400);
      humanCard.setSize(154, 216);
      humanCard.setHorizontalAlignment(0);
      humanCard.setIcon(back);
      cardPanel.add(humanCard);
      
      //Creates a panel to hold the face-up card for the computer
      aiCard = new JLabel(/**some card**/);
      aiCard.setLocation(200, 30);
      aiCard.setSize(154, 216);
      aiCard.setHorizontalAlignment(0);
      aiCard.setIcon(back);
      cardPanel.add(aiCard);
      
    //Creates a panel to contain the deck labels.
      labelPanel = new JPanel();
      labelPanel.setLayout(null);
      labelPanel.setLocation(0, 648);
      labelPanel.setSize(360, 108);
      totalGUI.add(labelPanel);
      
      //Creates a label for the player's deck
      humanDeckLabel = new JLabel("Your Deck");
      humanDeckLabel.setLocation(43, 0);
      humanDeckLabel.setSize(120, 30);
      humanDeckLabel.setHorizontalAlignment(0);
      labelPanel.add(humanDeckLabel);   
      
      //Creates a label for the player's pile
      humanCardLabel = new JLabel("Your Card");
      humanCardLabel.setLocation(215, 0);
      humanCardLabel.setSize(120, 30);
      humanCardLabel.setHorizontalAlignment(0);
      labelPanel.add(humanCardLabel);
      
    //Creates a panel for the game's buttons.
      buttonPanel = new JPanel();
      buttonPanel.setLayout(null);
      buttonPanel.setLocation(360, 0);
      buttonPanel.setSize(200, 756);
      totalGUI.add(buttonPanel);

      //Creates a button for the player to flip the top card 
      flipButton = new JButton("Flip Top Card");
      flipButton.setLocation(30, 124);
      flipButton.setSize(120, 30);
      flipButton.addActionListener(this);
      buttonPanel.add(flipButton);

      //Creates a button for the player to start a new game
      newGameButton = new JButton("Start New Game");
      newGameButton.setLocation(30, 507);
      newGameButton.setSize(120, 30);
      newGameButton.addActionListener(this);
      buttonPanel.add(newGameButton);
      
      totalGUI.setOpaque(true);
      return totalGUI;
   }
   
   /**
      This method catches the buttons being pressed and performs their actions.
   **/
   public void actionPerformed(ActionEvent e) {
   
      //if flipButton is pressed
      if(e.getSource() == flipButton)
      {
          
          //flips the cards
          game.flipCards();
          String humanCardFile = game.currentHumanCard.toString();
          String aiCardFile = game.currentAiCard.toString();
          
          //sets the played card images to the cards that were just played
          ImageIcon humanCardIcon = new ImageIcon(humanCardFile + ".jpg");
          ImageIcon aiCardIcon = new ImageIcon(aiCardFile + ".jpg");
          humanCard.setIcon(humanCardIcon);
          aiCard.setIcon(aiCardIcon);
          
      }
      //if new game button is pressed
      else if(e.getSource() == newGameButton)
      {
          
          game.dealCards();
          
      }
   }
   /**
      This method creates the window and places the panes onto it 
   **/
   private void createAndShowGUI() {

      JFrame.setDefaultLookAndFeelDecorated(true);
      JFrame frame = new JFrame(" --- War --- ");

      //Create and set up the content pane.
      frame.setContentPane(this.createContentPane());

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(540, 756);
      frame.setVisible(true);
   }

}

