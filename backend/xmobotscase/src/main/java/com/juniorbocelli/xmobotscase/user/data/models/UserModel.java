package com.juniorbocelli.xmobotscase.user.data.models;

import java.util.List;
import java.util.stream.Collectors;

import com.juniorbocelli.xmobotscase.user.domain.entities.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "token", nullable = false, length = 100)
    private String token;

    public UserModel(Long id, String name, String email, String password, String token) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public UserModel() {

    }

    public User toUser(UserModel userModel) {
        User user = new User();
        user.setId(userModel.getId());
        user.setName(userModel.getName());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setToken(userModel.getToken());

        return user;
    }

    public UserModel toUserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());
        userModel.setToken(user.getToken());

        return userModel;
    }

    public List<User> toUserList(List<UserModel> userModels) {
        return userModels.stream().map(temp -> {
            User objUser = new User();
            objUser.setId(temp.getId());
            objUser.setName(temp.getName());
            objUser.setEmail(temp.getEmail());
            objUser.setPassword(temp.getPassword());
            objUser.setToken(temp.getToken());

            return objUser;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
