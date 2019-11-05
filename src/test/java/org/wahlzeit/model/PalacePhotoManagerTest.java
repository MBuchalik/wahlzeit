package org.wahlzeit.model;

import org.junit.Test;

public class PalacePhotoManagerTest {
  @Test
  public void testGetInstance() {
    PhotoManager instance = PalacePhotoManager.getInstance();

    assert(instance instanceof PalacePhotoManager);
  }
}
