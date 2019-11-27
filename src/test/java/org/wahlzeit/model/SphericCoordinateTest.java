package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SphericCoordinateTest {
  /**
   * Are the two passed floating point numbers equal (or within a small
   * tolerance)?
   */
  private boolean isNearlyEqual(double number1, double number2) {
    final double EPSILON = 0.00001;

    if (Math.abs(number1 - number2) < EPSILON) {
      return true;
    }
    return false;
  }

  @Test
  public void testIsEqualToCarthesianCoordinate() {
    SphericCoordinate sphericCoordinate = new SphericCoordinate(1, 2, 3);
    CarthesianCoordinate carthesianCoordinate = sphericCoordinate.asCarthesianCoordinate();

    CarthesianCoordinate otherCarthesianCoordinate = new CarthesianCoordinate(1, 1, 1);

    assert (sphericCoordinate.isEqual(carthesianCoordinate));
    assert (!sphericCoordinate.isEqual(otherCarthesianCoordinate));
  }

  @Test
  public void testHashCode() {
    SphericCoordinate sphericCoordinate1 = new SphericCoordinate(1, 2, 3);
    SphericCoordinate similarToCoordinate1 = new SphericCoordinate(1, 2, 3);
    SphericCoordinate sphericCoordinate2 = new SphericCoordinate(2, 3, 1);

    assert (sphericCoordinate1.hashCode() == similarToCoordinate1.hashCode());
    assert (sphericCoordinate1.hashCode() != sphericCoordinate2.hashCode());
  }

  @Test
  public void testHashCodeWithCarthesianCoordinate() {
    SphericCoordinate sphericCoordinate = new SphericCoordinate(1, 2, 3);
    CarthesianCoordinate carthesianCoordinate = sphericCoordinate.asCarthesianCoordinate();

    CarthesianCoordinate otherCarthesianCoordinate = new CarthesianCoordinate(1, 1, 1);

    assert (sphericCoordinate.hashCode() == carthesianCoordinate.hashCode());
    assert (sphericCoordinate.hashCode() != otherCarthesianCoordinate.hashCode());
  }

  @Test
  public void testAsCarthesianCoordinate() {
    SphericCoordinate coordinate = new SphericCoordinate(10, 2, 3);

    CarthesianCoordinate carthesianCoordinate = coordinate.asCarthesianCoordinate();

    // Retrieved these values using an online calculator at
    // https://keisan.casio.com/exec/system/1359534351
    double expectedX = -0.58726644927621;
    double expectedY = 1.2832006020246;
    double expectedZ = -9.8999249660045;

    double retrievedX = carthesianCoordinate.getX();
    double retrievedY = carthesianCoordinate.getY();
    double retrievedZ = carthesianCoordinate.getZ();

    assert (carthesianCoordinate instanceof CarthesianCoordinate);

    assertTrue("X should be " + expectedX + ", but is " + retrievedX, isNearlyEqual(retrievedX, expectedX));
    assertTrue("Y should be " + expectedY + ", but is " + retrievedY, isNearlyEqual(retrievedY, expectedY));
    assertTrue("Z should be " + expectedZ + ", but is " + retrievedZ, isNearlyEqual(retrievedZ, expectedZ));
  }
}
