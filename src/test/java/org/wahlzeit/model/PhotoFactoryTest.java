package org.wahlzeit.model;

import org.junit.Test;

public class PhotoFactoryTest {
  @Test
  public void testGetInstance() {
    // At the moment, getInstance should return the PalacePhotoFactory and not the generic PhotoFactory.
    PhotoFactory instance = PhotoFactory.getInstance();

    assert(instance instanceof PalacePhotoFactory);
  }
}
