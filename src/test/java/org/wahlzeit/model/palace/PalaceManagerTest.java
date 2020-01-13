package org.wahlzeit.model.palace;

import org.junit.Test;

public class PalaceManagerTest {
  @Test
  public void testGetPalaceType() {
    PalaceManager manager = PalaceManager.getInstance();

    
    PalaceType firstType = manager.getPalaceType(PalaceManager.validTypeNames[0]);
    PalaceType similarToFirstType = manager.getPalaceType(PalaceManager.validTypeNames[0]);
    PalaceType differentType = manager.getPalaceType(PalaceManager.validTypeNames[1]);

    assert (firstType == similarToFirstType);
    assert (firstType != differentType);
  }
}
