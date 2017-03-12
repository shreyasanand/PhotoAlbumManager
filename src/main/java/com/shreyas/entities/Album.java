package com.shreyas.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "albums" )
public class Album implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private Long userId;

	public Album(Long id, String albumTitle, Long userID) {
		super();
		this.id = id;
		this.title = albumTitle;
		this.userId = userID;
	}
	
	public Album() {
	}
	
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	@Id
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", userId=" + userId + "]";
	}
	
}
