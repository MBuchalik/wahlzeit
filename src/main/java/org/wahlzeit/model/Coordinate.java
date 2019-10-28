package org.wahlzeit.model;

/**
 * The Coordinate class represents a carthesian coordinate in 3-dimensional space.
 */
public class Coordinate {
  private final double x;
  private final double y;
  private final double z;

  /**
   * @param x The X value (carthesian coordinate) to be set for this Coordinate.
   * @param y The Y value (carthesian coordinate) to be set for this Coordinate.
   * @param z The Z value (carthesian coordinate) to be set for this Coordinate.
   */
  Coordinate(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Get the X value of this coordinate.
   */
  public double getX() {
    return x;
  }

  /**
   * Get the Y value of this coordinate.
   */
  public double getY() {
    return y;
  }

  /**
   * Get the Z value of this coordinate.
   */
  public double getZ() {
    return z;
  }

  /**
   * Get the distance between this coordinate and another one.
   *
   * Please note that this method computes the "direct" distance.
   * This means that it calculates the distance in a 3D space and not on a globe or similar.
   * @param otherCoordinate The other coordinate the distance should be computed with.
   */
  public double getDistance(Coordinate otherCoordinate) {
    double result = 0;

    double xDiff = Math.abs(x - otherCoordinate.x);
    double yDiff = Math.abs(y - otherCoordinate.y);
    double zDiff = Math.abs(z - otherCoordinate.z);

    // Using "*" instead of Math.pow to increase performance.
    double xSquared = xDiff * xDiff;
    double ySquared = yDiff * yDiff;
    double zSquared = zDiff * zDiff;

    result = Math.sqrt(xSquared + ySquared + zSquared);

    return result;
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

  /**
   * Is some object equal to this one?
   * 
   * @param obj The object to compare this one against.
   */
  public boolean isEqual(Object obj) {
    if (obj == null) {
      return false;
    }

    if (!(obj instanceof Coordinate)) {
      return false;
    }

    Coordinate coordinateObject = (Coordinate) obj;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(x);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(y);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(z);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}
