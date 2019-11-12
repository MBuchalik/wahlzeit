package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({
  AccessRightsTest.class,
  CarthesianCoordinateTest.class,
  FlagReasonTest.class,
  GenderTest.class,
  GuestTest.class,
  PalacePhotoFactoryTest.class,
  PalacePhotoManagerTest.class,
  PhotoFilterTest.class,
  SphericCoordinateTest.class,
  TagsTest.class,
  UserStatusTest.class,
  ValueTest.class
})

public class ModelTestSuite {}
