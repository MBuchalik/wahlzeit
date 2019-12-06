package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
  private final double radius;
  // Phi is stored in radians.
  private final double phi;
  // Phi is stored in radians.
  private final double theta;

  /**
   * @param radius The radius to be used.
   * @param phi The Phi value in radians. It should be in the range of -Pi to Pi.
   * @param theta The Theta value in radians. It should be in the range of 0 to Pi.
   */
  SphericCoordinate(double radius, double phi, double theta) throws IllegalArgumentException {
    try {
      assertValidRadius(radius);
      assertValidPhi(phi);
      assertValidTheta(theta);
    } catch(ArithmeticException e) {
      throw new IllegalArgumentException("Unable to construct a new SphericCoordinate due to bad arguments", e);
    }    

    this.radius = radius;
    this.phi = phi;
    this.theta = theta;

    assertClassInvariants();
  }

  /**
   * Get the radius of this coordinate.
   * 
   * @methodtype get
   */
  public double getRadius() throws IllegalStateException {
    try {
      assertValidRadius(radius);
    } catch(ArithmeticException e) {
      throw new IllegalStateException("radius is invalid", e);
    }

    assertClassInvariants();
    return radius;
  }

  /**
   * Get the Phi value of this coordinate in radians.
   * 
   * @methodtype get
   */
  public double getPhi() throws IllegalStateException {
    try {
      assertValidPhi(phi);
    } catch(ArithmeticException e) {
      throw new IllegalStateException("phi is invalid", e);
    }
    
    assertClassInvariants();
    return phi;
  }

  /**
   * Get the Theta value of this coordinate in radians.
   * 
   * @methodtype get
   */
  public double getTheta() throws IllegalStateException {
    try {
      assertValidTheta(theta);
    } catch(ArithmeticException e) {
      throw new IllegalStateException("theta is invalid", e);
    }

    assertClassInvariants();
    return theta;
  }

  @Override
  public CarthesianCoordinate asCarthesianCoordinate() throws ArithmeticException {
    assertClassInvariants();

    // For the formula, see
    // https://en.wikipedia.org/wiki/List_of_common_coordinate_transformations

    double x = radius * Math.sin(theta) * Math.cos(phi);
    double y = radius * Math.sin(theta) * Math.sin(phi);
    double z = radius * Math.cos(theta);

    CarthesianCoordinate.assertValidX(x);
    CarthesianCoordinate.assertValidY(y);
    CarthesianCoordinate.assertValidZ(z);

    CarthesianCoordinate result = new CarthesianCoordinate(x, y, z);

    assertClassInvariants();
    return result;
  }

  @Override
  public SphericCoordinate asSphericCoordinate() {
    assertClassInvariants();
    return this;
  }

  @Override
  public void assertClassInvariants() throws IllegalStateException {
    try {
      assertValidRadius(radius);
      assertValidPhi(phi);
      assertValidTheta(theta);
    } catch(ArithmeticException e) {
      throw new IllegalStateException("The class invariants were violated.", e);
    }    
  }

  public static final void assertValidTheta(double theta) throws ArithmeticException {
    boolean isValid = Double.isFinite(theta) && theta >= 0 && theta <= Math.PI;
    if (isValid) {
      return;
    }
    throw new ArithmeticException("The given theta (" + theta + ") is not valid");
  }

  public static final void assertValidPhi(double phi) throws ArithmeticException {
    boolean isValid = Double.isFinite(phi) && phi >= -Math.PI && phi <= Math.PI;
    if (isValid) {
      return;
    }
    throw new ArithmeticException("The given phi (" + phi + ") is not valid");
  }

  public static final void assertValidRadius(double radius) throws ArithmeticException {
    boolean isValid = Double.isFinite(radius) && radius >= 0;
    if (isValid) {
      return;
    }
    throw new ArithmeticException("The given radius (" + radius + ") is not valid");
  }
}
