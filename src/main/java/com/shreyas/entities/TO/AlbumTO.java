package com.shreyas.entities.TO;

public class AlbumTO {
	
	private Long id;
	private String title;
	private Long userId;
	
	public AlbumTO(Long id, String title, Long userId) {
		super();
		this.id = id;
		this.title = title;
		this.userId = userId;
	}
	
	public AlbumTO() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AlbumTO [id=" + id + ", title=" + title + ", userId=" + userId + "]";
	}

}
