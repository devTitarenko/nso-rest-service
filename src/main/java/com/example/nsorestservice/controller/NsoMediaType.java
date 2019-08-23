package com.example.nsorestservice.controller;

import lombok.Getter;

@Getter
public enum NsoMediaType {
    JSON_API("application/vnd.yang.api+json"),
    JSON_DATA("application/vnd.yang.data+json"),
    JSON_DATASTORE("application/vnd.yang.datastore+json"),
    XML_API("application/vnd.yang.api+xml"),
    XML_DATA("application/vnd.yang.data+xml"),
    XML_DATASTORE("application/vnd.yang.datastore+xml");

    private String stringValue;

    NsoMediaType(String stringValue) {
        this.stringValue = stringValue;
    }
}
