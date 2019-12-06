package org.wahlzeit.model;

public class PalacePhotoFactory extends PhotoFactory {  
  @Override
  public PalacePhoto createPhoto() {
		return new PalacePhoto();
  }
  
  @Override
  public PalacePhoto createPhoto(PhotoId id) throws IllegalArgumentException {
    if (id == null) {
			throw new IllegalArgumentException("The Photo ID may not be null");
    }

		return new PalacePhoto(id);
  }
}
