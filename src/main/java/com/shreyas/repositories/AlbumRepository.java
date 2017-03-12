package com.shreyas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
