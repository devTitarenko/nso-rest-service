package com.lohika.nsorestservice.controller;

import com.lohika.nsorestservice.model.NsoUser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpMethod.*;

@RestController
public class UserController extends ParentController {

    @GetMapping("getVersion")
    public Object getVersion() {
        String url = getNsoApiUrl() + API;
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_API.getStringValue());
        }};
        return callNso(url, GET, headers, Object.class).getBody();
    }

    @GetMapping("getConfig")
    public Object getConfig() {
        String url = getNsoApiUrl() + API + CONFIG;
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_DATASTORE.getStringValue());
        }};
        return callNso(url, GET, headers, Object.class).getBody();
    }

    /**
     * 'show running-config aaa'
     */
    @GetMapping("getConfigAaa")
    public Object getConfigAaa(@RequestParam(value = "deep", required = false) String deep) {
        String url = getNsoApiUrl() + API + RUNNING + AAA + (deep != null ? "?deep" : "");
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_DATA.getStringValue());
            set(CONTENT_TYPE, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, GET, headers, Object.class).getBody();
    }

    @PostMapping("addUser")
    public ResponseEntity addUser(@RequestBody NsoUser nsoUser) {
        String url = getNsoApiUrl() + API + RUNNING + AAA + "authentication/users/";
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_DATA.getStringValue());
            set(CONTENT_TYPE, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, POST, nsoUser, headers, Object.class);
    }

    @DeleteMapping("deleteUser/{userName}")
    public ResponseEntity deleteUser(@PathVariable("userName") String nsoUserName) {
        String url = getNsoApiUrl() + API + RUNNING + AAA + "authentication/users/user/" + nsoUserName;
        HttpHeaders headers = new HttpHeaders() {{
            set(ACCEPT, NsoMediaType.JSON_DATA.getStringValue());
        }};
        return callNso(url, DELETE, headers, Object.class);
    }
}
