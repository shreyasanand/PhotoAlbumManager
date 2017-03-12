package com.shreyas.exceptions;

public class UnableToDeleteAlbumException extends Exception {

	public UnableToDeleteAlbumException() {
		super("Unable to delete album as it contains photos");
	}
}
