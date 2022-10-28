import shapes.Circle;
import shapes.Drawable;
import java.awt.Graphics;

/**
 * a class extending circle
 * @author Irmak_Akyeli
 * @version 02/04/2019
 */
public class Balloon extends Circle implements Drawable
{
   // constants
   static final int MAX_RADIUS = 100;
   static final int DEFAULTT_RADIUS = 25;
   static final int GROWTH_SIZE = 2;
   
   // constructors
   public Balloon (int x , int y)
   {
      super(DEFAULTT_RADIUS);
      setLocation(x , y);   
   }
   
   /**
   * A method that draws circles
   * @param drawer: draws the circle
   */
  public void draw(Graphics drawer)
  {
    int radius = getRadius();
    drawer.drawOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
  }
  
  /**
   * A method to burst baloons
   */
  public void Boom() 
  {
    setRadius(0);
    setSelected(true);
  }  
   
   /**
   * A method to grow baloons
   * It burst them if they grow too much
   */ 
  public void grow()
  {
   if (radius < MAX_RADIUS)
      radius = radius + GROWTH_SIZE;
   else
   {
      Boom();
      radius = 0;
      setSelected(true);
   }
  }
}