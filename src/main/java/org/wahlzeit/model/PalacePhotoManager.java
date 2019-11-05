package org.wahlzeit.model;

import com.google.appengine.api.images.Image;

public class PalacePhotoManager extends PhotoManager {
  protected static final PalacePhotoManager instance = new PalacePhotoManager();

  public static PalacePhotoManager getInstance() {
    return instance;
  }

  @Override
  public Photo getPhoto(PhotoId id) {
    return instance.getPhotoFromId(id);
  }

  @Override
  public Photo getPhotoFromId(PhotoId id) {
    if (id == null) {
      return null;
    }
    
    Photo result = doGetPhotoFromId(id);

    if (result == null) {
      result = PalacePhotoFactory.getInstance().loadPhoto(id);
      if (result != null) {
        doAddPhoto(result);
      }
    }

    return result;
  }

  @Override
  public Photo createPhoto(String filename, Image uploadedImage) throws Exception {
    PhotoId id = PhotoId.getNextId();
    Photo result = PalacePhotoUtil.createPhoto(filename, id, uploadedImage);
    addPhoto(result);
    return result;
  }
}
