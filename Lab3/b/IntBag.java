import java.util.*;
/**
 *a java class which creates Int Array
 * @Irmak Akyeli
 */
public class  IntBag
{
   // constants
   static final int MAX = 100;
   
   // properties
   int[] bag;
   int valid;
   
   // constructors
   //creates IntBag with limit chosen by the constant MAX
   public IntBag()
   {
      bag = new int[MAX];
      valid = 0;
      for (int i=0; i < MAX; i++)
      {
         bag[i] = 0;
      }
   }
   
   //creates IntBag with the limit given by the user
   public IntBag(int limit)
   {
      bag = new int[limit];
      valid = 0;
      for(int i=0; i < limit; i++)
      {
         bag[i] = 0;
      }
   }
   
   // methods
   
   /* added to the bag
    * @param value 
    * @return boolean 
    * returns true if it can add false if there is no space left
    */
   //adds the given value at the end of the collection
   public boolean add(int value)
   {
      if(valid < bag.length)
      {
         bag[valid] = value;
         valid++;
         return true; 
      }
      else
         return false;
   }
   /*added to the bag with 
    * @param value
    * the index specified
    * @param index
    * @return boolean
    * returns true if it can add false if there is no space left
    */
   //adds the given value at the index specified
   public boolean add(int value, int index)
   {
      if (valid < bag.length)
      {
         for(int i=0; i < valid - index; i++)
         {
            bag[valid - i] = bag[valid - i - 1];
         }
         bag[index] = value;
         valid++;
         return true;
      }
      else
         return false;
   }
   
   /* removes the value at the index given
    * @param index 
    * @return boolean 
    * returns true if there is a value in the index and false if not
    */
   //removes the value at the given index
   public boolean remove(int index)
   {
      if (index < valid)
      {
         for (int i=0; i < valid - index; i++)
         {
            bag[index + i] = bag[index + i + 1];
         }
         valid--;
         return true;
      }
      else
         return false;
   }
   
   /* finds id the bag contains
    * @param value 
    * @return int
    * returns the location of the given value
    */
   //finds and tell the location of the last value wanted if it does not exist in the bag returns -1
   public int contains(int value)
   {
      int index = -1;
      for (int i=0; i < valid; i++)
      {
         if (bag[i] == value)
            index = i;
      }
      return index;
   }
   
   /*@return int
    *returns the number of used places in the bag
    */ 
   //returns the number of used locations
   public int size()
   {
      return valid;
   }
   
   /* returns the value in the given param
    * @param index 
    * @return int
    * the value in the index given
    */
   //returns the value at the index asked
   public int get(int index)
   {
      if (index < valid)
         return bag[index];
      else
         return -1;
   }
   
   //to print string version of the bag
   public String toString()
   {
      String str = "[";
      for (int i=0; i < valid; i++)
      {
         str = str + "" + bag[i];
         if(i != valid - 1)
            str = str + ",";
      }
      str = str + "]";
      return str;
   }
   
   /* finds all the locations in the bag given of the param and vreates a new bag of locations
    * @param value 
    * @return IntBag
    * new bag with all the locations of the wanted value
    */
   //creates a new bag with all the locations of the wanted value
   public IntBag findAll(int value)
   {
      IntBag bagOfLocations;
      bagOfLocations = new IntBag();
      for (int i=0; i < this.size(); i++)
      {
         if(bag[i] == value)
         {
            bagOfLocations.add(i);
         }
      }
      return bagOfLocations;
   }
   
   public Iterator iterator()
   {
      return new IntBagIterator(this);
   }
   
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
}
