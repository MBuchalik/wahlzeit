package org.wahlzeit.model;

public class PalacePhotoFilter extends PhotoFilter {
  @Override
  protected PhotoManager getPhotoManagerInstance() {
    return PalacePhotoManager.getInstance();
  }
}
