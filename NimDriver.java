// Made by Devon Lee and Justin Kunimune (but mainly Justin!)

import java.util.Scanner;   // Imports the stuff to take user input

public class NimDriver
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);   // Creates a new Scanner called scan.
    int count;   // Creates and int that keeps track of the number of playing elements.
    int rounds;  // Keeps track of how many rounds
    int playerscore = 0;  // Keeps track of score
    boolean turn = false;   // Creates a boolean that keeps track of if it is the human player's turn or not.
    int turntype = 0;
    NumberComputerSmart compter = new NumberComputerSmart();   // Creates a new NumberComputer named compter. (A new computer player)
    NumberPlayer player1 = new NumberPlayer();   // Creates a new NumberPlayer named player1. (A new human player)
    
    System.out.println("How many rounds shall we play?");
    rounds = scan.nextInt();   // Takes the user's input to determine how many rounds should be played.
    while (rounds < 1) {
      System.out.println("It must be greater than 0.");
      rounds = scan.nextInt();   // retakes input if invalid
    }
    
    System.out.println("How many playing elements shall we use?");
    count = scan.nextInt();   // Takes the user's input to determine how many playing pieces should be used in the game.
    while (count < 1) {
      System.out.println("Nice try.");
      count = scan.nextInt();   // retakes input if invalid
    }
    
    System.out.println("\nWould you like to make the first move or do you want to have the computer randomly choose.");
    String reply = scan.nextLine();   // Takes the user's input to determine if the human or the computer goes first.
    if (!reply.equalsIgnoreCase("No") && !reply.equalsIgnoreCase("Yes")) {   // Only allows the user to enter yes or no.
      while (!reply.equalsIgnoreCase("No") && !reply.equalsIgnoreCase("Yes") && !reply.equalsIgnoreCase("Random")) {
        System.out.println("\nOnly \"Yes\" or \"No\" or \"Random\" are valid answers.");
        reply = scan.nextLine();
      }
    }
    if (reply.equalsIgnoreCase("Yes")) {   // Checks if the user said yes and makes it so that the player will make the first move.
      turntype = 1;
    }
    else if (reply.equalsIgnoreCase("Random")) {   // Checks if the user said random and randomly chooses who goes first (if neither, then turntype stays 0, meaning the computer will go first
      System.out.println("\nLeaving your fate to chance I see.\n");
      turntype = 2;
    }
    System.out.println("\nOk. Let's begin.");
    for (int i = 1; i < rounds+1; i ++)  // runs the game a given number of times (based on input)
    {
      System.out.println("\nRound "+i+":"); // prints round number
      
      switch (turntype) // decides who goes first based on earlier input
      {
        case 1:
          turn = true;
          break;
        case 2:
          turn = Math.random() < .5;
          break;
        default:
          turn = false;
      }
      
      int tempcount = count; // resets number of pieces
      do
      {
        if (turn)  tempcount -= player1.play(tempcount);   // Checks if it is the player's turn and sets the total number of playble elements to be however many the player took less than it was previously.
        else       tempcount -= compter.play(tempcount);   // Checks if it is the computer's turn and sets the total number of playble elements to be however many the computer took less than it was previously.
        turn = !turn;   // Switches turn
      }
      while (tempcount > 0);   // Makes the game continue as long as there are still playable pieces.
      
      if (turn)
      {
        System.out.println("\nGratz! You wondededed!\n\n"); // tells and records if player won
        playerscore ++;
      }
      else
        System.out.println("\nThe computer wins!\n\n"); // tells if computer won (the program can calculate later, so no need to record
    }
    System.out.println("\nYou won "+playerscore+", and the computer won "+(rounds-playerscore)+".");  // prints final score report
    if (playerscore > (double)rounds/2)  System.out.println("You are victorious!");
    else                                 System.out.println("You have been defeated.");
  }
}


