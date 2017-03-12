package com.shreyas.exceptions;

public class UnableToDeleteAlbumException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnableToDeleteAlbumException() {
		super("Unable to delete album as it contains photos");
	}
}
