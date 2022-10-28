import java.util.*;

/**
 * This class provides the methods to get the next item and construct an iterator
 * @author Irmak_Akyeli
 * @version 12/03/2019
 */

public class IntBagIterator implements Iterator
{
   //variables
   private int i;
   private IntBag bag;
   
   //constructor
   public IntBagIterator( IntBag bag )
   {
      super();
      this.bag = bag; 
   }
   
   //methods
   
   /* a method to decide if there is a next thing
    * @return boolean
    */
   public boolean hasNext()
   {
      if ( i < bag.size())
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /* a method which gets the next Integer 
    * @return j
    */
   public Integer next()
   {
      Integer j = new Integer( bag.get(i));
      i++;
      return j;
   }
   
   /* a method which gets the next int
    * @return int
    */ 
   public int nextInt()
   {
      return bag.get(i);
   }
}