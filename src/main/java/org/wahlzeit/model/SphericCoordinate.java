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
  SphericCoordinate(double radius, double phi, double theta) {
    assertValidRadius(radius);
    assertValidPhi(phi);
    assertValidTheta(theta);

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
  public double getRadius() {
    assertValidRadius(radius);
    assertClassInvariants();
    return radius;
  }

  /**
   * Get the Phi value of this coordinate in radians.
   * 
   * @methodtype get
   */
  public double getPhi() {
    assertValidPhi(phi);
    assertClassInvariants();
    return phi;
  }

  /**
   * Get the Theta value of this coordinate in radians.
   * 
   * @methodtype get
   */
  public double getTheta() {
    assertValidTheta(theta);
    assertClassInvariants();
    return theta;
  }

  @Override
  public CarthesianCoordinate asCarthesianCoordinate() {
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
  public void assertClassInvariants() {
    assertValidRadius(radius);
    assertValidPhi(phi);
    assertValidTheta(theta);
  }

  public static final void assertValidTheta(double theta) {
    boolean isValid = Double.isFinite(theta) && theta >= 0 && theta <= Math.PI;
    assert (isValid) : "The given theta (" + theta + ") is not valid";
  }

  public static final void assertValidPhi(double phi) {
    boolean isValid = Double.isFinite(phi) && phi >= -Math.PI && phi <= Math.PI;
    assert (isValid) : "The given phi (" + phi + ") is not valid";
  }

  public static final void assertValidRadius(double radius) {
    boolean isValid = Double.isFinite(radius) && radius >= 0;
    assert (isValid) : "The given radius (" + radius + ") is not valid";
  }
}
