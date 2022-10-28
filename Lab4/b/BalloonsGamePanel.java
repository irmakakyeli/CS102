import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import shapes.ShapeContainer;
import shapes.Circle;
import shapes.Drawable;
import java.awt.*;


/**
 * A class to create a Balloon Game 
 * @author Irmak_Akyeli
 * @version 02/04/2019
 */ 
public class BalloonsGamePanel extends JPanel
{
   //constants
   static final int WIDTH = 1200;
   static final int HEIGHT = 900;
   static final int MAX_ELAPSE_TIME = 250;
   static final int UPDATE_PERIOD = 100;
   static final int MIN_BALLOONS = 15;
   static final int BALLONS_AT_START = 25;
   
   //variables
   Timer timer;
   JLabel timeLabel;
   JLabel pointsLabel;
   ShapeContainer balloons;
   MouseListener mouse;
   int points;
   int elapsedTime;
   
   // constructors
   public BalloonsGamePanel()
   {
      pointsLabel = new JLabel();
      timeLabel = new JLabel();
      setLayout(new FlowLayout());
      add(pointsLabel);
      add(timeLabel);
      setBackground(Color.cyan);
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      mouse = new BalloonsGamePanel.Mouse();
      timer = new Timer(UPDATE_PERIOD, new BalloonsGamePanel.GrowListener());
      startGame();
   }

   /**
    * A method to restart game
    * It resets all variables
    */
   public void startGame()
   {
      elapsedTime = 0; 
      points = 0;
      pointsLabel.setText("Points: " + points);    
      balloons = new ShapeContainer();
      addRandomBalloons(BALLONS_AT_START, WIDTH, HEIGHT );
      addMouseListener(mouse);
      timer.start();
   }
   
   /**
    * A method to add random balloons to field
    * @param number: number of balloons
    * @param width: width of balloon
    * @param height: height of balloon
    */
   public void addRandomBalloons(int number, int width, int height)
   {
      for (int i=0; i < number; i++)
      {
         int x = (int)(Math.random() * width);
         int y = (int)(Math.random() * height);
         Balloon newBalloon = new Balloon(x, y);
         balloons.add(newBalloon);
      }
   }
   
   /**
    * A method to draw all balloons
    * @param g: special object that is necessary to draw
    */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Iterator i1 = balloons.iterator();
      while (i1.hasNext())
      {
         ((Drawable)i1.next()).draw(g);
      }
   }
   
   
   /**
    * A class that represents a pin
    * @author Irmak_Akyeli
    * @date 02/04/2019
    */
   public class Mouse extends MouseAdapter
   {
      public Mouse() 
      {
      }
      
      public void mousePressed(MouseEvent event)
      {
         int burstCount;   
         burstCount = balloons.selectAllAt(event.getX(), event.getY());
         if (burstCount >= 2)
         {
            points = points + burstCount;
            pointsLabel.setText("Points: " + points);
         }
      }
   } 
   
   /**
    * A class to listen growth of balloons
    * @author Irmak_Akyeli
    * @date 02/04/2019
    */
   public class GrowListener implements ActionListener
   {
      public GrowListener() 
      {
      }
      
      public void actionPerformed(ActionEvent event)
      {
         Iterator i2 = balloons.iterator();
         while (i2.hasNext())
         {
            ((Balloon)i2.next()).grow();
         }
         balloons.remove();
         if (balloons.size() < MIN_BALLOONS) 
         {
            BalloonsGamePanel.this.addRandomBalloons(MIN_BALLOONS - balloons.size() , WIDTH, HEIGHT);
         }
         repaint();
         elapsedTime = elapsedTime + 1;
         timeLabel.setText("Time: " +(MAX_ELAPSE_TIME - elapsedTime));
         if (elapsedTime >= MAX_ELAPSE_TIME)
         {
            timer.stop();
            removeMouseListener(mouse);
            int play = JOptionPane.showConfirmDialog(BalloonsGamePanel.this, "Play again? ", "Game over", 0);
            if (play == 0) 
            {
               BalloonsGamePanel.this.startGame();
            }
            else
            {
               System.exit(0);
            }
         }
      }
   }
}