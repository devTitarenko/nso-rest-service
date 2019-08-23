package com.example.nsorestservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class NsoDevice {
    @NonNull
    private Device device;

    @Getter
    @Setter
    public class Device {
        @NonNull
        private String name;
        private String address;
        private Integer port;
        private String authgroup;
        @JsonProperty("device-type")
        private DeviceType deviceType;
        private State state;

        @Getter
        @Setter
        public class DeviceType {
            private Cli cli;

            @Getter
            @Setter
            public class Cli {
                @JsonProperty("ned-id")
                private String nedId;
            }
        }

        @Getter
        @Setter
        public class State {
            @JsonProperty("admin-state")
            private String adminState;
        }
    }
}
