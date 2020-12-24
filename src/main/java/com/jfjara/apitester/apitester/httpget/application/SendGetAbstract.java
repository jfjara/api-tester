package com.jfjara.apitester.apitester.httpget.application;

import com.jfjara.apitester.apitester.communicator.domain.CommunicationException;
import com.jfjara.apitester.apitester.httpget.domain.NotTotalRquestInParametersException;
import com.jfjara.apitester.apitester.httpget.domain.NotUrlInParametersException;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class SendGetAbstract {

    public abstract Optional<String> send(Map<String, String[]> parameterMap) throws NotUrlInParametersException, NotTotalRquestInParametersException, CommunicationException, UnsupportedEncodingException;

    protected Optional<String> transformListToOptional(List<Optional<String>> optionalsResult) {
        StringBuilder sb = new StringBuilder();
        optionalsResult.forEach(optional -> sb.append(optional.isPresent() ? optional.get() : Optional.empty()));
        return Optional.of(sb.toString());
    }

}
