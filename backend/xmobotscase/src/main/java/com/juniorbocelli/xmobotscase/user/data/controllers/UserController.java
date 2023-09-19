package com.juniorbocelli.xmobotscase.user.data.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juniorbocelli.xmobotscase.user.data.models.UserRequestModel;
import com.juniorbocelli.xmobotscase.user.data.models.UserResponseModel;
import com.juniorbocelli.xmobotscase.user.domain.entities.User;
import com.juniorbocelli.xmobotscase.user.domain.usecases.CreateUser;
import com.juniorbocelli.xmobotscase.user.domain.usecases.GetUser;
import com.juniorbocelli.xmobotscase.user.domain.usecases.GetUsers;

@RestController
public class UserController {
    final CreateUser createUser;
    final GetUsers getUsers;
    final GetUser getUser;

    UserController(CreateUser createUser, GetUsers getUsers, GetUser getUser) {
        this.createUser = createUser;
        this.getUsers = getUsers;
        this.getUser = getUser;
    }

    @PostMapping(path = "api/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> create(@RequestBody UserRequestModel userRequestModel) {
        this.createUser.call(UserRequestModel.toUser(userRequestModel));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "api/user")
    public ResponseEntity<List<UserResponseModel>> getUsers() {
        List<User> users = this.getUsers.call();

        return new ResponseEntity<List<UserResponseModel>>(UserResponseModel.toUserResponseModelList(users),
                HttpStatus.OK);
    }

    @GetMapping(path = "api/user/{id}")
    public ResponseEntity<UserResponseModel> getUser(@PathVariable("id") Long id) {

        User user = this.getUser.call(id);

        return new ResponseEntity<UserResponseModel>(UserResponseModel.toUserResponseModel(user),
                HttpStatus.OK);
    }
}
