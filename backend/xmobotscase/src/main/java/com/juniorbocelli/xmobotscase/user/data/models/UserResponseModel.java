package com.juniorbocelli.xmobotscase.user.data.models;

import java.util.List;
import java.util.stream.Collectors;

import com.juniorbocelli.xmobotscase.user.domain.entities.User;

public class UserResponseModel {
    private Long id;
    private String name;
    private String email;
    private String password;

    public UserResponseModel() {

    }

    public UserResponseModel(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static UserResponseModel toUserResponseModel(User user) {
        UserResponseModel userResponseModel = new UserResponseModel();
        userResponseModel.setId(user.getId());
        userResponseModel.setName(user.getName());
        userResponseModel.setEmail(user.getEmail());
        userResponseModel.setPassword(user.getPassword());

        return userResponseModel;
    }

    public static List<UserResponseModel> toUserResponseModelList(List<User> users) {
        return users.stream().map(temp -> {
            UserResponseModel userResponseModel = UserResponseModel.toUserResponseModel(temp);

            return userResponseModel;
        }).collect(Collectors.toList());
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
}
