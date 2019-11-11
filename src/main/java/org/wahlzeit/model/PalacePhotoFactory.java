package org.wahlzeit.model;

public class PalacePhotoFactory extends PhotoFactory {  
  @Override
  public PalacePhoto createPhoto() {
		return new PalacePhoto();
  }
  
  @Override
  public PalacePhoto createPhoto(PhotoId id) {
		return new PalacePhoto(id);
  }
}
