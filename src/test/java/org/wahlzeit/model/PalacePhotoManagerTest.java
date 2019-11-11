package org.wahlzeit.model;

import java.io.IOException;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PalacePhotoManagerTest {
  private final LocalServiceTestHelper helper =
      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

  private final PhotoManager managerInstance = PalacePhotoManager.getInstance();
      
  @Before
  public void setUp() {
    helper.setUp();
  }

  @After
  public void tearDown() {
    helper.tearDown();
  }

  @Test
  public void testGetInstance() {
    PhotoManager instance = PalacePhotoManager.getInstance();

    assert(instance instanceof PalacePhotoManager);
  }

  @Test
  public void testHasPhoto() throws IOException {
    PhotoId id = PhotoId.getNextId();
    PhotoId notUsedId = PhotoId.getNextId();

    managerInstance.addPhoto(new PalacePhoto(id));

    assert(managerInstance.hasPhoto(id));
    assert(!managerInstance.hasPhoto(notUsedId));
  }

  @Test
  public void testGetPhoto() throws IOException {
    PhotoId id = PhotoId.getNextId();
    PalacePhoto photo = new PalacePhoto(id);

    managerInstance.addPhoto(photo);

    Photo retrievedPhoto = managerInstance.getPhoto(id);
    assert(photo == retrievedPhoto);
  }
}
