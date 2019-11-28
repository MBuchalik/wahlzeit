package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
  @Override
  public double getCarthesianDistance(Coordinate otherCoordinate) {
    assertClassInvariants();
    assert (otherCoordinate != null) : "The other coordinate may not be null.";

    CarthesianCoordinate myCarthesianCoordinate = this.asCarthesianCoordinate();
    double result = myCarthesianCoordinate.getCarthesianDistance(otherCoordinate);

    assertValidCarthesianDistance(result);
    assertClassInvariants();
    return result;
  }

  @Override
  public SphericCoordinate asSphericCoordinate() {
    assertClassInvariants();

    CarthesianCoordinate myCarthesianCoordinate = this.asCarthesianCoordinate();
    SphericCoordinate result = myCarthesianCoordinate.asSphericCoordinate();

    assert (result != null) : "The result was null";
    assertClassInvariants();
    return result;
  }

  @Override
  public double getCentralAngle(Coordinate otherCoordinate) {
    assertClassInvariants();
    assert (otherCoordinate != null) : "The other coordinate may not be null.";

    CarthesianCoordinate myCarthesianCoordinate = this.asCarthesianCoordinate();
    double result = myCarthesianCoordinate.getCentralAngle(otherCoordinate);

    assertValidCentralAngle(result);
    assertClassInvariants();
    return result;
  }

  @Override
  public boolean isEqual(Object obj) {
    assertClassInvariants();

    CarthesianCoordinate myCarthesianCoordinate = this.asCarthesianCoordinate();
    boolean result = myCarthesianCoordinate.isEqual(obj);

    assertClassInvariants();
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    assertClassInvariants();

    boolean result = isEqual(obj);

    assertClassInvariants();
    return result;
  }

  @Override
  public int hashCode() {
    assertClassInvariants();

    CarthesianCoordinate myCarthesianCoordinate = this.asCarthesianCoordinate();
    int result = myCarthesianCoordinate.hashCode();

    assertClassInvariants();
    return result;
  }

  public static final void assertValidCarthesianDistance(double distance) {
    boolean isValid = Double.isFinite(distance) && distance >= 0;
    assert (isValid) : "The Carthesian Distance should not be less than 0.";
  }

  public final void assertValidCentralAngle(double angle) {
    boolean isValid = Double.isFinite(angle) && angle >= -Math.PI && angle <= Math.PI;
    assert (isValid) : "The Central Angle should not be less than 0.";
  }
}
