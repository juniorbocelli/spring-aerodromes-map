package com.juniorbocelli.xmobotscase.user.data.models;

import com.juniorbocelli.xmobotscase.user.domain.entities.User;

public class UserRequestModel {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String token;

    public static User toUser(UserRequestModel userRequestModel) {
        User user = new User();
        user.setId(userRequestModel.getId());
        user.setName(userRequestModel.getName());
        user.setEmail(userRequestModel.getEmail());
        user.setPassword(userRequestModel.getPassword());
        user.setToken(userRequestModel.getToken());

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    };

}
