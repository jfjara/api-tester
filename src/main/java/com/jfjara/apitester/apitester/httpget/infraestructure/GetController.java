package com.jfjara.apitester.apitester.httpget.infraestructure;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Optional;

import com.jfjara.apitester.apitester.communicator.domain.ParametersQueryError;
import com.jfjara.apitester.apitester.httpget.domain.NotTotalRquestInParametersException;
import com.jfjara.apitester.apitester.httpget.domain.NotUrlInParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jfjara.apitester.apitester.communicator.domain.CommunicationException;
import com.jfjara.apitester.apitester.httpget.application.GetServiceRest;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GetController {

    @Autowired
    private GetServiceRest service;

    @GetMapping("/get")
    public Optional<String> get(HttpServletRequest request) throws CommunicationException, ParametersQueryError, NotTotalRquestInParametersException, NotUrlInParametersException, UnsupportedEncodingException {
        return service.send(request.getParameterMap());
    }

}
