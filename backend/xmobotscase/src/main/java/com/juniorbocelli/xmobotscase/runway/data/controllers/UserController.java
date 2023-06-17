package com.juniorbocelli.xmobotscase.user.data.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juniorbocelli.xmobotscase.user.data.models.UserRequestModel;
import com.juniorbocelli.xmobotscase.user.data.models.UserResponseModel;
import com.juniorbocelli.xmobotscase.user.domain.usecases.CreateUser;

@RestController
public class UserController {
    final CreateUser createUser;

    UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @PostMapping(path = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseModel> create(@RequestBody UserRequestModel userRequestModel) {
        try {
            this.createUser.call(UserRequestModel.toUser(userRequestModel));

            return new ResponseEntity<UserResponseModel>(new UserResponseModel(HttpStatus.OK.value(), HttpStatus.OK.name()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
