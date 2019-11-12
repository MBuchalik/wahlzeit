package org.wahlzeit.model;

/**
 * The Location class represents a geographic location.
 */
public class Location {
  private CarthesianCoordinate coordinate;

  /**
   * @param coordinate The Coordinate to be set for this Location.
   */
  Location(CarthesianCoordinate coordinate) {
    this.coordinate = coordinate;
  }

  /**
   * Get the Coordinate associated with this Location.
   */
  public CarthesianCoordinate getCoordinate() {
    return coordinate;
  }
}
