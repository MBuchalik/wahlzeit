/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.annotations.DesignPattern;

import java.util.logging.Logger;

/**
 * An Abstract Factory for creating photos and related objects.
 */
@DesignPattern(
	name = "Abstract Factory",
	participants = {"AbstractFactory", "ConcreteFactory"}
)
@DesignPattern(
	name = "Singleton",
	participants = {"Singleton"}
)
public class PhotoFactory {

	private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static PhotoFactory instance = null;

	/**
	 * @methodtype constructor
	 */
	protected PhotoFactory() {
		// do nothing
	}

	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 * 
	 * @methodtype init
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}

	/**
	 * Public singleton access method.
	 * 
	 * @methodtype get
	 */
	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting PalacePhotoFactory").toString());
			setInstance(new PalacePhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 * 
	 * @methodtype set
	 */
	protected static synchronized void setInstance(PhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PhotoFactory twice");
		}

		instance = photoFactory;
	}

	/**
	 * @methodtype factory
	 */
	public Photo createPhoto() {
		return new Photo();
	}

	/**
	 * Creates a new photo with the specified id
	 *
	 * @methodtype factory
	 */
	public Photo createPhoto(PhotoId id) {
		return new Photo(id);
	}

	/**
	 * Loads a photo. The Java object is loaded from the Google Datastore, the Images in all sizes are loaded from the
	 * Google Cloud storage.
	 */
	public Photo loadPhoto(PhotoId id) {
	   /* Photo result =
                OfyService.ofy().load().type(Photo.class).ancestor(KeyFactory.createKey("Application", "Wahlzeit")).filter(Photo.ID, id).first().now();
        for (PhotoSize size : PhotoSize.values()) {
            GcsFilename gcsFilename = new GcsFilename("picturebucket", filename);



        }*/
		return null;
	}


	/**
	 * @methodtype factory
	 */
	public PhotoFilter createPhotoFilter() {
		return new PhotoFilter();
	}

	/**
	 * @methodtype factory
	 */
	public PhotoTagCollector createPhotoTagCollector() {
		return new PhotoTagCollector();
	}

}
