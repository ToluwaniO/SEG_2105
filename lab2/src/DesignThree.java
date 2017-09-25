import sun.security.krb5.internal.crypto.Des;

/**
 * Created by oguns on 9/21/2017.
 */
public class DesignThree extends DesignFive{
    //Instance variables ************************************************

    /**
     * Contains C(artesian) or P(olar) to identify the type of
     * coordinates that are being dealt with.
     */
    private char typeCoord;

    /**
     * Contains the current value of X or RHO depending on the type
     * of coordinates.
     */
    private double xOrRho;

    /**
     * Contains the current value of Y or THETA value depending on the
     * type of coordinates.
     */
    private double yOrTheta;


    //Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     */
    public DesignThree(double xOrRho, double yOrTheta)
    {
        this.xOrRho = xOrRho;
        this.yOrTheta = yOrTheta;
    }


    //Instance methods **************************************************


    public double getX()
    {
        return xOrRho;

    }

    public double getY()
    {
        return yOrTheta;
    }

    public double getRho()
    {

        return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
    }

    public double getTheta()
    {
        return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
    }


    /**
     * Converts Cartesian coordinates to Polar coordinates.
     */
    public Design2 convertStorageToPolar()
    {
        //Calculate RHO and THETA
        double tempRho = getRho();
        double tempTheta = getTheta();
        return new Design2(tempRho, tempTheta);

    }

    /**
     * Converts Polar coordinates to Cartesian coordinates.
     */
    public DesignThree convertStorageToCartesian()
    {
        return new DesignThree( xOrRho, yOrTheta);
    }

    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @param pointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public double getDistance(PointCP pointB)
    {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param point The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public PointCP rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP('C',
                (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString()
    {
        return "Stored as " + "Cartesian  (" + getX() + "," + getY() + ")";
    }
}
