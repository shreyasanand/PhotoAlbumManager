package com.shreyas.controllers;
import java.io.IOException;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shreyas.service.AlbumService;
import com.shreyas.service.PhotoService;

@RestController
@RequestMapping("/myapi/init")
public class InitController {

	private static final Logger logger = LoggerFactory.getLogger(InitController.class);
	
	@Resource(name="albumService")
	private AlbumService albumService;

	@Resource(name="photoService")
	private PhotoService photoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> init(){
		this.albumService.initData();
		this.photoService.initData();
		return ResponseEntity.ok("Initialized data!");
	}
	
}
