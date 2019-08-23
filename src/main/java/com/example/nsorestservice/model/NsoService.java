package com.example.nsorestservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NsoService {
    private Service service;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private class Service {
        @NonNull
        @JsonProperty("object-id")
        private String objectId;
    }
}
