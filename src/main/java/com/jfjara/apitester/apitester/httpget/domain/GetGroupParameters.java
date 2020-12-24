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

    public String getUrlWithPathVariables() throws NotUrlInParametersException, UnsupportedEncodingException {
        if (parameterMap.containsKey("url")) {
            StringBuilder sb = new StringBuilder("http://");
            String url = java.net.URLDecoder.decode(parameterMap.get("url")[0], StandardCharsets.UTF_8.name());
            sb.append(url);
            for (Map.Entry<String, Object> entry : getParameters().entrySet()) {
                sb.append(entry.getValue().toString()).append("/");
            }
            return sb.toString();
        }
        throw new NotUrlInParametersException();
    }

    public String getUrlWithParams() throws NotUrlInParametersException, UnsupportedEncodingException {
        if (parameterMap.containsKey("url")) {
            StringBuilder sb = new StringBuilder("http://");
            String url = java.net.URLDecoder.decode(parameterMap.get("url")[0], StandardCharsets.UTF_8.name());
            sb.append(url);
            int index = 0;
            for (Map.Entry<String, Object> entry : getParameters().entrySet()) {
                if (index > 0) {
                    sb.append("&");
                }
                sb.append(entry.getKey()).append("=").append(entry.getValue().toString());
                index++;
            }
            return sb.toString();
        }
        throw new NotUrlInParametersException();
    }

    public int getTotalRequestToDo() throws NotTotalRquestInParametersException {
        if (parameterMap.containsKey("requests")) {
            return Integer.parseInt(parameterMap.get("requests")[0]);
        }
        throw new NotTotalRquestInParametersException();
    }

    private Map<String, Object> getParameters() {
        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            if (!"url".equals(entry.getKey()) && !"requests".equals(entry.getKey())) {
                result.put(entry.getKey(), entry.getValue()[0]);
            }
        }
        return result;
    }

}
