package com.juniorbocelli.xmobotscase.user.data.datasources;

import java.util.List;

import com.juniorbocelli.xmobotscase.user.data.models.UserModel;

public interface UserDatasourcesLocal {
    public void createUser(UserModel userModel);

    public void deleteUser(Long id);

    public UserModel getUser(Long id);

    public List<UserModel> getUsers();

    UserModel findByUsername(String username);
}
