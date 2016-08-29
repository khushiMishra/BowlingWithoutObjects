// Bowling Program B1
// Stephen Reader


//Imported
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bowling
{
    public static void main(String[] args)
    {
        // Array to hold the numbers in the file
        int [] numArray = new int[50];

        // Create file
        File theFile = null;


        // ***** USED FOR COMMAND LINE ***** MAC OSx
        // Steps:
        // 1. Go to correct directory
        // 2. write javac Bowling.java
        // 3. write java Bowling b1.txt (runs b1.txt file)
        // 4. Get output!
        // Make sure there is an arg. Will then be able to run any file name
        if (0 < args.length)
        {
            // Set file to arg
            theFile = new File(args[0]);

            // Had to add try and catch, or else couldn't use javac in command line
            try {
                // Use scanner to get into file
                Scanner scanner = new Scanner(theFile);

                // Used to increment position in array
                int x = 0;
                while (scanner.hasNextInt())
                {
                    // Add int to array
                    numArray[x++] = scanner.nextInt();
                }
                // Done with scanner
                scanner.close();
            }
            catch(IOException exc)
            {
                System.out.println("I/O Error: " + exc);
            }

        }
        else
        {
            // Error println output...Kill program
            System.err.println("Not enough args. Given: " + args.length);
            System.exit(0);
        }



        // *** At this point all of the data should be in the array ***

        // Need a way to keep count of what frame the bowler is in and set score to 0 for start of game
        int frame = 0;
        int score = 0;

        // Keeps track of amount of ints used in case there are not enough ints entered for 10th frame
        int for_tenth = 0;

        // Loop through array
        for(int i = 0; i < numArray.length; i++)
        {
            // Make sure that the frame is 1-9
            if(frame < 9)
            {
                // If a throw is a strike
                if (numArray[i] == 10)
                {
                    score = score + numArray[i] + numArray[i+1] + numArray[i+2];
                    frame++;
                    for_tenth++;
                }
                // If throw is a spare
                else if(numArray[i] != 0 && numArray[i+1] != 0 && numArray[i]+numArray[i+1] == 10 && frame < 10)
                {
                    score = score + numArray[i] + numArray[i+1] + numArray[i+2];
                    frame++;
                    i++;
                    for_tenth = for_tenth +2;
                }
                // If throw is not a strike or a spare
                else
                {
                    score = score + numArray[i] + numArray[i+1];
                    frame++;
                    i++;
                    for_tenth = for_tenth + 2;
                }
            }
        }// End for loop (frame 1-9)

        // 10th frame
        score = score + numArray[for_tenth] + numArray[for_tenth+1] + numArray[for_tenth+2];

        // Print score to console
        System.out.println("Final Game Score: " + score);

    }// End main()
}// End class Bowling
