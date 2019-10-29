package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.model.persistence.ModelPersistenceTestSuite;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.services.mailing.ServicesMailingTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)

@SuiteClasses({
  HandlersTestSuite.class,
  ModelTestSuite.class,
  ModelPersistenceTestSuite.class,
  ServicesTestSuite.class,
  ServicesMailingTestSuite.class,
  UtilsTestSuite.class
})

public class AllTests {}
