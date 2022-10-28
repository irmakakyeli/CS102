import java.util.Scanner;

/**
 * __IntBag___ 
 * @author __Irmak_Akyeli___
 * @version __17/02/2019__
 */ 
public class Test
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // constants
      
      // variables
      IntBag bag;
      PrimeNumbers prime;
      
      // program code
      System.out.println( "Start...");
      bag = new IntBag();
      prime = new PrimeNumbers();
      System.out.println(bag);
      bag.add(3);
      bag.add(5);
      bag.add(4);
      bag.add(3);
      bag.add(3);
      bag.add(5);
      bag.add(4);
      bag.add(3);
      System.out.println(bag);
      System.out.println(bag.contains(4));
      System.out.println(bag);
      System.out.println(bag.get(2));               
      bag.add(7 , 0);
      System.out.println(bag);
      bag.remove(3);
      System.out.println(bag);
      System.out.println(bag.findAll(7));
      prime.calculator();
      System.out.println( prime.toString());
      System.out.println( "End.");
   }
   
}