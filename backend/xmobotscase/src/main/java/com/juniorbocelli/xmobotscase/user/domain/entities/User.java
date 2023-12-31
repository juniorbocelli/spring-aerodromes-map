package com.juniorbocelli.xmobotscase.user.domain.entities;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{\"id\": " + this.id + ", \"name\": " + "\"" + this.name + "\"" + ", \"email\": " + "\"" + this.email
                + "\""
                + ", \"password\": " + "\"" + this.password + "\"" + "}";
    }
}
