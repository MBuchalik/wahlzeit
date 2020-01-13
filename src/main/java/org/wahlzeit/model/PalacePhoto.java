package org.wahlzeit.model;

import org.wahlzeit.model.palace.Palace;

public class PalacePhoto extends Photo {
	protected Palace shownPalace;

	public PalacePhoto() {
		super();
	}

	public PalacePhoto(PhotoId myId) throws IllegalArgumentException {
		super(myId);

		if (myId == null) {
			throw new IllegalArgumentException("The Photo ID may not be null");
		}
	}

	public Palace getPalace() {
		return this.shownPalace;
	}

	public void setPalace(Palace palace) {
		if (palace == null) {
			throw new IllegalArgumentException("The palace may not be set to null");
		}

		this.shownPalace = palace;
	}
}
