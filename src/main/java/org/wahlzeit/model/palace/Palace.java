package org.wahlzeit.model.palace;

import org.wahlzeit.model.Location;

public class Palace {
  private final PalaceType type;

  // The place where this palace is located.
  private Location location;

  Palace(PalaceType type) {
    this.type = type;
  }

  public PalaceType getType() {
    return this.type;
  }

  public void setLocation(Location location) {
    if (location == null) {
      throw new IllegalArgumentException("The Location may not be set to null");
    }

    this.location = location;
  }

  public Location getLocation() {
    return this.location;
  }
}
