package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
  private final double radius;
  // Phi is stored in radians.
  private final double phi;
  // Phi is stored in radians.
  private final double theta;

  /**
   * @param radius The radius to be used.
   * @param phi The Phi value in radians.
   * @param theta The Theta value in radians.
   */
  SphericCoordinate(double radius, double phi, double theta) {
    this.radius = radius;
    this.phi = phi;
    this.theta = theta;
  }

  /**
   * Get the radius of this coordinate.
   * 
   * @methodtype get
   */
  public double getRadius() {
    return radius;
  }

  /**
   * Get the Phi value of this coordinate in radians.
   * 
   * @methodtype get
   */
  public double getPhi() {
    return phi;
  }

  /**
   * Get the Theta value of this coordinate in radians.
   * 
   * @methodtype get
   */
  public double getTheta() {
    return theta;
  }

  @Override
  public CarthesianCoordinate asCarthesianCoordinate() {
    // For the formula, see https://en.wikipedia.org/wiki/List_of_common_coordinate_transformations

    double x = radius * Math.sin(theta) * Math.cos(phi);
    double y = radius * Math.sin(theta) * Math.sin(phi);
    double z = radius * Math.cos(theta);
    
    return new CarthesianCoordinate(x, y, z);
  }

  @Override
  public SphericCoordinate asSphericCoordinate() {
    return this;
  }
}
