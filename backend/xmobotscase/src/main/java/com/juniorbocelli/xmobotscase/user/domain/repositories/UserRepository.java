package com.juniorbocelli.xmobotscase.user.domain.repositories;

import java.util.List;

import com.juniorbocelli.xmobotscase.user.domain.entities.User;

public interface UserRepository {
    public void createUser(User user);

    public void deleteUser(Long id);

    public User getUser(Long id);

    public List<User> getUsers();
}
