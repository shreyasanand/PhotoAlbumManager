package com.shreyas.entities.TO;

/**
 * Data transfer object for Photo entity
 * 
 * @author shreyas
 */
public class PhotoTO {
	
	private Long id;
	private String title; 
	private String url;
	private Long albumId;
	private String thumbnailUrl;
	
	public PhotoTO(Long id, String title, String url, Long albumId, String thumbnailUrl) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.albumId = albumId;
		this.thumbnailUrl = thumbnailUrl;
	}

	public PhotoTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Long getAlbumId() {
		return albumId;
	}


	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}


	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}


	@Override
	public String toString() {
		return "PhotoTO [id=" + id + ", title=" + title + ", url=" + url + ", albumId=" + albumId + ", thumbnailUrl="
				+ thumbnailUrl + "]";
	}

}
