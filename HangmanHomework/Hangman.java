import java.util.Scanner;
import java.io.*;
/*
 * Hangman game class.
 * @author: Abdulmalak Albeik, Denizhan Kemeroz, Beril Canbulan, Tolga Ciftci, Irmak Akyeli, Isik Ozsoy.
 * @version: 12/02/2019
 */

public class Hangman
{
   // properties
   StringBuffer secretWord;
   StringBuffer allLetters;
   StringBuffer usedLetters;
   StringBuffer knownSoFar;
   int numberOfIncorrectTries;
   int maxAllowedIncorrectTries;
   StringBuffer[] wordList = {new StringBuffer("orange"),
      new StringBuffer("monkey"),
      new StringBuffer("person")};
   
   
   // Constructer.
   public Hangman( ) 
   {
      secretWord = chooseSecretWord();
      maxAllowedIncorrectTries = 6;
      numberOfIncorrectTries = 0;
      allLetters = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");  
      usedLetters = new StringBuffer("");
      knownSoFar = new StringBuffer("");
   }
   
// methods
   public StringBuffer getAllLetters()
   {
      return this.allLetters;
   }
   
   public StringBuffer getUsedLetters()
   {
      return this.usedLetters;
   }
   
   public int getNumOfIncorrectTries()
   {
      return this.numberOfIncorrectTries;
   }
   
   public int getMaxAllowedIncorrectTries()
   {
      return this.maxAllowedIncorrectTries;
   }
   
   public StringBuffer getKnownSoFar()
   {
      return this.knownSoFar;
   }
   
   private StringBuffer chooseSecretWord()
   {
      return wordList[(int) (Math.random() * wordList.length)];
   }
   
   public int tryThis( char input)
   {
      int counter = 0;
      
      // check if the letter was used before.
      if (this.usedLetters.indexOf(input + "") >= 0)
         return -2;
      
      // check if the letter is valid.
      if (this.allLetters.indexOf(input + "") >= 0)
         return -1;
      
      usedLetters.append(input);
      // check if game is already over
      if (this.isGameOver())
         return -3;
      
      // see how many times the letter accurs in the secretWord
      for (int i=0; i < this.secretWord.length(); i++)
      {
         if (this.secretWord.charAt(i) == input)
            counter++;
      }
      // If the counter is 0 then it adds to incorrect tries
      if ( counter == 0)
         numberOfIncorrectTries++ ;
      else
         knownSoFar.append(input);
      return counter;
   }
   
   public boolean isGameOver()
   {
      return this.knownSoFar.equals(this.secretWord);
   }
   
   public boolean hasLost()
   {
      return numberOfIncorrectTries == maxAllowedIncorrectTries;
   }
   
   private static String chooseSecretWord(String path) throws Exception
   {
      File file = new File( path);
      Scanner scan = new Scanner(file);
      scan.useDelimiter("\\Z");
      return scan.next();
   }
}