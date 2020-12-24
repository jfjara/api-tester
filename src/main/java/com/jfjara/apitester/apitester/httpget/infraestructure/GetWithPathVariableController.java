package com.jfjara.apitester.apitester.httpget.infraestructure;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import com.jfjara.apitester.apitester.httpget.domain.NotTotalRquestInParametersException;
import com.jfjara.apitester.apitester.httpget.domain.NotUrlInParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfjara.apitester.apitester.communicator.domain.CommunicationException;
import com.jfjara.apitester.apitester.httpget.application.SendGetWithPathVariables;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GetWithPathVariableController {

    @Autowired
    private SendGetWithPathVariables senderGetWithPathVariable;

    @GetMapping("/getPathVariable")
    public Optional<String> getWithPathVariable(HttpServletRequest request) throws CommunicationException, NotTotalRquestInParametersException, NotUrlInParametersException, UnsupportedEncodingException {
        return senderGetWithPathVariable.send(request.getParameterMap());
    }


}
