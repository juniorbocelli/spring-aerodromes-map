package com.juniorbocelli.xmobotscase.data.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juniorbocelli.xmobotscase.data.models.UserModel;
import com.juniorbocelli.xmobotscase.domain.usecases.user.CreateUser;

@RestController
public class UserController {
    final CreateUser createUser;

    UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @PostMapping(path = "user", consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> create (@RequestBody UserModel userModel) {
        this.createUser.call(userModel.toUser(userModel))
    }
}
