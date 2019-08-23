package com.lohika.nsorestservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class NsoService {
    private Service service;

    @Data
    @NoArgsConstructor
    public class Service {
        @NonNull
        @JsonProperty("object-id")
        private String objectId;
    }
}
