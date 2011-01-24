package com.deloitte.timesink.service;

/**
 * Exception thrown when a search term cannot be resolved to a location
 */
public class UnableToLocateException extends Exception {

	public UnableToLocateException() {
		super();
	}

	public UnableToLocateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UnableToLocateException(String msg) {
		super(msg);
	}

	public UnableToLocateException(Throwable cause) {
		super(cause);
	}

}
