package com.example.nsorestservice.controller;

import com.example.nsorestservice.model.NsoDevice;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PUT;

@RestController
public class DeviceController extends ParentController {

    @GetMapping(value = "getDevices", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getDevices() {
        String url = getNsoApiUrl() + API + RUNNING + "devices/";
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, GET, headers, Object.class).getBody();
    }

    @PutMapping("addDevice")
    public ResponseEntity addDevice(@RequestBody NsoDevice nsoDevice) {
        String url = getNsoApiUrl() + API + RUNNING + "devices/device/" + nsoDevice.getDevice().getName();
        HttpHeaders headers = new HttpHeaders() {{
            set(CONTENT_TYPE, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, PUT, nsoDevice, headers, Object.class);
    }
}
