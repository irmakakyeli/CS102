
/**
 * 100PrimeNumbers
 * @Irmak_Akyeli
 * 
 */ 
public class PrimeNumbers
{
   //constants
   static final int MAX = 100;
   
   // properties
   IntBag primeList;
   int number = 2;
   int counter = 0;
   boolean isPrime = true;
   
   //constructors
   //creates a prime number list using IntBag
   public PrimeNumbers()
   {
      primeList = new IntBag(MAX);
   }
   
   //methods
   
   /* calculates the primes numbers up to the max limit
    *
    */
   //calculates prime numbers and add to a bag
   public IntBag calculator()
   {
      while(counter < MAX)
      {
         if(number == 2)
         {
            primeList.add(2);
            number++;
         }
         
         for (int i=2; i < number; i++)
         {
            if (number % i == 0)
               isPrime = false;
         }
         if (isPrime == true)
         {
            counter++;
            primeList.add(number);
         }
         number++;
         isPrime = true;
      }
      return primeList;
   }
   
   //turns to string
   public String toString()
   {
      String str = "[";
      for (int i=0; i < primeList.valid; i++)
      {
         str = str + "" + primeList.get(i);
         if(i != primeList.valid - 1)
            str = str + ",";
      }
      str = str + "]";
      return str;
   }
}
