package com.shreyas.exceptions;

public class DataInitializationException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataInitializationException() {
		super("Exception while initializing data");
	}
}
