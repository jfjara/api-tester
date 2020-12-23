package com.jfjara.apitester.apitester.httpget.domain;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class GetGroupParameters {

    private final Map<String, String[]> parameterMap;

    public GetGroupParameters(Map<String, String[]> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public String getUrl() throws NotUrlInParametersException, UnsupportedEncodingException {
        if (parameterMap.containsKey("url")) {
            return java.net.URLDecoder.decode(parameterMap.get("url")[0], StandardCharsets.UTF_8.name());
        }
        throw new NotUrlInParametersException();
    }

    public int getTotalRequestToDo() throws NotTotalRquestInParametersException {
        if (parameterMap.containsKey("requests")) {
            return Integer.parseInt(parameterMap.get("requests")[0]);
        }
        throw new NotTotalRquestInParametersException();
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            if (!"url".equals(entry.getKey()) && !"requests".equals(entry.getKey())) {
                result.put(entry.getKey(), entry.getValue()[0]);
            }
        }
        return result;
    }


}
