package com.juniorbocelli.xmobotscase.data.repositories;

import java.util.List;

import com.juniorbocelli.xmobotscase.data.datasources.user.UserDatasourcesLocal;
import com.juniorbocelli.xmobotscase.data.models.UserModel;
import com.juniorbocelli.xmobotscase.domain.entities.User;
import com.juniorbocelli.xmobotscase.domain.repositories.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    final UserDatasourcesLocal userDatasourcesLocal;

    public UserRepositoryImpl(UserDatasourcesLocal userDatasourcesLocal) {
        this.userDatasourcesLocal = userDatasourcesLocal;
    }

    public void createUser(User user) {
        UserModel userModel = new UserModel();
        this.userDatasourcesLocal.createUser(userModel.toUserModel(user));
    }

    public void deleteUser(Long id) {
        userDatasourcesLocal.deleteUser(id);
    }

    public User getUser(Long id) {
        UserModel userModel = new UserModel();

        return userModel.toUser(userDatasourcesLocal.getUser(id));
    }

    public List<User> getUsers() {
        UserModel userModel = new UserModel();

        return userModel.toUserList(userDatasourcesLocal.getUsers());
    }
}