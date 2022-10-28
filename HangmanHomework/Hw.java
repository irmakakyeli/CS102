import java.util.Scanner;

/**
 * Hanmgman Demo
 * @author Irmak Akyeli
 * @version 12.02.2019
 */ 

public class Hw
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants
      
      // variables
      Hangman hangman;
      char temp;
      int controller;
      
      // program code
      hangman = new Hangman();
      controller = 0;
      
      do
      {
         // Current state of the game
         System.out.println( "All letters: " + hangman.getAllLetters() );
         System.out.println( "Used letters: " + hangman.getUsedLetters() );
         System.out.println( "Allowed incorrect tries: " 
                               + (hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries()));
         System.out.println( "Letter known so far: " + hangman.getKnownSoFar());
         System.out.println();
         
         // Reading letter.
         System.out.print( "Please enter a letter: " );
         temp = scan.next().charAt(0);
         
         controller = hangman.tryThis( temp );
         
         if ( controller == -1 )
            System.out.println( "The letter is not valid. ");
         else if ( controller == -2)
            System.out.println( "The letter was already used.");
         else if (controller == -3)
            System.out.println("The game is already over");
         
         System.out.println();
         
      } while ( !hangman.isGameOver() && !hangman.hasLost() );
      
      // Last state of the game
      System.out.println( "All letters: " + hangman.getAllLetters() );
      System.out.println( "Used letters: " + hangman.getUsedLetters() );
      System.out.println( "Allowed incorrect tries: " 
                            + (hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries()));
      System.out.println( "Letter known so far: " + hangman.getKnownSoFar());
      
      if ( hangman.hasLost())
         System.out.println( "You lost.");
      else
         System.out.println( "You win.");
   }
}