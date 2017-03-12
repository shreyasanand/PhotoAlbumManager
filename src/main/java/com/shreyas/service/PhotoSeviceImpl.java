package com.shreyas.service;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestOperations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shreyas.entities.Photo;
import com.shreyas.entities.TO.PhotoTO;
import com.shreyas.repositories.PhotoRepository;

@Service("photoService")
public class PhotoSeviceImpl implements PhotoService {

	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private final RestOperations restOperations;
	
	private final String photoDataURL;
	
	@Autowired
	public PhotoSeviceImpl(final PhotoRepository photoRepository, 
						   final RestOperations restOperations, 
						   @Value("${photoData.url}") final String photoDataURL) {
		this.photoRepository = photoRepository;
		this.restOperations = restOperations;
		this.photoDataURL = photoDataURL;
	}
	
	
	@Override
	@Transactional
	public Photo createPhoto(PhotoTO photoTO) {
		Photo photo = new Photo(photoTO.getId(),
								photoTO.getTitle(),
								photoTO.getUrl(),
								photoTO.getAlbumId(),
								photoTO.getThumbnailUrl());
		
		return this.photoRepository.save(photo);
	}

	@Override
	public Photo getPhotoById(Long id) {
		return this.photoRepository.findOne(id);
	}

	@Override
	public Iterable<Photo> getPhotos() {
		return this.photoRepository.findAll();
	}

	@Override
	public Iterable<Photo> getPhotosByAlbumId(Long albumId) {
		
		return this.photoRepository.getPhotosByAlbumId(albumId);
	}
	
	@Override
	@Transactional
	public Photo updatePhoto(Long id, PhotoTO photoTransferObject) {
		Photo photo = this.photoRepository.findOne(id);
		BeanUtils.copyProperties(photoTransferObject, photo);
		return this.photoRepository.save(photo);
	}

	@Override
	@Transactional
	public void deletePhoto(Long id) {
		this.photoRepository.delete(id);
	}

	@Override
	public void initData() {
		String response = restOperations.getForObject(photoDataURL, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JSONArray json = new JSONArray(response);
			for(int i=0;i<json.length();i++) {
				PhotoTO photoTO = mapper.readValue(json.getJSONObject(i).toString(), PhotoTO.class);
				this.createPhoto(photoTO);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
}
