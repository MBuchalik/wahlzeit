package org.wahlzeit.model;

/**
 * The Location class represents a geographic location.
 */
public class Location {
  private Coordinate coordinate;

  /**
   * @param coordinate The Coordinate to be set for this Location.
   */
  Location(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  /**
   * Get the Coordinate associated with this Location.
   */
  public Coordinate getCoordinate() {
    return coordinate;
  }
}
