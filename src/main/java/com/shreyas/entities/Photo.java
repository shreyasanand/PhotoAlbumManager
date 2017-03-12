package com.shreyas.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photos")
public class Photo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private String url;
	private Long albumId;
	private String thumbnailUrl;

	public Photo(Long id, String title, String url, Long albumId, String thumbnailUrl) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.albumId = albumId;
		this.thumbnailUrl = thumbnailUrl;
	}

	public Photo() {
	}

	@Id
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	@Column(name = "album_id")
	public Long getAlbumId() {
		return albumId;
	}
	
	@Column(name = "thumbnail_url")
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", title=" + title + ", url=" + url + ", albumId=" + albumId + ", thumbnailUrl="
				+ thumbnailUrl + "]";
	}
	
}
