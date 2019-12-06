package org.wahlzeit.model;

public class CarthesianCoordinate extends AbstractCoordinate {
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
  CarthesianCoordinate(double x, double y, double z) throws IllegalArgumentException {
    try {
      assertValidX(x);
      assertValidY(y);
      assertValidZ(z);
    } catch(ArithmeticException e) {
      throw new IllegalArgumentException("Unable to construct a new CarthesianCoordinate due to bad arguments", e);
    }    

    this.x = x;
    this.y = y;
    this.z = z;

    assertClassInvariants();
  }

  /**
   * Get the X value of this coordinate.
   * 
   * @methodtype get
   */
  public double getX() throws IllegalStateException {
    try {
      assertValidX(x);
    } catch(ArithmeticException e) {
      throw new IllegalStateException("x is invalid", e);
    }
    
    assertClassInvariants();
    return x;
  }

  /**
   * Get the Y value of this coordinate.
   * 
   * @methodtype get
   */
  public double getY() throws IllegalStateException {
    try {
      assertValidY(y);
    } catch(ArithmeticException e) {
      throw new IllegalStateException("y is invalid", e);
    }
    
    assertClassInvariants();
    return y;
  }

  /**
   * Get the Z value of this coordinate.
   * 
   * @methodtype get
   */
  public double getZ() throws IllegalStateException {
    try {
      assertValidZ(z);
    } catch(ArithmeticException e) {
      throw new IllegalStateException("z is invalid", e);
    }
    
    assertClassInvariants();
    return z;
  }

  @Override
  public CarthesianCoordinate asCarthesianCoordinate() {
    assertClassInvariants();
    return this;
  }

  @Override
  public double getCarthesianDistance(Coordinate otherCoordinate) throws IllegalArgumentException, ArithmeticException {
    assertClassInvariants();
    if (otherCoordinate == null) {
      throw new IllegalArgumentException("The other coordinate may not be null");
    }

    CarthesianCoordinate otherCarthesianCoordinate = otherCoordinate.asCarthesianCoordinate();

    double xDiff = Math.abs(x - otherCarthesianCoordinate.x);
    double yDiff = Math.abs(y - otherCarthesianCoordinate.y);
    double zDiff = Math.abs(z - otherCarthesianCoordinate.z);

    // Using "*" instead of Math.pow to increase performance.
    double xSquared = xDiff * xDiff;
    double ySquared = yDiff * yDiff;
    double zSquared = zDiff * zDiff;

    double result = Math.sqrt(xSquared + ySquared + zSquared);

    assertValidCarthesianDistance(result);

    assertClassInvariants();
    return result;
  }

  @Override
  public SphericCoordinate asSphericCoordinate() throws ArithmeticException {
    assertClassInvariants();

    // Using "*" instead of Math.pow to increase performance.
    double xSquared = x * x;
    double ySquared = y * y;
    double zSquared = z * z;

    double radius = Math.sqrt(xSquared + ySquared + zSquared);

    // Make sure we don't divide by 0 later in some really special cases.
    assert (radius != 0);

    // For the formula, see
    // https://en.wikipedia.org/wiki/List_of_common_coordinate_transformations

    double phi = Math.atan2(y, x);
    double theta = Math.acos(z / radius);

    SphericCoordinate.assertValidRadius(radius);
    SphericCoordinate.assertValidPhi(phi);
    SphericCoordinate.assertValidTheta(theta);

    SphericCoordinate result = new SphericCoordinate(radius, phi, theta);

    assertClassInvariants();
    return result;
  }

  @Override
  public double getCentralAngle(Coordinate otherCoordinate) throws IllegalArgumentException,ArithmeticException {
    assertClassInvariants();
    if (otherCoordinate == null) {
      throw new IllegalArgumentException("The other coordinate may not be null");
    }

    double distance = getCarthesianDistance(otherCoordinate);
    double result = 2 * Math.asin(distance / 2);

    assertValidCentralAngle(result);
    assertClassInvariants();
    return result;
  }

  /**
   * Are the two passed floating point numbers equal (or within a small tolerance)?
   */
  private static boolean isNearlyEqualDouble(double number1, double number2) throws IllegalArgumentException {
    if (!Double.isFinite(number1) || !Double.isFinite(number2)) {
      throw new IllegalArgumentException("The numbers should be finite");
    }

    final double EPSILON = 0.00001;

    if (Math.abs(number1 - number2) < EPSILON) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isEqual(Object obj) {
    assertClassInvariants();

    if (obj == null) {
      return false;
    }

    if (!(obj instanceof Coordinate)) {
      return false;
    }

    CarthesianCoordinate coordinateObject = ((Coordinate) obj).asCarthesianCoordinate();

    boolean result;

    if (isNearlyEqualDouble(x, coordinateObject.x) && isNearlyEqualDouble(y, coordinateObject.y)
        && isNearlyEqualDouble(z, coordinateObject.z)) {
      result = true;
    } else {
      result = false;
    }

    assertClassInvariants();
    return result;
  }

  /**
   * Round a value to have a maximum of "places" decimals.
   * @param num The number to be rounded.
   * @param places The maximum number of decimals.
   */
  private static double round(double num, int places) throws IllegalArgumentException {
    if (!Double.isFinite(num)) {
      throw new IllegalArgumentException("The number should be finite");
    }
    if (places < 0) {
      throw new IllegalArgumentException("The places should not be less than 0. But they were: " + places);
    }

    double pow = Math.pow(10, places);

    double result;

    result = num * pow;
    result = Math.round(result);
    result = result / pow;

    assert (Double.isFinite(result)) : "The result should be finite";

    return result;
  }

  @Override
  public int hashCode() {
    assertClassInvariants();
    // We use rounded values here to make sure that small differences in the
    // floating point numbers still lead to the same hashCode.

    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(round(x, 4));
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(round(y, 4));
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(round(z, 4));
    result = prime * result + (int) (temp ^ (temp >>> 32));

    assertClassInvariants();
    return result;
  }

  @Override
  public void assertClassInvariants() throws IllegalStateException {
    try {
      assertValidX(x);
      assertValidY(y);
      assertValidZ(z);
    } catch(ArithmeticException e) {
      throw new IllegalStateException("The class invariants were violated.", e);
    }    
  }

  public static final void assertValidX(double x) throws ArithmeticException {
    if (Double.isFinite(x)) {
      return;
    }
    throw new ArithmeticException("x should be finite but was infinite");
  }

  public static final void assertValidY(double y) throws ArithmeticException {
    if (Double.isFinite(y)) {
      return;
    }
    throw new ArithmeticException("y should be finite but was infinite");
  }

  public static final void assertValidZ(double z) throws ArithmeticException {
    if (Double.isFinite(z)) {
      return;
    }
    throw new ArithmeticException("z should be finite but was infinite");
  }
}
