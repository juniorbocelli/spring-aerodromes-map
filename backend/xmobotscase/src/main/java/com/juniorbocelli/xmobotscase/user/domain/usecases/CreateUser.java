package com.juniorbocelli.xmobotscase.user.domain.usecases;

import com.juniorbocelli.xmobotscase.user.domain.entities.User;
import com.juniorbocelli.xmobotscase.user.domain.repositories.UserRepository;

public class CreateUser {
    final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void call(User user) {
        userRepository.createUser(user);
    }
}
