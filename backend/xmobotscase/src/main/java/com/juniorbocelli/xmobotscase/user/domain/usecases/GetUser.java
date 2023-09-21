package com.juniorbocelli.xmobotscase.user.domain.usecases;

import com.juniorbocelli.xmobotscase.user.domain.entities.User;
import com.juniorbocelli.xmobotscase.user.domain.repositories.UserRepository;

public class GetUser {
    final UserRepository userRepository;

    public GetUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User call(Long id) {
        return this.userRepository.getUser(id);
    }
}
