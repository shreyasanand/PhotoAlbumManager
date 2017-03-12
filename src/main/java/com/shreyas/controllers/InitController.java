package com.shreyas.controllers;

import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shreyas.exceptions.DataInitializationException;
import com.shreyas.service.AlbumService;
import com.shreyas.service.PhotoService;

@RestController
@RequestMapping(InitController.INIT_BASE_URI)
public class InitController {

	public static final String INIT_SUCCESS_MSG = "Initialized data successfully";
	public static final String INIT_BASE_URI = "/myapi/init";
	
	@Resource(name="albumService")
	private AlbumService albumService;

	@Resource(name="photoService")
	private PhotoService photoService;
	
	/**
	 * Method to initialize the data from the given webservices
	 * albumData.url and photoData.url defined in application.properties
	 * GET : /myapi/init
	 * 
	 * @throws DataInitializationException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> init() throws DataInitializationException {
		if(!this.albumService.initData() || !this.photoService.initData()){
			throw new DataInitializationException();
		}
		return ResponseEntity.ok(InitController.INIT_SUCCESS_MSG);
	}
	
}
