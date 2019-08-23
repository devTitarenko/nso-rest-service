package com.example.nsorestservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class NsoDevice {
    @NonNull
    private Device device;

    @Data
    @NoArgsConstructor
    public class Device {
        @NonNull
        private String name;
        private String address;
        private Integer port;
        private String authgroup;
        @JsonProperty("device-type")
        private DeviceType deviceType;
        private State state;

        @Data
        public class DeviceType {
            private Cli cli;

            @Data
            public class Cli {
                @JsonProperty("ned-id")
                private String nedId;
            }
        }

        @Data
        public class State {
            @JsonProperty("admin-state")
            private String adminState;
        }
    }
}
