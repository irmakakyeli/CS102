import java.util.*;

/**
 * This is a test program for the class IntBagIterator
 * @author Irmak_Akyeli
 * @version 12/03/2019
 */

public class IntBagTester
{
   public static void main(String args[])
   {
      //variables
      Iterator i;
      Iterator j;
      IntBag bag; 
      
      //program code
      bag = new IntBag();
      bag.add(8);
      bag.add(7);
      bag.add(2);
      bag.add(4);
      bag.add(5);
      
      i = new IntBagIterator(bag);
      
      while ( i.hasNext() ) 
      {
         System.out.println( i.next() );
         
         j = bag.iterator();
         j = new IntBagIterator(bag);
         
         while ( j.hasNext() )
         {
            System.out.println( "--" + j.next());
         }
      }
   }
}