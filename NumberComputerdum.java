public class NumberComputerdum   // The NumberComputerdumb Class (less intelligent than other computer)
{   
  
  // No constructor because a custom one is not needed
  
  // Methods
  public int play(int count)
  {
    if (Math.random() < .5)  // randomly plays a 1 or a 2
    {
      System.out.println("\nThe dumb computer has taken 1 playing element.");
      return 1;
    }
    else
    {
      System.out.println("\nThe dumb computer has taken 2 playing elements.");
      return 2;
    }
  }
}
