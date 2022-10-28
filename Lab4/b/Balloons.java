import javax.swing.JFrame;
import java.util.*; 

/**
 * test of the balloon game
 * @author Irmak_Akyeli
 * @version 02/04/2019
 */ 
public class Balloons extends JFrame
{
   public static void main( String[] args)
   {
      // constants

      // variables
      JFrame frame;
      BalloonsGamePanel myPanel;
      
      // program code
      frame = new JFrame();
      myPanel = new BalloonsGamePanel();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Lab04b - Ballons");
      frame.add(myPanel);
      frame.setVisible(true);
      frame.pack();
      
   }
}