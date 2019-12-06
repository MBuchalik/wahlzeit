package org.wahlzeit.model;

/**
 * The Location class represents a geographic location.
 */
public class Location {
  private Coordinate coordinate;

  /**
   * @param coordinate The Coordinate to be set for this Location.
   */
  Location(Coordinate coordinate) throws IllegalArgumentException {
    if (coordinate == null) {
      throw new IllegalArgumentException("The coordinate may not be null");
    }

    this.coordinate = coordinate;
  }

  /**
   * Get the Coordinate associated with this Location.
   */
  public Coordinate getCoordinate() throws IllegalStateException {
    if (coordinate == null) {
      throw new IllegalStateException("The coordinate associated with this location is null");
    }

    return coordinate;
  }
}
