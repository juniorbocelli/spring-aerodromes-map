package com.juniorbocelli.xmobotscase.aerodrome.data.datasources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeModel;

@Repository
public interface JpaAerodromeRepository extends JpaRepository<AerodromeModel, Long> {

};