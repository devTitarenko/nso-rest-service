package com.example.nsorestservice.controller;

import lombok.Getter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public abstract class ParentController {

    @Getter
    @Value("${nso.api.url}")
    private String nsoApiUrl;
    @Value("${nso.api.user}")
    private String nsoApiUser;
    @Value("${nso.api.pass}")
    private String nsoApiPass;

    static final String API = "api/";
    static final String CONFIG = "config/";
    static final String RUNNING = "running/";
    static final String AAA = "aaa/";

    static final Logger LOGGER = Logger.getLogger(ParentController.class.getName());

    <T> ResponseEntity<T> callNso(String url, HttpMethod method, HttpHeaders headers, Class<T> classType) {
        return callNso(url, method, null, headers, classType);
    }

    <T> ResponseEntity<T> callNso(String url, HttpMethod method, Object body, HttpHeaders headers, Class<T> classType) {
        String auth = nsoApiUser + ":" + nsoApiPass;
        String authHeader = "Basic " + new String(Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII)));
        headers.set("Authorization", authHeader);
        LOGGER.log(Level.FINE, "Send request " + method + ": " + url);
        return new RestTemplate().exchange(url, method, new HttpEntity<>(body, headers), classType);
    }

    @ExceptionHandler({RestClientResponseException.class})
    public void handleException(RestClientResponseException e) {
        LOGGER.log(Level.WARNING, e.getResponseBodyAsString());
        throw e;
    }
}
