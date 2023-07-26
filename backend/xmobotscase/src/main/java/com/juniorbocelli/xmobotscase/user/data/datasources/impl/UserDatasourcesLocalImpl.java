package com.juniorbocelli.xmobotscase.user.data.datasources.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.juniorbocelli.xmobotscase.user.data.datasources.JpaUserRepository;
import com.juniorbocelli.xmobotscase.user.data.datasources.UserDatasourcesLocal;
import com.juniorbocelli.xmobotscase.user.data.models.UserModel;

public class UserDatasourcesLocalImpl implements UserDatasourcesLocal {
    final JpaUserRepository jpaUserRepository;

    public UserDatasourcesLocalImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public void createUser(UserModel userModel) {
        this.jpaUserRepository.save(userModel);
    }

    public void deleteUser(Long id) {
        this.jpaUserRepository.deleteById(id);
    }

    public UserModel getUser(Long id) {
        Optional<UserModel> op = this.jpaUserRepository.findById(id);

        return op.get();
    }

    public List<UserModel> getUsers() {
        return this.jpaUserRepository.findAll();
    };

    public UserModel findByUsername(String email) {
        UserModel userModel = new UserModel();
        userModel.setEmail(email);

        Example<UserModel> example = Example.of(userModel);

        Optional<UserModel> op = this.jpaUserRepository.findOne(example);

        if (!op.isPresent())
            return null;

        return op.get();
    }
};
