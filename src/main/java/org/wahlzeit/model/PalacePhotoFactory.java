package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class PalacePhotoFactory extends PhotoFactory {
  private static final Logger log = Logger.getLogger(PalacePhotoFactory.class.getName());

  private static PalacePhotoFactory instance = null;

	/**
	 * Public singleton access method.
	 */
	public static synchronized PalacePhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting PalacePhotoFactory").toString());
			setInstance(new PalacePhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PalacePhotoFactory.
	 */
	protected static synchronized void setInstance(PalacePhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PalacePhotoFactory twice");
		}

		instance = photoFactory;
	}
  
  @Override
  public PalacePhoto createPhoto() {
		return new PalacePhoto();
  }
  
  @Override
  public PalacePhoto createPhoto(PhotoId id) {
		return new PalacePhoto(id);
  }

  @Override
  public PalacePhotoFilter createPhotoFilter() {
    return new PalacePhotoFilter();
  }
}
