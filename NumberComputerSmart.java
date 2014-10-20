public class NumberComputerSmart   // The NumberComputer Class
{   
  
  // No constructor because a custom one is not needed
  
  // Methods
  public int play(int count)
  {
    switch (count%3)   // Creates a switch case based on the remainder of the number of playing elements left divided by 3
    {
      case 1:   // If the raminder is 1 the computer will take 1 or 2 playing elements randomly.
        if (count >= 2) {   // The computer will only take playing elements randomly if there are 2 or more playing elements left
          int guess = (int)(Math.random()*2+1);
          if (guess == 1) {   // Checks if the computer has taken one playing element and makes the reply gramatically correct.
            System.out.println("\nThe smart computer has taken 1 playing element.");   
          }
          else {
            System.out.println("\nThe smart computer has taken 2 playing elements.");
          }
          return guess;
        }
        else {   // If their is only 1 playing element left the computer will take one playing element.
          System.out.println("\nThe smart computer has taken 1 playing element.");
          return 1;
        }
      case 2:
        System.out.println("\nThe smart computer has taken 1 playing element.");   // If the remainder is 2 the computer will always take 1 so that the number of remaining playing elements is divisible by 3. Thus ensuring its victory.
        return 1;
      default:
        System.out.println("\nThe smart computer has taken 2 playing elements.");   // In all other cases the computer will take 2 playing elements
        return 2;
    }
  }
}
