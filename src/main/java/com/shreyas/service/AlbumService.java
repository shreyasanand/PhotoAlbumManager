package com.shreyas.service;

import org.springframework.data.domain.Pageable;

import com.shreyas.entities.Album;
import com.shreyas.entities.TO.AlbumTO;

public interface AlbumService {
	
	Album createAlbum(AlbumTO albumTransferObject);

	Album getAlbumById(Long id);

	Iterable<Album> getAlbums();

	Album updateAlbum(Long id, AlbumTO albumTransferObject);

	void deleteAlbum(Long id);
	
	void initData();

}
