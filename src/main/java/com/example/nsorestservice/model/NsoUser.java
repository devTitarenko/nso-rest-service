package com.example.nsorestservice.model;

import lombok.Data;

@Data
public class NsoUser {
    private User user;

    @Data
    static class User {
        private String name;
        private String uid;
        private String gid;
        private String password;
        private String ssh_keydir;
        private String homedir;
    }
}
