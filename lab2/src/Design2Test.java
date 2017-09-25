import java.io.*;

public class Design2Test
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the Design2
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java
   * Design2Test &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */
  public static void main(String[] args)
  {
    Design2 point;

    System.out.println("Cartesian-Polar Coordinates Conversion Program - Design 2");

    // Check if the user input coordinates from the command line
    // If he did, create the Design object from these arguments.
    // If he did not, prompt the user for them.
    try
    {
      point = new Design2(Double.valueOf(args[1]).doubleValue(),
        Double.valueOf(args[2]).doubleValue());
    }
    catch(Exception e)
    {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if(args.length != 0)
        System.out.println("Invalid arguments on command line");

      try
      {
        point = getInput();
      }
      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }
    System.out.println("\nYou entered:\n");
    System.out.println("["+ point.getRho()+", "+point.getTheta()+"]");

    //point.convertStorageToCartesian();
    System.out.println("\nAfter asking to compute as Cartesian:\n");
    System.out.println("("+ point.getX()+", "+point.getY()+")");
    //point.computeCartesian();
    //System.out.println("\nAfter asking to store as Polar:\n" + point);
  }

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a Design2
   * object.
   *
   * @return A Design2 constructed using information obtained
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static Design2 getInput() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information

    //Information to be passed to the constructor
    //char coordType = 'A'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the two different arguments
    for (int i = 0; i < 2; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid

        // Prompt the user
        if (i == 0) // First argument - Rho
        {
            System.out.println("Enter the value of Rho using a decimal point(.): ");
        }
        else // Second argument - Theta
        {
            System.out.println("Enter the value of Theta using a decimal point(.): ");
        }

        // Get the user's input

        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';

        System.in.read(buffer);
        theInput = new String(buffer).trim();

        // Verify the user's input
        try
        {
          if (i == 0) // First argument -- Rho
          {
              a = Double.valueOf(theInput).doubleValue();
          }
          else
          {
              b = Double.valueOf(theInput).doubleValue();
          }
        }
        catch(Exception e)
        {
        	System.out.println("Incorrect input");
        	isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }
    //Return a new Design2 object
    return (new Design2(a, b));
  }
}
