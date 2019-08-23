package com.example.nsorestservice.controller;

import com.example.nsorestservice.model.NsoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@RestController
public class ServiceController extends ParentController {

    @GetMapping(value = "getServices", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getServices() {
        String url = getNsoApiUrl() + API + RUNNING + "services/";
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, GET, headers, Object.class).getBody();
    }

    @PostMapping("addService")
    public ResponseEntity addService(@RequestBody NsoService nsoService) {
        String url = getNsoApiUrl() + API + RUNNING + "services/";
        HttpHeaders headers = new HttpHeaders() {{
            set(CONTENT_TYPE, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, POST, nsoService, headers, Object.class);
    }
}
