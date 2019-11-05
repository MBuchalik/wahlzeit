package org.wahlzeit.model;

import com.google.appengine.api.images.Image;

public class PalacePhotoUtil extends PhotoUtil {
	public static Photo createPhoto(String filename, PhotoId id, Image uploadedImage) throws Exception {
		Photo result = PalacePhotoFactory.getInstance().createPhoto(id);
		result.setEnding(filename.substring(filename.lastIndexOf(".") + 1));

		createImageFiles(uploadedImage, result);

		int sourceWidth = uploadedImage.getWidth();
		int sourceHeight = uploadedImage.getHeight();
		result.setWidthAndHeight(sourceWidth, sourceHeight);

		return result;
	}
}
