package com.example.nsorestservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NsoUser {
    private User user;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class User {
        private String name;
        private String uid;
        private String gid;
        private String password;
        private String ssh_keydir;
        private String homedir;

        public User(String name) {
            this(name, "0", "0", name, "", "");
        }
    }
}
