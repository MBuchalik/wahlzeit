package org.wahlzeit.model.palace;

import java.util.HashSet;
import java.util.Set;

public class PalaceType {
  protected PalaceType superType = null;
  protected Set<PalaceType> subTypes = new HashSet<PalaceType>();

  public PalaceType getSuperType() {
    return superType;
  }

  public void setSuperType(PalaceType superType) {
    this.superType = superType;
  }

  public void addSubType(PalaceType type) {
    if (type == null) {
      throw new IllegalArgumentException("The type may not be null");
    }

    type.setSuperType(this);
    subTypes.add(type);
  }

  /**
   * This method should probably be called "isSubtypeOf".
   * It checks if this one is a sub type of the one passed in the argument.
   * So: subtype.isSubtype(superType) returns true.
   */
  public boolean isSubtype(PalaceType type) {
    if (type == null) {
      throw new IllegalArgumentException("The passed type is null");
    }

    if (this.superType == null) {
      return false;
    }

    if (this.superType == type) {
      return true;
    }

    if (this.superType.isSubtype(type)) {
      return true;
    }

    return false;
  }

  public Palace createPalaceInstance() {
    return new Palace(this);
  }
}
