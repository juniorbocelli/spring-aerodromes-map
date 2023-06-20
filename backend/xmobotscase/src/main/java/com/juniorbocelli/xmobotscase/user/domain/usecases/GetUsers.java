package com.juniorbocelli.xmobotscase.user.domain.usecases;

import java.util.List;

import com.juniorbocelli.xmobotscase.user.domain.entities.User;
import com.juniorbocelli.xmobotscase.user.domain.repositories.UserRepository;

public class GetUsers {
    final UserRepository userRepository;

    public GetUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> call() {
        return this.userRepository.getUsers();
    }
}
