package com.jfjara.apitester.apitester.httpget.application;

import com.jfjara.apitester.apitester.communicator.domain.CommunicationException;
import com.jfjara.apitester.apitester.communicator.infraestructure.CommunicatorRest;
import com.jfjara.apitester.apitester.httpget.domain.GetGroupParameters;
import com.jfjara.apitester.apitester.httpget.domain.NotTotalRquestInParametersException;
import com.jfjara.apitester.apitester.httpget.domain.NotUrlInParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SendGetWithParams extends SendGetAbstract {

    @Autowired
    private CommunicatorRest communicator;

    @Override
    public Optional<String> send(Map<String, String[]> parameterMap) throws NotUrlInParametersException, NotTotalRquestInParametersException, CommunicationException, UnsupportedEncodingException {
        List<Optional<String>> optionalsResult = new ArrayList<>();
        GetGroupParameters parametersGroup = new GetGroupParameters(parameterMap);
        for (int i = 0; i < parametersGroup.getTotalRequestToDo(); i++) {
            optionalsResult.add(communicator.get(parametersGroup.getUrlWithParams()));
        }
        return transformListToOptional(optionalsResult);
    }
}
