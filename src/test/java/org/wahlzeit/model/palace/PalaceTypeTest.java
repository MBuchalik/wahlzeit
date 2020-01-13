package org.wahlzeit.model.palace;

import org.junit.Test;

public class PalaceTypeTest {
  @Test
  public void testAddSubtype() {
    PalaceType superType = new PalaceType();
    PalaceType subType = new PalaceType();

    superType.addSubType(subType);

    assert (subType.getSuperType() == superType);
    assert (superType.subTypes.contains(subType));
  }

  @Test
  public void testIsSubtype() {
    PalaceType superType = new PalaceType();
    PalaceType subType = new PalaceType();

    superType.addSubType(subType);

    assert (subType.isSubtype(superType));
  }
}
