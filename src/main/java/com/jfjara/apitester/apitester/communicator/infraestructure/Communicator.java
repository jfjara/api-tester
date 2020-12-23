package com.jfjara.apitester.apitester.communicator.infraestructure;

import java.util.Map;
import java.util.Optional;

import com.jfjara.apitester.apitester.communicator.domain.CommunicationException;
import com.jfjara.apitester.apitester.communicator.domain.ParametersQueryError;

public interface Communicator {

	//public Optional<String> get(String url) throws CommunicationException, ParametersQueryError;
	public Optional<String> get(String url, Map<String, Object> params) throws CommunicationException, ParametersQueryError;
	
}
