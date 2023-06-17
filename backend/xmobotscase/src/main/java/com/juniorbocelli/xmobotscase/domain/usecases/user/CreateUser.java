package com.juniorbocelli.xmobotscase.domain.usecases.user;

import com.juniorbocelli.xmobotscase.domain.entities.User;
import com.juniorbocelli.xmobotscase.domain.repositories.UserRepository;

public class CreateUser {
    final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void call(User user) {
        userRepository.createUser(user);
    }
}
