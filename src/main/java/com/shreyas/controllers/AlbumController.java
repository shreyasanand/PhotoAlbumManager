package com.shreyas.controllers;

import javax.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shreyas.entities.TO.AlbumTO;
import com.shreyas.exceptions.UnableToDeleteAlbumException;
import com.shreyas.service.AlbumService;
import com.shreyas.service.PhotoService;

@RestController
@RequestMapping(AlbumController.ALBUMS_BASE_URI)
public class AlbumController {
	
	public static final String ALBUMS_BASE_URI = "/myapi/albums";
	
	@Resource(name="albumService")
	private AlbumService albumService;

	@Resource(name="photoService")
	private PhotoService photoService;
	
	/**
	 * Method to create an album
	 * POST : /myapi/albums
	 * 
	 * @param albumTO
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createAlbum(@RequestBody AlbumTO albumTO) {
		return new ResponseEntity<>(this.albumService.createAlbum(albumTO),HttpStatus.CREATED);
	}
	
	/**
	 * Method to get all albums
	 * GET : /myapi/albums
	 * 
	 * @param pageable
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAlbums(){
		return ResponseEntity.ok(this.albumService.getAlbums());
	}
	
	/**
	 * Method to get album by Id
	 * GET : /myapi/albums/{id}
	 * 
	 * @param id
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAlbumById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.albumService.getAlbumById(id));
	}
	
	/**
	 * Method to update a particular album
	 * PUT : /myapi/albums/{id}
	 * 
	 * @param id
	 * @param albumTO
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAlbum(@PathVariable("id") Long id, @RequestBody AlbumTO albumTO) {
		return ResponseEntity.ok(this.albumService.updateAlbum(id, albumTO));
	}

	/**
	 * Method to delete an album.
	 * Deletes only if there are no photos in the album
	 * DELETE : /myapi/album/{id}
	 * 
	 * @param id
	 * @throws UnableToDeleteAlbumException
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAlbum(@PathVariable("id") Long id) throws UnableToDeleteAlbumException {
		
		if(this.photoService.getPhotosByAlbumId(id).iterator().hasNext()){
			throw new UnableToDeleteAlbumException();
		} else
			this.albumService.deleteAlbum(id);
		
		return ResponseEntity.ok(null);
	}
	
//	public ResponseEntity<?> getAlbumsAndPhotos(@PageableDefault(sort = "id") Pageable pageable) {
//		
//		Gson gson = new GsonBuilder().create();
//		
//		Iterable<Album> albums = this.albumService.getAlbums(pageable);
//		for(Album a: albums){
//			gson.toJson(a);
//			gson.toJson(ResponseEntity.ok(this.photoService.getPhotosByAlbumId(a.getId())).getBody());
//			this.photoService.getPhotosByAlbumId(a.getId());
//		}
//		
//	}
}
