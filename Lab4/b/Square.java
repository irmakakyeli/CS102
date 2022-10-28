package shapes;
/**
 * a java class forming a square extending rectangle and implements Locatable and Selectable
 * @author: Irmak_Akyeli
 * @version: 12/03/2019
 */
public class Square extends Rectangle implements Locatable , Selectable
{
   // properties
   int side;
   boolean isSelected;
   
   // constructors
   /* creates a square with the given side length
    * @param side
    * @param side2
    */
   public Square (int side, int side2)
   {
      super( side, side2);
      this.side = side;
   }
    
   // methods
   
   /* returns string version of the iinformation of the shape if it is selected
    * @returns string
    */ 
   public String toString()
   {
      if (isSelected)
         return "Selected Square with sides: " + "" + side;
      else
         return "Not Selected Square with sides: " + "" + side;
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
   
}