package cs102.ds;
import java.util.*;

/**
 * the main class to test the list classs
 * @author: Irmak_Akyeli
 * @version: 07/05/2019
 */
public class Test
{
   public static void main( String[] args)
   {
      
      // constants
      
      // variables
      List list;
      List list2;
      // program code
      list = new List();
      String[] s = {"a" , "tolga" , "c", "d"};
      System.out.println(list.isEmpty());
      list.addToHead("irmak");
      System.out.println(list.isEmpty());
      System.out.println(list.toString());
      list.addToHead("berkay");
      System.out.println(list.toString());
      list.addToTail("tolga");
      System.out.println(list.toString());
      list.removeFromHead();
      System.out.println(list.toString());
      System.out.println(list.getData(1));
      list.print();
      System.out.println();
      list.printReverse();
      System.out.println(list.contains("yusuf"));
      System.out.println(list.isOrdered());
      list2 = list.createFrom(s);
      System.out.print(list.merger(list, list2).toString());
   }
   
}