package org.wahlzeit.model;

public class CarthesianCoordinate implements Coordinate {
  private final double x;
  private final double y;
  private final double z;

  /**
   * @param x The X value to be set for this Coordinate.
   * @param y The Y value to be set for this Coordinate.
   * @param z The Z value to be set for this Coordinate.
   * 
   * @methodtype constructor
   */
  CarthesianCoordinate(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Get the X value of this coordinate.
   * 
   * @methodtype get
   */
  public double getX() {
    return x;
  }

  /**
   * Get the Y value of this coordinate.
   * 
   * @methodtype get
   */
  public double getY() {
    return y;
  }

  /**
   * Get the Z value of this coordinate.
   * 
   * @methodtype get
   */
  public double getZ() {
    return z;
  }
  
  @Override
  public CarthesianCoordinate asCarthesianCoordinate() {
    return this;
  }

  @Override
  public double getCarthesianDistance(Coordinate otherCoordinate) {
    double result = 0;

    CarthesianCoordinate otherCarthesianCoordinate = otherCoordinate.asCarthesianCoordinate();

    double xDiff = Math.abs(x - otherCarthesianCoordinate.x);
    double yDiff = Math.abs(y - otherCarthesianCoordinate.y);
    double zDiff = Math.abs(z - otherCarthesianCoordinate.z);

    // Using "*" instead of Math.pow to increase performance.
    double xSquared = xDiff * xDiff;
    double ySquared = yDiff * yDiff;
    double zSquared = zDiff * zDiff;

    result = Math.sqrt(xSquared + ySquared + zSquared);

    return result;
  }

  @Override
  public SphericCoordinate asSphericCoordinate() {
    // Using "*" instead of Math.pow to increase performance.
    double xSquared = x * x;
    double ySquared = y * y;
    double zSquared = z * z;

    double radius = Math.sqrt(xSquared + ySquared + zSquared);

    // Make sure we don't divide by 0 later in some really special cases.
    assert(radius != 0);

    // For the formula, see https://en.wikipedia.org/wiki/List_of_common_coordinate_transformations

    double phi = Math.atan2(y, x);
    double theta = Math.acos(z / radius);
    
    return new SphericCoordinate(radius, phi, theta);
  }

  @Override
  public double getCentralAngle(Coordinate otherCoordinate) {
    double distance = getCarthesianDistance(otherCoordinate);

    return 2 * Math.asin(distance / 2);
  }

  /**
   * Are the two passed floating point numbers equal (or within a small tolerance)?
   */
  private boolean isNearlyEqualDouble(double number1, double number2) {
    final double EPSILON = 0.00001;

    if (Math.abs(number1 - number2) < EPSILON) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isEqual(Object obj) {
    if (obj == null) {
      return false;
    }

    if (!(obj instanceof Coordinate)) {
      return false;
    }

    CarthesianCoordinate coordinateObject = ((Coordinate) obj).asCarthesianCoordinate();

    if (
      isNearlyEqualDouble(x, coordinateObject.x) && 
      isNearlyEqualDouble(y, coordinateObject.y) && 
      isNearlyEqualDouble(z, coordinateObject.z)
    ) {
      return true;
    }
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    return isEqual(obj);
  }

  /**
   * Round a value to have a maximum of "places" decimals.
   * @param num The number to be rounded.
   * @param places The maximum number of decimals.
   */
  private double round(double num, int places) {
    double pow = Math.pow(10, places);

    double result;

    result = num * pow;
    result = Math.round(result);
    result = result / pow;

    return result;
  }

  @Override
  public int hashCode() {
    // We use rounded values here to make sure that small differences in the floating point numbers still lead to the same hashCode.

    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(round(x, 4));
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(round(y, 4));
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(round(z, 4));
    result = prime * result + (int) (temp ^ (temp >>> 32));

    return result;
  }
}
