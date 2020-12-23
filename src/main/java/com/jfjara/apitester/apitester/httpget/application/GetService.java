package com.jfjara.apitester.apitester.httpget.application;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Optional;

import com.jfjara.apitester.apitester.communicator.domain.CommunicationException;
import com.jfjara.apitester.apitester.communicator.domain.ParametersQueryError;
import com.jfjara.apitester.apitester.httpget.domain.NotTotalRquestInParametersException;
import com.jfjara.apitester.apitester.httpget.domain.NotUrlInParametersException;

public interface GetService {

    Optional<String> send(Map<String, String[]> parameterMap) throws NotUrlInParametersException, NotTotalRquestInParametersException, CommunicationException, ParametersQueryError, UnsupportedEncodingException;
}
