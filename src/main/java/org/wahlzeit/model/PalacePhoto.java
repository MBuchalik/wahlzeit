package org.wahlzeit.model;

public class PalacePhoto extends Photo {
	public PalacePhoto() {
		super();
	}

	public PalacePhoto(PhotoId myId) throws IllegalArgumentException {
		super(myId);

		if (myId == null) {
			throw new IllegalArgumentException("The Photo ID may not be null");
		}
	}
}
