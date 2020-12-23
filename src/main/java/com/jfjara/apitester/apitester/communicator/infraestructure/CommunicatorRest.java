package com.jfjara.apitester.apitester.communicator.infraestructure;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.jfjara.apitester.apitester.communicator.domain.ParametersQueryError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.jfjara.apitester.apitester.communicator.domain.CommunicationException;

@Component
public class CommunicatorRest implements Communicator {

	@Autowired
    ThreadPoolTaskExecutor executor;
	


	@Override
	public Optional<String> get(String url, Map<String, Object> params) throws CommunicationException, ParametersQueryError {
		Future<Optional<String>> future = executor.submit(new CallableGetTask(url, params));
		try {
			return future.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new CommunicationException(e);
		}
	}

}
