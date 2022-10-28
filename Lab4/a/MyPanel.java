import java.util.Collection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * A class that represents panel of buttons
 * @author Irmak_Akyeli
 * @date 02/04/2019
 */
public class MyPanel extends JPanel
{
   // Declarations
   JLabel countLabel;
   final int BUTTON_COUNT = 25;
   final int FIELD_WIDTH = 300;
   
   int count = 0;
   int foundUntilNow = 0;
   boolean foundedAll = false;
   
   ArrayList<JButton> buttons = new ArrayList<JButton>();
   ArrayList<Integer> luckyNumbers = new ArrayList<Integer>();
   ArrayList<JButton> luckyButtons = new ArrayList<JButton>();
   ArrayList<JButton> selectedButtons = new ArrayList<JButton>();
   
   JPanel littlePanel;
   JPanel bigPanel;
   ActionListener listener;
   ActionListener inputListener;
   
   /**
    * Constructor
    * This constructor initializes variables and constructs a JPanel
    */
   public MyPanel()
   {
      bigPanel = new JPanel();
      littlePanel = new JPanel();
      countLabel = new JLabel();
      listener = new ClickListener();
      
      bigPanel.setLayout(new BorderLayout());
      littlePanel.setLayout(new GridLayout(5,5));
      
      bigPanel.add(countLabel,BorderLayout.NORTH);
      bigPanel.add(littlePanel,BorderLayout.CENTER);
      createComponents();
      generateLucky();
   }
   
   /**
    * This method restarts the game
    * It resets variables, buttons and arrayLists
    */
   public void restartGame()
   {
      for ( JButton b: buttons)
      {
         b.setBackground(Color.white);
         b.setEnabled(true);
      }
      foundUntilNow = 0;
      count = 0;     
      luckyNumbers.clear();
      luckyButtons.clear();
      selectedButtons.clear();
      generateLucky();
      countLabel.setText("You can start!");
   }
   
   /**
    * This method creates the components of panel
    */
   public void createComponents()
   {
       for (int i = 0; i < BUTTON_COUNT; i++)
      {
         JButton button = new JButton(String.valueOf(i+1));
         button.setBackground(Color.white);
         button.addActionListener(listener);
         buttons.add(button);
         littlePanel.add(button);
         countLabel.setText("0");
      }
   }
   
   /**
    * This methods generate random lucky numbers and add them to lists
    */
   public void generateLucky()
   {
      for ( int i = 0; i < 1 ; i++)
      {
          JButton luckyButton = new JButton();
          luckyButton = buttons.get((int)((Math.random() * BUTTON_COUNT) )); 
          luckyButtons.add(luckyButton);
      }   
   }
   
   /**
    * Click listener class to pursue mouse clicks
    * @author Irmak_Akyeli
    * @version 02/04/2018
    */
   public class ClickListener implements ActionListener
   {
      public void actionPerformed( ActionEvent event)
      {
         count++;
         JButton selectedButton = (JButton)event.getSource();
         if (luckyButtons.contains(selectedButton) && !selectedButtons.contains(selectedButton))
         {
            selectedButtons.add(selectedButton);
            foundUntilNow++;
            countLabel.setText("You found in " + count + " times");
            JButton btn = (JButton)event.getSource();
            btn.setBackground(Color.green);
         }
         else
         {
             countLabel.setText("Attempt " + count);
             JButton btn2 = (JButton)event.getSource();
             if(!selectedButtons.contains(btn2))
             {
             btn2.setBackground(Color.red);
             btn2.setEnabled(false);
             }    
         }
        
        if ( foundUntilNow == 1)
        {
           int play = JOptionPane.showConfirmDialog(MyPanel.this, "Play again? ", "Game over, you did it in " + count + " times ", 0);
           if (play == 0) 
           {
              MyPanel.this.restartGame();
           }
           
           if (play == 1)
           {
              System.exit(0);
           }
        }
      }
   }
}