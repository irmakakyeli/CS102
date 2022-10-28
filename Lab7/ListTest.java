package cs102.ds;
import junit.framework.TestCase;

/**
 * Junit test class to test List class
 * @author: Irmak_Akyeli
 * @version: 07/05/2019
 */
public class ListTest extends TestCase
{
   List list;
   
   public void setUp()
   {
      list = new List();
   }
   
   public void testIsEmpty()
   {
      assertTrue("the method is not working" , list.isEmpty());
      list.addToHead("irmak");
      list.addToHead("berkay");
      assertTrue("the method is not working" , !list.isEmpty());
   }
   
   public void testGetData()
   {
      list.addToHead("irmak");
      list.addToHead("berkay");
      assertEquals("the method is not working", "berkay", list.getData(1));   
   } 
}