package com.jfjara.apitester.apitester.communicator.infraestructure;

import com.jfjara.apitester.apitester.communicator.domain.CommunicationException;

import java.util.Optional;

public interface Communicator {

	Optional<String> get(String url) throws CommunicationException;
	
}
