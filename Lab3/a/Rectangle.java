/**
 * a java class forming a rectangle extending shapes and implements Locatable and Selectable
 * @author: Irmak_Akyeli
 * @version: 12/03/2019
 */
public class Rectangle extends Shape implements Locatable , Selectable 
{
   // properties
   int width;
   int height;
   boolean isSelected;
   // constructors 
   
   /* creates a rectangle with the given width and height
    * @param width
    * @param height
    */
   public Rectangle(int width, int height)
   {
      this.width = width;
      this.height = height;
   }
   // methods
   
   /*calculates the area of the circle with the formula width * height
    * @returns double the area
    */ 
   public double getArea()
   {
      return width * height;
   }
   
   /* returns string version of the iinformation of the shape if it is selected
    * @returns string
    */
   public String toString()
   {
      if(isSelected)
         return "Selected Rectangle with " + "width: " + "" + width + " height: " + height;
      else
         return "Not Selected Rectangle with " + "width: " + "" + width + " height: " + height;
   }
   
   /* sets selected to the given boolean
    * @param boolean the boolean of being selected
    */ 
   public void setSelected(boolean bln)
   {
      isSelected = bln;
   }
   
   /* returns the boolean of the shapes being selected
    * @returns boolean
    */ 
   public boolean getSelected()
   {
      return isSelected;
   }
   
   /* look if the given point is in the shape we are looking
    * @param x x coordinate of the point
    * @param y y coordinate of the point
    */ 
   public Shape contains(int x , int y)
   {
      if (x - getX() <= width && y - getY() <= height)
      {
         this.setSelected(true);
         return this;
      }
      else
         return null;
   }
}