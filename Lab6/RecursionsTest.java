import java.util.*;

/**
 * __Test for Recursive class___ 
 * @author __Akyeli_Irmak___
 * @version __30/04/2019__
 */ 
public class RecursionsTest
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants

      // variables
      Recursions myRec;
      String test;
      ArrayList<String> list;

      // program code
      list = new ArrayList<String>();
      list.add("Akyeli");
      list.add("Burcu");
      list.add("Irmak");

      myRec = new Recursions();
      test = "eecdcekee";
      myRec.eCounter(test); 
      myRec.letterCounter(test, 'c');
      myRec.binary(6);
      System.out.println();
      System.out.println(myRec.lexicographic(list));
      myRec.evenNum(3);
   }
   
}