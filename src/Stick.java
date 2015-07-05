import java.security.SecureRandom;

/**
 * Created by Neal on 2/27/2015.
 */
public class Stick {

    SecureRandom cords = new SecureRandom();
    private final double radian = Math.PI/180.0;

    /* Position of stick */
    double botY;
    double angle;
    double topY;

    public Stick() {
        //Set position of stick
        botY = cords.nextDouble() * PiEstimation.totalHeight;
        angle = cords.nextDouble() * 90.0;
        topY = findTopPointY(angle, botY);

        correctCordLabels();
    }

    public boolean isCrossing() {
        double gapCap = findGapLocation(botY);

        /* Use the gap to calculate whether the stick crosses the line */
        double xDist = gapCap - (((topY - botY)/2) + botY);
        double yDist = (PiEstimation.stickLength / 2.0) * Math.sin(angle * radian);
        if (xDist <= yDist)
        {
            return true;
        } else {
            return false;
        }
    }

    /* Switch labels of top and bottom coordinates if necessary */
    private void correctCordLabels() {
        if (botY > topY)
        {
            double yPlace = botY;
            botY = topY;
            topY = yPlace;
        }
    }

    private double findTopPointY(double angle , double botY)
    {
        double height = (Math.sin(angle*radian)) * PiEstimation.stickLength;
        return botY + height; //Adds height to the bottom y coordinate to give the top y coordinate
    }

    /* Find which gap the stick is in */
    private double findGapLocation(double botY)
    {
        for (double j = PiEstimation.gapLength; j <= PiEstimation.totalHeight; j += PiEstimation.gapLength)
        {
            if (botY < j)
            {
                return j;
            }
        }
        return PiEstimation.totalHeight;
    }
}
