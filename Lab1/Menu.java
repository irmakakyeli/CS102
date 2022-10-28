import java.util.Scanner;

/**
 * __IntBag___ 
 * @author __Irmak_Akyeli___
 * @version __17/02/2019__
 */ 
public class Menu
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // constants
      
      // variables
      IntBag bag;
      int limit;
      int command;
      int value=1;
      int index;
      int testValue=0;
      IntBag locations;
      
      // program code
      bag = new IntBag();
      locations = new IntBag();
      
      do{
         System.out.println("1. Create a new empty collection with a specified maximum capacity (any previous values are lost!)" +
                            "\n2. Read a set of positive values into the collection (use a negative value to indicate all the values have been entered.)" +
                            "\n3. Print the collection of values." +
                            "\n4. Add a value to the collection of values at a specified location" +
                            "\n5. Remove the value at a specified location from the collection of values" +
                            "\n6. Read a single test value." +
                            "\n7. Compute the set of locations of the test value within the collection." +
                            "\n8. Print the set of locations." +
                            "\n9. Quit the program.");
         command = scan.nextInt();
         if (command == 1)
         {
            System.out.print("enter the limit you want to set: ");
            limit = scan.nextInt();
            bag = new IntBag(limit);
         }
         else if (command == 2)
         {
            value = 1;
            System.out.println("enter the values: ");
            while (value > 0)
            {
               value = scan.nextInt();
               if(value > 0)
                  bag.add(value);
               if(bag.add(value) != true)
               {
                  System.out.println("out of range!");
                  value = -1;
               }
            }
            value = 1;
         }
         else if (command == 3)
         {
            System.out.println(bag);            
         }
         else if (command == 4)
         {
            System.out.print("enter the value: ");
            value = scan.nextInt();
            System.out.print("enter the location: ");
            index = scan.nextInt();
            bag.add(value, index);
         }
         else if (command == 5)
         {
            System.out.print("enter the location: ");
            index = scan.nextInt();
            bag.remove(index);
         }
         else if (command == 6)
         {
            System.out.print("enter the test value: ");
            testValue = scan.nextInt();
         }
         else if (command == 7)
         {
            locations = bag.findAll(testValue);
         }
         else if (command == 8)
         {
            System.out.println(locations.toString());
         }
      }while(command != 9); 
      System.out.println("Goodbye!");
   }
}  
