package com.jfjara.apitester.apitester.communicator.infraestructure;

import java.util.*;
import java.util.concurrent.Callable;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class CallableGetTask implements Callable<Optional<String>> {

	private final String url;

	public CallableGetTask(String url) {
		this.url = url;
	}

	@Override
	public Optional<String> call() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

		HttpEntity<?> entity = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> response = restTemplate.exchange(
				builder.toUriString(),
				HttpMethod.GET,
				entity,
				String.class);
		return Optional.ofNullable(response.getBody());
	}

}
