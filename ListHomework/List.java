package cs102.ds;

/**
 * List class
 * @author: Irmak_Akyeli
 * @version: 07/05/2019
 */

public class List 
{
   // properties
   Node head;
   
   // constructors
   public List()
   {
      head = new Node(null , null);
   }
   
   /**
    * method to add to the head
    * @param:String item, the data of the node 
    */
   public void addToHead( String item)
   {
      Node n;
      n = head.next;  
      head.next = new Node(item , n);
   }
   
   /**
    * method to add to the tail
    * @param:String item, the data of the node 
    */
   public void addToTail( String item)
   {
      Node n = head.next;
      while (n.next != null )
      {
         n = n.next;
      }
      n.next = new Node(item , null);
   }    
   
   /**
    * method to remove the first node from the head
    */
   public String  removeFromHead()
   {
      Node n;
      n = head.next;
      head.next = n.next;
      return n.data;
   }
   
   /**
    * tells if the list is empty
    * @returns: boolean 
    */
   public boolean isEmpty()
   {
      if(head.next == null)
         return true;
      return false;
   }
   
   /**
    * method to get the data from the index given
    * @param:int index
    * @returns:String item, the data of the node 
    */
   public String  getData( int index) 
   {
      String s = "";
      if (index < 0)
         s = null;
      else if (index == 0)
         s = head.data;
      else
      {
         Node nextNode;
         nextNode = head.next;
         for(int i=0 ; i < index; i++)
         {
            if(nextNode.next != null)
            {
               s = nextNode.data;
               nextNode = nextNode.next;
            }
            else
               s = null;
         }
      }
      return s;
   }        
   
   /**
    * method to print the nodes in the list from head to tail
    */
   public void print()
   {
      Node n = head.next;
      while(n.next != null)
      {
         System.out.print(n.data + " ");
         n = n.next;
      }
      System.out.print(n.data);
   }                    
   
   /**
    *  method to print the nodes in the list from tail to head
    */
   public void printReverse()
   {
      if(head.next == null)
         System.out.println("empty");
      else
         printReverseRecursive(head);
   }                
   
   /**
    * the recursive method to print reverse
    * @param: node n needed to be recursive
    */
   public void printReverseRecursive(Node n)
   {
      if (n.next != null)
      {
         printReverseRecursive(n.next);
         if(n.data != null)
            System.out.print(n.data + " ");
      }
      else 
         System.out.print(n.data + " ");
   }
   
   /**
    *finds if there is a node with the data given as param
    * @param:String target
    * @returns: boolean
    */
   public boolean contains( String target)
   {
      Node n = head.next;
      boolean contains = false;
      while(n.next != null)
      {
         if(n.data.equals(target))
            contains = true;
         n = n.next;
      }
      return contains;
   }   
   
   /**
    *finds if the list is in alphabetical order
    *@returns: boolean
    */
   public boolean isOrdered()
   {
      boolean ordered = true;
      Node n;
      n = head.next;
      while(n.next != null)
      {
         if (n.data.compareTo(n.next.data) > 0)
            ordered = false;
         n = n.next;
      }
      return ordered;
   }    
   
   
   /**
    *returns string version of the list
    *@returns: String
    */
   public String toString()
   {
      String s = "";
      Node n = head.next;
      while(n.next != null)
      {
         s = s + n.data + " ";
         n = n.next;
      }
      s = s + n.data + " ";
      return s;
   }
   
   /**
    * gives the next node in the list of the given node
    * @param: Node
    * @returns: Node
    */
   private Node next(Node n)
   {
      if (n.next != null)
         return n.next;
      return null;
   }
   
   /**
    * gives the previous node in the list of the given node
    * @param: Node
    * @returns: Node
    */
   private Node previous(Node n)
   {
      Node node = head.next;
      if (head.next == n)
         return head;
      while(node.next != null)
      {
         if (node.next == n)
            return node;
      }
      return null;
   }
   
   /**
    * gives the last node in the list of the given node
    * @returns: Node
    */
   private Node tail()
   {
      Node n = head.next;
      while (n.next != null )
      {
         n = n.next;
      }
      return n;
   }
   
   /**
    * creates a list from the given string array
    * @param: String[] s
    * @returns: list
    */
   public static List createFrom(String[] s)
   {
      List list = new List();
      list.addToHead(s[0]);
      for (int i=1; i < s.length; i++)
      {
         list.addToTail(s[i]);
      }
      return list;
   }
   
   /**
    * merges the two given list exculuding the common elemants
    * @param: List a, List b
    * @returns: List
    */
   public static List merger(List a, List b)
   {
      List list = new List();
      Node nb = b.head.next;
      while (nb.next != null)
      {
         if(a.contains(nb.data))
            list.addToTail(nb.data);
         nb = nb.next;
      }
      return list;
   }
   
   /**
    * subclass of Node
    * @author: Irmak_Akyeli
    * @version: 07/05/2019
    */
   private class Node {
      String data; 
      Node next; 
      public Node( String data, Node next) {
         this.data = data; 
         this.next = next; 
      } 
   } // end class Node
}