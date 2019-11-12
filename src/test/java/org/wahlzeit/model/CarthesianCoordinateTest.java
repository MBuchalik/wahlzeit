package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarthesianCoordinateTest {
  /**
   * Are the two passed floating point numbers equal (or within a small tolerance)?
   */
  private boolean isNearlyEqual(double number1, double number2) {
    final double EPSILON = 0.00001;

    if (Math.abs(number1 - number2) < EPSILON) {
      return true;
    }
    return false;
  }

  @Test
  public void testIsEqual() {
    CarthesianCoordinate coordinate1 = new CarthesianCoordinate(1, 2, 3);
    CarthesianCoordinate similarToCoordinate1 = new CarthesianCoordinate(1, 2, 3);
    CarthesianCoordinate coordinate2 = new CarthesianCoordinate(2, 3, 4);

    assert (coordinate1.isEqual(coordinate1));
    assert (coordinate1.isEqual(similarToCoordinate1));
    assert (!coordinate1.isEqual(coordinate2));
    assert (!coordinate1.isEqual(null));
  }

  @Test
  public void testIsEqualToSphericCoordinate() {
    CarthesianCoordinate carthesianCoordinate = new CarthesianCoordinate(1, 2, 3);
    SphericCoordinate sphericCoordinate = carthesianCoordinate.asSphericCoordinate();

    SphericCoordinate otherSphericCoordinate = new SphericCoordinate(1, 1, 1);

    assert (carthesianCoordinate.isEqual(sphericCoordinate));
    assert (!carthesianCoordinate.isEqual(otherSphericCoordinate));
  }

  @Test
  public void testHashCode() {
    CarthesianCoordinate carthesianCoordinate1 = new CarthesianCoordinate(1, 2, 3);
    CarthesianCoordinate similarToCoordinate1 = new CarthesianCoordinate(1, 2, 3);
    CarthesianCoordinate carthesianCoordinate2 = new CarthesianCoordinate(2, 3, 4);

    assert (carthesianCoordinate1.hashCode() == similarToCoordinate1.hashCode());
    assert (carthesianCoordinate1.hashCode() != carthesianCoordinate2.hashCode());
  }

  @Test
  public void testHashCodeWithSphericCoordinate() {
    CarthesianCoordinate carthesianCoordinate = new CarthesianCoordinate(1, 2, 3);
    SphericCoordinate sphericCoordinate = carthesianCoordinate.asSphericCoordinate();

    SphericCoordinate otherSphericCoordinate = new SphericCoordinate(1, 1, 1);

    assert (carthesianCoordinate.hashCode() == sphericCoordinate.hashCode());
    assert (carthesianCoordinate.hashCode() != otherSphericCoordinate.hashCode());
  }

  @Test
  public void testGetCarthesianDistance() {
    CarthesianCoordinate coordinate1 = new CarthesianCoordinate(1, 3, 4);
    CarthesianCoordinate coordinate2 = new CarthesianCoordinate(2, 3, 4);
    CarthesianCoordinate coordinate3 = new CarthesianCoordinate(-1, 3, 4);
    CarthesianCoordinate coordinate4 = new CarthesianCoordinate(1, 0, 0);

    assert (isNearlyEqual(coordinate1.getCarthesianDistance(coordinate1), 0));
    assert (isNearlyEqual(coordinate1.getCarthesianDistance(coordinate2), 1));
    assert (isNearlyEqual(coordinate1.getCarthesianDistance(coordinate3), 2));
    assert (isNearlyEqual(coordinate1.getCarthesianDistance(coordinate4), 5));
  }

  @Test
  public void testAsSphericCoordinate() {
    CarthesianCoordinate coordinate = new CarthesianCoordinate(1, 2, 3);

    SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();

    // Retrieved these values using an online calculator at
    // https://keisan.casio.com/exec/system/1359533867
    // Please note that the calculator, for some reason, swaps phi and theta.
    double expectedRadius = 3.7416573867739;
    double expectedPhi = 1.1071487177941;
    double expectedTheta = 0.64052231267942;

    double retrievedRadius = sphericCoordinate.getRadius();
    double retrievedPhi = sphericCoordinate.getPhi();
    double retrievedTheta = sphericCoordinate.getTheta();

    assert (sphericCoordinate instanceof SphericCoordinate);

    assertTrue("Radius should be " + expectedRadius + ", but is " + retrievedRadius,
        isNearlyEqual(retrievedRadius, expectedRadius));
    assertTrue("Phi should be " + expectedPhi + ", but is " + retrievedPhi, isNearlyEqual(retrievedPhi, expectedPhi));
    assertTrue("Theta should be " + expectedTheta + ", but is " + retrievedTheta,
        isNearlyEqual(retrievedTheta, expectedTheta));
  }
}
