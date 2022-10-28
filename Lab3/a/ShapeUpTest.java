import java.util.Scanner;
import java.util.ArrayList;

/**
 * __Test for ShapeUp___ 
 * @author __Irmak_Akyeli___
 * @version __12/03/2019__
 */ 
public class ShapeUpTest
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // constants
      
      // variables
      ShapeContainer shapeList;
      Rectangle rectangle;
      Square square;
      Circle circle;
      int command;
      int x;
      int y;
      String s;
      boolean initialized=false;
      
      // program code
      shapeList = new ShapeContainer();
      System.out.println("Enter: \n1) create a new list, \n2) add a circle, \n3) add a rectangle \n4) add a square, \n5) to show the list, \n6) calculate the surface, \n7) find shapes containing x or y, \n8) remove selected shapes \n9) Exit");
      command = scan.nextInt();
      do{
         if (command == 1)
         {
            initialized = true;
         }
         
         else if (command == 2)
         { 
            if (initialized)
            {
               System.out.print("Enter the radius you want: ");
               int radius = scan.nextInt();
               circle = new Circle(radius);
               shapeList.add( circle );
               System.out.println(circle.toString());
            }
            else 
               System.out.println("Please initialize by the first option!");
         }
         
         else if (command == 3)
         {
            if (initialized)
            {
               System.out.print("Enter the width you want: ");
               int width = scan.nextInt();
               System.out.print("Enter the height you want: ");
               int height = scan.nextInt();
               rectangle = new Rectangle(width , height);
               shapeList.add( rectangle );
               System.out.println(rectangle.toString());
            }
            else 
               System.out.println("Please initialize by the first option!");
            
         }
         
         else if (command == 4)
         {
            if(initialized)
            {
               System.out.print("Enter the side you want: ");
               int side = scan.nextInt();
               square = new Square(side , side);
               shapeList.add( square );
               System.out.println(square.toString());
            }
            else 
               System.out.println("Please initialize by the first option!");
         }
         
         else if (command == 5)
         {
            if (initialized)
               System.out.println(shapeList.toString());
            else 
               System.out.println("Please initialize by the first option!");
         }
         
         else if (command == 6)
         {
            if(initialized)
               System.out.println(shapeList.getArea());
            else 
               System.out.println("Please initialize by the first option!");
         }
         
         else if (command == 7)
         {
            if(initialized)
            {
               System.out.println("Enter the x you want to find");
               x = scan.nextInt();
               System.out.println("Enter the y you want to find");
               y = scan.nextInt();
               System.out.println(shapeList.shapesContaining(x , y));
            }
            else 
               System.out.println("Please initialize by the first option!");
         }
         
         else if (command == 8)
         {
            if(initialized)
               shapeList.remove();
            else 
               System.out.println("Please initialize by the first option!");
         }
         
         System.out.println("Enter: \n1) create a new list, \n2) add a circle, \n3) add a rectangle \n4) add a square, \n5) to show the list, \n6) calculate the surface, \n7) find shapes containing x or y, \n8) remove selected shapes \n9) Exit");
         command = scan.nextInt();
         
      }while(command != 9);
      System.out.println( "Goodbye!" );
   }
}