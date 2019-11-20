package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
  @Override
  public double getCarthesianDistance(Coordinate otherCoordinate) {
    CarthesianCoordinate myCarthesianCoordinate = this.asCarthesianCoordinate();
    return myCarthesianCoordinate.getCarthesianDistance(otherCoordinate);
  }

  @Override
  public SphericCoordinate asSphericCoordinate() {
    CarthesianCoordinate myCarthesianCoordinate = this.asCarthesianCoordinate();
    return myCarthesianCoordinate.asSphericCoordinate();
  }

  @Override
  public double getCentralAngle(Coordinate otherCoordinate) {
    CarthesianCoordinate myCarthesianCoordinate = this.asCarthesianCoordinate();
    return myCarthesianCoordinate.getCentralAngle(otherCoordinate);
  }

  @Override
  public boolean isEqual(Object obj) {
    CarthesianCoordinate myCarthesianCoordinate = this.asCarthesianCoordinate();
    return myCarthesianCoordinate.isEqual(obj);
  }

  @Override
  public boolean equals(Object obj) {
    return isEqual(obj);
  }

  @Override
  public int hashCode() {
    CarthesianCoordinate myCarthesianCoordinate = this.asCarthesianCoordinate();
    return myCarthesianCoordinate.hashCode();
  }
}
