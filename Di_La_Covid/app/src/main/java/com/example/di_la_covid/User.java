package com.example.di_la_covid;

public class User {
    public String fullname, email, password, id, userType;

    public User(String fullname, String email, String password, String id, String userType) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.id = id;
        this.userType = userType;
    }

    public User() {

    }
}
