package com.jfjara.apitester.apitester.communicator.infraestructure;

import com.jfjara.apitester.apitester.communicator.domain.CommunicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class CommunicatorRest implements Communicator {

	@Autowired
    ThreadPoolTaskExecutor executor;

	@Override
	public Optional<String> get(String url) throws CommunicationException {
		Future<Optional<String>> future = executor.submit(new CallableGetTask(url));
		try {
			return future.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new CommunicationException(e);
		}
	}

}
