package com.testassessment;

public class FrameworkException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameworkException(String message, Exception e) {
		super(message, e);
	}

}
