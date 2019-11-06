package org.wahlzeit.model;

import org.junit.Test;

public class PalacePhotoFactoryTest {
  @Test
  public void testGetInstance() {
    PhotoFactory instance = PalacePhotoFactory.getInstance();

    assert(instance instanceof PalacePhotoFactory);
  }

  @Test
  public void testCreatePhoto() {
    PhotoFactory instance = PalacePhotoFactory.getInstance();

    Photo photo = instance.createPhoto();

    assert(photo instanceof PalacePhoto);
  }

  @Test
  public void testCreatePhotoFilter() throws Exception {
    PhotoFactory instance = PalacePhotoFactory.getInstance();

    PhotoFilter filter = instance.createPhotoFilter();

    assert(filter instanceof PalacePhotoFilter);
  }
}
