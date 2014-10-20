// Made by Devon Lee and Justin Kunimune (but mainly Justin!)

import java.util.Scanner;   // Imports the stuff to take user input

public class NimCompvCompDriver  // This is computervcomputer stuff
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);   // Creates a new Scanner called scan.
    int count;   // Creates and int that eeps track of the number of playing elements.
    int rounds;  // Keeps track of how many rounds
    int dumbscore = 0;  // Keeps track of dumb computer's score
    boolean turn = false;   // Creates a boolean that keeps track of if it is the human player's turn or not.
    int turntype = 0;
    NumberComputer smatcomp = new NumberComputer();   // Creates a new NumberComputer named computer. (A new computer player)
    NumberComputerdum dumbcomp = new NumberComputerdum();   // Creates a new NumberPlayer named player1. (A new human player)
    
    System.out.println("How many rounds shall we play?");
    rounds = scan.nextInt();   // Takes the user's input to determine how many playing pieces should be used in the game.
    while (rounds < 1) {
      System.out.println("Very funny.  2 or greater, please.");
      rounds = scan.nextInt();   // Takes the user's input to determine how many playing pieces should be used in the game.
    }
    
    System.out.println("How many playing elements should we use?");
    count = scan.nextInt();   // Takes the user's input to determine how many playing pieces should be used in the game.
    while (count < 1) {
      System.out.println("Very funny, flesh-bag.");
      count = scan.nextInt();   // Takes the user's input to determine how many playing pieces should be used in the game.
    }
    
    System.out.println("\nWould the dumb computer to go first, or do you want to have the computer randomly choose?");
    String reply = scan.nextLine();   // Takes the user's input to determine if the human or the computer goes first.
    if (!reply.equalsIgnoreCase("No") && !reply.equalsIgnoreCase("Yes")) {   // Only allows the user to enter yes or no.
      while (!reply.equalsIgnoreCase("No") && !reply.equalsIgnoreCase("Yes") && !reply.equalsIgnoreCase("Random")) {
        System.out.println("\nOnly \"Yes\" or \"No\" or \"Random\" are valid answers.");
        reply = scan.nextLine();
      }
    }
    if (reply.equalsIgnoreCase("Yes")) {   // Checks if the user said yes and makes it so that the player will make the first move.
      turn = true;
    }
    else if (reply.equalsIgnoreCase("Random")) {   // Checks if the user said random and randomly chooses who goes first
      System.out.println("\nLeaving your fate to chance I see.\n");
      if ((int)(Math.random()*2+1) == 1) {   // Picks a random number either 1 or 2
        turn = true;   // If the random number is 1 the player will go first
        System.out.println("I have decided to let the dumb computer go first.");
      }
      else {
        System.out.println("I have decided to let the smart computer go first.");
      }
    }
    System.out.println("\nOk. Let's begin.");
    for (int i = 1; i < rounds+1; i ++)
    {
      System.out.println("\nRound "+i+":");
      
      switch (turntype)
      {
        case 1:
          turn = true;
          break;
        case 2:
          turn = Math.random()<.5;
          break;
        default:
          turn = false;
      }
      
      int tempcount = count;
      do
      {
        if (turn)  tempcount -= dumbcomp.play(tempcount);   // Checks if it is the player's turn and sets the total amount of playble elements to be however many the player took less than it was previously.
        else       tempcount -= smatcomp.play(tempcount);   // Checks if it is the computer's turn and sets the total amount of playble elements to be however many the computer took less than it was previously.
        turn = !turn;   // Switches turn
      }
      while (tempcount > 0);   // Makes the game continue as long as there are still playable pieces.
      
      if (turn)
      {
        System.out.println("\nThe dumb computer wins!\n\n");
        dumbscore++;
      }
      else
        System.out.println("\nThe smart computer wins!\n\n");
    }
    System.out.println("\nThe dumb computer won "+dumbscore+", and the smart computer won "+(rounds-dumbscore)+".");
    if (dumbscore > (double)rounds/2)  System.out.println("The dumb computer is victorious!  Amazing!");
    else                                 System.out.println("The smart computer is victorious.  Big surprise.");
  }
}


