import java.util.Scanner;

/**
 * Created by Neal on 12/27/2014.
 */

public class PiEstimation
{
    static final double stickLength = 1.0;
    static final double gapLength = 1.0;
    static final double totalHeight = stickLength * 5;
    static int printFrequency;
    
    public static void main(String[] args)
    {
        System.out.print("How many stick tosses? ");
        Scanner input = new Scanner(System.in);
        long stickTosses = input.nextLong();
        System.out.println();

        setPrintFrequency(stickTosses);

        double crossing = 0;


        long i = 0;
        while (i < stickTosses) {      //While there are more sticks to throw
            Stick stick = new Stick(); //Drop new stick
            if (stick.isCrossing()) {
                crossing++;
            }

            printPi(i, crossing);
            printRemainingTosses(i, stickTosses);

            i++;
        }
    }

    /* Print out the current estimate of pi following every 100,000th toss */
    private static void printPi(long i, double crossing) {
        if ((i % printFrequency) == 0) {
            System.out.print("\rEstimated Pi: " + (2 * stickLength * (i / crossing)) + "  \t");
        }
    }

    private static void printRemainingTosses(long i, long stickTosses) {
        if ((i % printFrequency) == 0) {
            System.out.print("Tosses Left: " + (stickTosses - i) + "\t");
        }
    }

    private static void setPrintFrequency(long stickTosses) {
        if (stickTosses < 1000) {
            printFrequency = 1;
        } else {
            printFrequency = (int)(stickTosses / 1000);
        }
    }
}