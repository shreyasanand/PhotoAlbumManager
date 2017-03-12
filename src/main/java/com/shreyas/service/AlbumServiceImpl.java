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
import com.shreyas.entities.Album;
import com.shreyas.entities.TO.AlbumTO;
import com.shreyas.repositories.AlbumRepository;

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private final AlbumRepository albumRepository;
	
	@Autowired
	private final RestOperations restOperations;
	
	private final String albumDataURL;
	
	@Autowired
	public AlbumServiceImpl(final AlbumRepository albumRepository, 
							final RestOperations restOperations, 
							@Value("${albumData.url}")final String albumDataURL) {
		this.albumRepository = albumRepository;
		this.restOperations = restOperations;
		this.albumDataURL = albumDataURL;
	}
	
	@Override
	@Transactional
	public Album createAlbum(AlbumTO albumTO) {
		Album album = new Album(albumTO.getId(),
								albumTO.getTitle(),
								albumTO.getUserId()
								);
		return this.albumRepository.save(album);
	}

	@Override
	public Album getAlbumById(Long id) {
		return this.albumRepository.findOne(id);
	}

	@Override
	public Iterable<Album> getAlbums() {
		return this.albumRepository.findAll();
	}

	@Override
	@Transactional
	public Album updateAlbum(Long id, AlbumTO albumTransferObject) {
		Album album = this.albumRepository.findOne(id);
		BeanUtils.copyProperties(albumTransferObject, album);
		return this.albumRepository.save(album);
	}

	@Override
	@Transactional
	public void deleteAlbum(Long id) {
		this.albumRepository.delete(id);
	}

	@Override
	public void initData() {
		String response = restOperations.getForObject(albumDataURL, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JSONArray json = new JSONArray(response);
			for(int i=0;i<json.length();i++) {
				AlbumTO albumTO = mapper.readValue(json.getJSONObject(i).toString(), AlbumTO.class);
				this.createAlbum(albumTO);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
}
