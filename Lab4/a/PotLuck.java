import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 * A basic game that user try to find prize
 * @author Irmak_Akyeli
 * @date 02/04/2018
 */
public class PotLuck 
{
   public static void main(String[]args)
   {
      //constants 
      final int FRAME_WIDTH = 800;
      final int FRAME_HEIGHT = 400; 
      
      // Variables
      JFrame frame;
      MyPanel panel;
      
      // Program Code
      frame = new JFrame();
      panel = new MyPanel();
      frame.add(panel.bigPanel);
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT); 
      frame.setTitle("PotLuck");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
    
}
                      

      