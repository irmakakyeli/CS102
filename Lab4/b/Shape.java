package shapes;
/**
 * an abstarct java class which creates shapes and it implements locatable and selectable
 * @author: Irmak_Akyeli
 */
public abstract class Shape implements Locatable , Selectable
{
   // properties
   int x;
   int y;
   // constructors
    
   // methods
   
   //an abstract method that each shape has
   public abstract double getArea();
   
   /*a method to find y
    * @returns y
    */ 
   public int getY()
   {
      return y;
   }
   
   /*a method to find x
    * @returns x
    */ 
   public int getX()
   {
      return x;
   }
   
   /*a method to find set the locations of x and y
    * @param x
    * @param y
    */ 
   public void setLocation(int x , int y)
   {
      this.x = x;
      this.y = y;
   }
}