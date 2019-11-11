package org.wahlzeit.model;

import org.junit.Test;

public class PhotoManagerTest {
  @Test
  public void testGetInstance() {
    // At the moment, getInstance should return the PalacePhotoManager and not the generic PhotoManager.
    PhotoManager instance = PhotoManager.getInstance();

    assert(instance instanceof PalacePhotoManager);
  }
}
