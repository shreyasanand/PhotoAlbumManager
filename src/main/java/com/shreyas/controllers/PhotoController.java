package com.shreyas.controllers;

import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shreyas.entities.TO.PhotoTO;
import com.shreyas.service.PhotoService;

@RestController
@RequestMapping(PhotoController.PHOTOS_BASE_URI)
public class PhotoController {
	
	public static final String PHOTOS_BASE_URI = "/myapi/photos";
	
	public static final String PHOTOS_BY_ALBUM_EXT_URI = "/byAlbum/{id}";
	
	@Resource(name="photoService")
	private PhotoService photoService;
	
	/**
	 * Method to create a new photo
	 * POST : /myapi/photos
	 * 
	 * @param photoTO
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createPhoto(@RequestBody PhotoTO photoTO) {
		return new ResponseEntity<>(this.photoService.createPhoto(photoTO), HttpStatus.CREATED);
	}
	
	/**
	 * Method to get all photos
	 * GET : /myapi/photos
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getPhotos() {
		return ResponseEntity.ok(this.photoService.getPhotos());
	}
	
	/**
	 * Method to get a photo by id
	 * GET : /myapi/photos/{id}
	 * 
	 * @param id
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPhotoById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.photoService.getPhotoById(id));
	}
	
	/**
	 * Method to update an existing photo
	 * PUT : /myapi/photos/{id}
	 * 
	 * @param id
	 * @param photoTO
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePhoto(@PathVariable("id") Long id, @RequestBody PhotoTO photoTO) {
		return ResponseEntity.ok(this.photoService.updatePhoto(id, photoTO));
	}
	
	/**
	 * Method to delete a photo
	 * DELETE : /myapi/photos/{id}
	 * 
	 * @param id
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePhoto(@PathVariable("id") Long id) {
		this.photoService.deletePhoto(id);
		return ResponseEntity.ok(null);
	}
	
	/**
	 * Method to get a list of all photos in a given album
	 * GET : myapi/photos/byAlbum/{id}
	 * 
	 * @param id
	 */
	@RequestMapping(value = PhotoController.PHOTOS_BY_ALBUM_EXT_URI, method = RequestMethod.GET)
	public ResponseEntity<?> getPhotosByAlbumId(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.photoService.getPhotosByAlbumId(id));
	}
}
