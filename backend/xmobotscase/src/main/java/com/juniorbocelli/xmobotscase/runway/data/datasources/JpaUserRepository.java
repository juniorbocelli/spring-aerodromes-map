package com.juniorbocelli.xmobotscase.user.data.datasources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juniorbocelli.xmobotscase.user.data.models.UserModel;

@Repository
public interface JpaUserRepository extends JpaRepository<UserModel, Long> {

}
