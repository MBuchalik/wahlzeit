package org.wahlzeit.model;

import org.junit.Test;

public class CoordinateTest {
  /**
   * Are the two passed floating point numbers equal (or within a small tolerance)?
   */
  private boolean isNearlyEqual(double number1, double number2) {
    final Double EPSILON = 0.00001;

    if (Math.abs(number1 - number2) < EPSILON) {
      return true;
    }
    return false;
  }

  @Test
  public void testIsEqual() {
    Coordinate coordinate1 = new Coordinate(1, 2, 3);
    Coordinate similarToCoordinate1 = new Coordinate(1, 2, 3);
    Coordinate coordinate2 = new Coordinate(2, 3, 4);

    assert(coordinate1.isEqual(coordinate1));
    assert(coordinate1.isEqual(similarToCoordinate1));
    assert(!coordinate1.isEqual(coordinate2));
    assert(!coordinate1.isEqual(null));
  }

  @Test
  public void testGetDistance() {    
    Coordinate coordinate1 = new Coordinate(1, 3, 4);
    Coordinate coordinate2 = new Coordinate(2, 3, 4);
    Coordinate coordinate3 = new Coordinate(-1, 3, 4);
    Coordinate coordinate4 = new Coordinate(1, 0, 0);

    assert(isNearlyEqual(coordinate1.getDistance(coordinate1), 0));
    assert(isNearlyEqual(coordinate1.getDistance(coordinate2), 1));
    assert(isNearlyEqual(coordinate1.getDistance(coordinate3), 2));
    assert(isNearlyEqual(coordinate1.getDistance(coordinate4), 5));
  }
}
