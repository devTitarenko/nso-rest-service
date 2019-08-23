package com.example.nsorestservice.controller;

import com.example.nsorestservice.model.NsoDevice;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpMethod.*;

@RestController
public class DeviceController extends ParentController {

    private static final String DEVICES = "devices/";
    private static final String DEVICE = "device/";

    @GetMapping(value = "getDevices", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getDevices() {
        String url = getNsoApiUrl() + API + RUNNING + DEVICES;
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, GET, headers, Object.class).getBody();
    }

    @PutMapping("addDevice")
    public ResponseEntity addDevice(@RequestBody NsoDevice nsoDevice) {
        String url = getNsoApiUrl() + API + RUNNING + DEVICES + DEVICE + nsoDevice.getDevice().getName();
        HttpHeaders headers = new HttpHeaders() {{
            set(CONTENT_TYPE, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, PUT, nsoDevice, headers, Object.class);
    }

    @DeleteMapping("deleteDevice/{id}")
    public ResponseEntity deleteDevice(@PathVariable("id") String deviceId) {
        String url = getNsoApiUrl() + API + RUNNING + DEVICES + DEVICE + deviceId;
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, DELETE, headers, Object.class);
    }
}
