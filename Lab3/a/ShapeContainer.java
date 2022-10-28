import java.util.ArrayList; 
/**
 * a java class forming an array list of shapes 
 * @author: Irmak_Akyeli
 * @version: 12/03/2019
 */
public class ShapeContainer
{
   // properties
   ArrayList<Shape> shapes;
   
   // constructors
   
   /*creates an array list of shapes
    */ 
   public ShapeContainer()
   {
      shapes = new ArrayList<Shape>();
   }
   
   // methods
   
   /*adds the given shape to the list
    * @param shape
    */ 
   public void add( Shape shape)
   {
      shapes.add(shape);
   } 
   
   /*find the area of the shapes
    * @returns double area
    */ 
   public double getArea()
   {
      int total = 0;
      for(int i=0; i < shapes.size(); i++)
      {
         total += shapes.get(i).getArea();
      }
      return total;
   }
   
   /*creates a string version of shapes in the list with their parametres if they are selected
    * @returns String
    */ 
   public String toString()
   {
      String s="";
      for (int i=0; i < shapes.size(); i++)
      {
          s += shapes.get(i).toString();
      }
      return s;
   }
   
   //for being able to use array list properties
   public int size()
   {
      return shapes.size();
   }
   
   //for being able to use array list properties
   public Shape get(int i)
   {
      return shapes.get(i);
   }
   
   /*finds the first shape in the list with the given coordinates
    * @param x
    * @param y
    * @returns shape
    */
   public Shape shapesContaining(int x , int y)
   {
      for(int i=0; i < shapes.size(); i++)
      {
         if (shapes.get(i).contains( x , y) != null)
            return shapes.get(i);
      }
      return null;
   }
   
   /*removes all selected shapes in the list
    */ 
   public void remove()
   {
      for(int i=0; i < shapes.size(); i++)
      {
         if (shapes.get(i).getSelected())
            shapes.get(i).setSelected(false);
      }
   }
}