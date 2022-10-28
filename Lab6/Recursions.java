import java.util.*;

/**
 * A class which does several conditions with recursions
 * @author:Irmak_Akyeli
 * @versio:30/04/2019
 */
public class Recursions 
{
   // properties
   int count1 = 0;
   int count2 = 0;
   int count3 = 0;
   int count4 = 0;
   int index1 = 0;
   int index2 = 0;
   int index3 = 0;
   boolean bln = true;
   boolean isBigger = true;
   
   // constructor is empty as we use yhe methods only with no innitial condition
   public Recursions(){
   }
   
   // methods
   
   /**
    * a method wich counts the "e" letters in the string given
    * @param: String s
    */ 
   public void eCounter(String s)
   {
      if (index1 < s.length())
      {
         if (s.charAt(index1) == 'e')
            count1++;
         eCounter(s.substring(1));
         index1++;
      }
      else
      {
         System.out.println(count1);
         count1 = 0;
         index1 = 0;
      }
   }
   
   /**
    * a method wich counts the letters asked by the user in the string given
    * @param: String s
    * @param: char letter
    */ 
   public void letterCounter(String s, char letter)
   {
      if (index3 < s.length())
      {
         if (s.charAt(index3) == letter)
            count4++;
         letterCounter(s.substring(1), letter);
         index3++;
      }
      else
      {
         System.out.println(count4);
         count4 = 0;
         index3 = 0;
      }
   }
   
   /**
    * a method wich converts the given number in decimal to the binary version
    * @param: int value
    */ 
   public void binary(int value)
   {
      if(value > 0)
      {
         binary(value/2);
         System.out.print(value%2 + "");
      }
   }
   
   /**
    * a method wich checks if the elements of the array list is in alphabetical order
    * @param: ArrayList<String> list
    * @returns: boolean
    */ 
   public boolean lexicographic(ArrayList<String> list)
   {
      if(count2 < list.size()-1)
      {
         if(list.get(count2).compareTo(list.get(count2 + 1)) < 0)
         {
            count2++;
            lexicographic(list);
         }
         else
            bln = false;
      }
      else
         count2 = 0;
      return bln; 
   }
   
   /**
    * a method wich generates n-digit even numbers which its most-significant to least-significant digits, 
    * is greater than the previous one. 
    * @param: int n
    */
   public void evenNum(int n)
   {
      if (count3 == 0)
         count3 = (int) Math.pow((double) 10, (double) n-1);
      if (count3 < (Math.pow((double) 10, (double) n)) - 1)
      {
         if (bigger("" + count3))
            System.out.print(count3 + " ");
         count3 = count3 + 2;
         evenNum(n);
      }
      else 
         count3 = 0;
   }
   
   /**
    * a method wich checks if the elements of the int, which is used as a string for easier comparaison,
    * are from its most-significant to least-significant digits, is greater than the previous one
    * @param: String num
    * @returns: boolean
    */ 
   public boolean bigger(String num)
   {
      if(index2 < num.length()-1)
      {
         isBigger = true;
         if (Integer.valueOf(num.charAt(0)) >= Integer.valueOf(num.charAt(1)))
         {
            isBigger = false;
         }
         else 
         {
            bigger(num.substring(1));
            index2++;
         }  
         index2 = 0;
      }
      return isBigger;
   }
}