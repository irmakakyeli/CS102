/**
 * a java class forming a circle extending shapes and implements Locatable and Selectable
 * @author: Irmak_Akyeli
 * @version: 12/03/2019
 */
public class Circle extends Shape implements Locatable , Selectable  
{
   // properties
   int radius;
   boolean isSelected;
   
   // constructors
   /* creates a circle with the given radius
    * @param radius
    */
   public Circle(int radius)
   {
      this.radius = radius; 
   }
   
   // methods
   
   /*calculates the area of the circle with the formula pi * r^2
    * @returns double the area
    */ 
   public double getArea()
   {
      return radius * radius * Math.PI;
   }
   
   /* returns string version of the iinformation of the shape if it is selected
    * @returns string
    */ 
   public String toString()
   {
      if (isSelected)
         return  "Selected Circle with radius: " + "" + radius;
      else
         return "Not Selected Circle with radius: " + "" + radius;
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
      if( (x - getX()) * (x - getX()) + (y - getY()) * (y - getY()) <= radius * radius)
      {
         this.setSelected(true);
         return this;
      }
      else
         return null;
   }
}