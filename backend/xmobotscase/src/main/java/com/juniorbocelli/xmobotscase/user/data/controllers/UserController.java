package com.juniorbocelli.xmobotscase.user.data.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juniorbocelli.xmobotscase.user.data.models.UserRequestModel;
import com.juniorbocelli.xmobotscase.user.data.models.UserResponseModel;
import com.juniorbocelli.xmobotscase.user.domain.entities.User;
import com.juniorbocelli.xmobotscase.user.domain.usecases.CreateUser;
import com.juniorbocelli.xmobotscase.user.domain.usecases.GetUsers;

@RestController
public class UserController {
    final CreateUser createUser;
    final GetUsers getUsers;

    UserController(CreateUser createUser, GetUsers getUsers) {
        this.createUser = createUser;
        this.getUsers = getUsers;
    }

    @PostMapping(path = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseModel> create(@RequestBody UserRequestModel userRequestModel) {
        try {
            this.createUser.call(UserRequestModel.toUser(userRequestModel));

            return new ResponseEntity<UserResponseModel>(
                    new UserResponseModel(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "user")
    public ResponseEntity<List<UserResponseModel>> getUsers() {
        try {
            List<User> users = this.getUsers.call();
            
            return new ResponseEntity<List<UserResponseModel>>(UserResponseModel.toUserResponseModelList(users), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
