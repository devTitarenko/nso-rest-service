package com.example.nsorestservice.controller;

import com.example.nsorestservice.model.NsoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpMethod.*;

@RestController
public class ServiceController extends ParentController {

    private static final String SERVICES = "services/";

    @GetMapping(value = "getServices", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getServices() {
        String url = getNsoApiUrl() + API + RUNNING + SERVICES;
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, GET, headers, Object.class).getBody();
    }

    @PostMapping("addService")
    public ResponseEntity addService(@RequestBody NsoService nsoService) {
        String url = getNsoApiUrl() + API + RUNNING + SERVICES;
        HttpHeaders headers = new HttpHeaders() {{
            set(CONTENT_TYPE, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, POST, nsoService, headers, Object.class);
    }

    @DeleteMapping("deleteService/{id}")
    public ResponseEntity deleteService(@PathVariable("id") String serviceId) {
        String url = getNsoApiUrl() + API + RUNNING + SERVICES + "service/" + serviceId;
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, DELETE, headers, Object.class);
    }
}
