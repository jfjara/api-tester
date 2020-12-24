package com.jfjara.apitester.apitester.httpget.infraestructure;

import com.jfjara.apitester.apitester.communicator.domain.CommunicationException;
import com.jfjara.apitester.apitester.httpget.application.SendGetWithParams;

import com.jfjara.apitester.apitester.httpget.domain.NotTotalRquestInParametersException;
import com.jfjara.apitester.apitester.httpget.domain.NotUrlInParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@RestController
public class GetWithParametersController {

    @Autowired
    private SendGetWithParams senderGetWithParams;

    @GetMapping("/getParameters")
    public Optional<String> getWithParameters(HttpServletRequest request) throws CommunicationException, NotTotalRquestInParametersException, NotUrlInParametersException, UnsupportedEncodingException {
        return senderGetWithParams.send(request.getParameterMap());
    }

}
