package com.jfjara.apitester.apitester.communicator.infraestructure;

import java.util.*;
import java.util.concurrent.Callable;

import com.jfjara.apitester.apitester.communicator.domain.ParametersQueryError;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class CallableGetTask implements Callable<Optional<String>> {

	private final String url;
	private final Map<String, Object> parameters;

	public CallableGetTask(String url, Map<String, Object> params) throws ParametersQueryError {
		this.url = url;
		this.parameters = params;
	}

	@Override
	public Optional<String> call() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://" + url);
		if (parameters != null && !parameters.isEmpty()) {
			for (Map.Entry<String, Object> entry : parameters.entrySet()) {
				builder.queryParam(entry.getKey(), entry.getValue());
			}
		}
		System.out.println(builder.toUriString());
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
