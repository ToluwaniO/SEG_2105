// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com

import java.io.*;

/**
 * This class prompts the user for a set of coordinates, and then
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class DesignTest
{
    //Class methods *****************************************************

    /**
     * This method is responsible for the creation of the PointCP
     * object.  This can be done in two ways; the first, by using the
     * command line and running the program using <code> java
     * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
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
        DesignFive point;
        char type;

        System.out.println("Cartesian-Polar Coordinates Conversion Program");

        // Check if the user input coordinates from the command line
        // If he did, create the PointCP object from these arguments.
        // If he did not, prompt the user for them.
        try
        {
            type = args[0].toUpperCase().charAt(0);
            double a = Double.valueOf(args[1]).doubleValue();
            double b = Double.valueOf(args[2]).doubleValue();

            if(type == 'P')
            {
                point = new Design2(a, b);
            }
            else if(type == 'C')
            {
                point = new DesignThree(a, b);
            }
            else{
                throw new Exception("Error");
            }
        }
        catch(Exception e)
        {
            // If we arrive here, it is because either there were no
            // command line arguments, or they were invalid
            if(args.length != 0)
                System.out.println("Invalid arguments on command line");

            try
            {
                type = getType();
                if(type == 'C')
                {
                    System.out.println("Type c");
                    point = getInput3();
                }
                else
                {
                    System.out.println("Type p");
                    point = getInput2();
                }
            }
            catch(IOException ex)
            {
                System.out.println("Error getting input. Ending program.");
                return;
            }
        }
        System.out.println("\nYou entered:\n" + point);
        if(type == 'P') {
            System.out.println("\nAfter asking to compute as Cartesian:\n" + point.convertStorageToCartesian());
        }
        else{
            System.out.println("\nAfter asking to compute as Polar:\n" + point.convertStorageToPolar());
        }
    }

    /**
     * This method obtains input from the user and verifies that
     * it is valid.  When the input is valid, it returns a PointCP
     * object.
     *
     * @return A PointCP constructed using information obtained
     *         from the user.
     * @throws IOException If there is an error getting input from
     *         the user.
     */
    private static DesignThree getInput3() throws IOException
    {
        byte[] buffer = new byte[1024];  //Buffer to hold byte input
        boolean isOK = false;  // Flag set if input correct
        String theInput = "";  // Input information

        //Information to be passed to the constructor
        char coordType = 'C'; // Temporary default, to be set to P or C
        double a = 0.0;
        double b = 0.0;

        // Allow the user to enter the three different arguments
        for (int i = 0; i < 2; i++)
        {
            while (!(isOK))
            {
                isOK = true;  //flag set to true assuming input will be valid

                // Prompt the user
                if(i == 0)
                System.out.println("Enter the value of X using a decimal point(.): ");
                else
                System.out.println("Enter the value of Y using a decimal point(.): ");

                // Get the user's input

                // Initialize the buffer before we read the input
                for(int k=0; k<1024; k++)
                    buffer[k] = '\u0020';

                System.in.read(buffer);
                theInput = new String(buffer).trim();

                // Verify the user's input
                try
                {
                    //Convert the input to double values
                    if (i == 1)
                        a = Double.valueOf(theInput).doubleValue();
                    else
                        b = Double.valueOf(theInput).doubleValue();
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
        //Return a new PointCP object
        return (new DesignThree(a, b));
    }

    /**
     * This method obtains input from the user and verifies that
     * it is valid.  When the input is valid, it returns a PointCP
     * object.
     *
     * @return A PointCP constructed using information obtained
     *         from the user.
     * @throws IOException If there is an error getting input from
     *         the user.
     */
    private static Design2 getInput2() throws IOException
    {
        byte[] buffer = new byte[1024];  //Buffer to hold byte input
        boolean isOK = false;  // Flag set if input correct
        String theInput = "";  // Input information

        //Information to be passed to the constructor
        char coordType = 'P'; // Temporary default, to be set to P or C
        double a = 0.0;
        double b = 0.0;

        // Allow the user to enter the three different arguments
        for (int i = 0; i < 2; i++)
        {
            while (!(isOK))
            {
                isOK = true;  //flag set to true assuming input will be valid

                // Prompt the user
                if(i == 0)
                    System.out.println("Enter the value of Rho using a decimal point(.): ");
                else
                    System.out.println("Enter the value of Theta using a decimal point(.): ");

                // Get the user's input

                // Initialize the buffer before we read the input
                for(int k=0; k<1024; k++)
                    buffer[k] = '\u0020';

                System.in.read(buffer);
                theInput = new String(buffer).trim();

                // Verify the user's input
                try
                {
                    //Convert the input to double values
                    if (i == 1)
                        a = Double.valueOf(theInput).doubleValue();
                    else
                        b = Double.valueOf(theInput).doubleValue();
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
        //Return a new PointCP object
        return (new Design2(a, b));
    }

    private static char getType() throws IOException
    {
        char type;
        byte[] buffer = new byte[1024];  //Buffer to hold byte input
        String theInput = "";

        System.out.print("Enter the type of Coordinates you "
                + "are inputting ((C)artesian / (P)olar): ");

        for(int k=0; k<1024; k++)
            buffer[k] = '\u0020';

        System.in.read(buffer);
        theInput = new String(buffer).trim();

        if (!((theInput.toUpperCase().charAt(0) == 'C')
                || (theInput.toUpperCase().charAt(0) == 'P')))
        {
            //Invalid input, reset flag so user is prompted again
            System.out.println("Invalid input! \nEnter: ");
            type = getType();
        }
        else
        {
            type = theInput.toUpperCase().charAt(0);
        }
        return type;
    }
}
