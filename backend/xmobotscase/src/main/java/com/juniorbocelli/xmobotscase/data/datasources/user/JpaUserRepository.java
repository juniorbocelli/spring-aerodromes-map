package com.juniorbocelli.xmobotscase.data.datasources.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juniorbocelli.xmobotscase.data.models.UserModel;

@Repository
public interface JpaUserRepository extends JpaRepository<UserModel, Long> {

}
