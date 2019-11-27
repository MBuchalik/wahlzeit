package org.wahlzeit.model;

public interface Coordinate {
  /**
   * Convert this Coordinate to a Carthesian Coordinate.
   * 
   * @methodtype conversion
   */
  public CarthesianCoordinate asCarthesianCoordinate();

  /**
   * Get the carthesian distance between this coordinate and another one.
   *
   * Please note that this method computes the "direct" distance.
   * This means that it calculates the distance in a 3D space and not on a globe or similar.
   *
   * @param otherCoordinate The other coordinate the distance should be computed with.
   */
  public double getCarthesianDistance(Coordinate otherCoordinate);

  /**
  * Convert this Coordinate to a Spheric Coordinate.
  * 
  * @methodtype conversion
  */
  public SphericCoordinate asSphericCoordinate();

  /**
   * Calculate the Central Angle, see https://en.wikipedia.org/wiki/Great-circle_distance
   * @param otherCoordinate The other coordinate the Central Angle should be computed with.
   */
  public double getCentralAngle(Coordinate otherCoordinate);

  /**
   * Is the passed object equal to this one?
   * Please note that this method also returns true if the provided object is an instance of another implementation of the Coordinate interface but points to the same geographic location.
   * @param obj The object to compare this one to.
   */
  public boolean isEqual(Object obj);

  /**
   * Check whether the class invariants are fulfilled.
   */
  public void assertClassInvariants();
}
