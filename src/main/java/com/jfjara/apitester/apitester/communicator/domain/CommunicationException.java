package com.jfjara.apitester.apitester.communicator.domain;

public class CommunicationException extends Throwable {

	private static final long serialVersionUID = 5127417136432516273L;
	
	private Exception exception = null;

	public CommunicationException(Exception exception) {
		this.exception = exception;
	}
	
	@Override
	public String getMessage() {
		return exception.getMessage();
	}
	
}
