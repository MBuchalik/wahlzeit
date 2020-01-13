package org.wahlzeit.model.palace;

import java.util.HashMap;

public class PalaceManager {
  // OK, this is a really poor example of how you could use types here...
  public final static String[] validTypeNames = { "fancy", "not-so-fancy" };

  private static PalaceManager instance = new PalaceManager();

  private final HashMap<String, PalaceType> typeMap = new HashMap<String, PalaceType>();

  private PalaceManager() {
  }

  public static PalaceManager getInstance() {
    return instance;
  }

  public Palace createPalace(String typeName) {
    assertIsValidTypeName(typeName);

    PalaceType type = getPalaceType(typeName);

    Palace result = type.createPalaceInstance();

    return result;
  }

  private synchronized PalaceType getPalaceType(String typeName) {
    PalaceType result = this.typeMap.get(typeName);
    if (result == null) {
      result = new PalaceType();
      this.typeMap.put(typeName, result);
    }

    return result;
  }

  public static void assertIsValidTypeName(String typeName) throws IllegalArgumentException {
    for (String name : validTypeNames) {
      if (name.equals(typeName)) {
        return;
      }
    }

    throw new IllegalArgumentException("The type name '" + typeName + "' is not valid.");
  }
}
