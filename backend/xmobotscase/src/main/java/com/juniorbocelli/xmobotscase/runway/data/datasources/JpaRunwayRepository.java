package com.juniorbocelli.xmobotscase.runway.data.datasources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juniorbocelli.xmobotscase.runway.data.models.RunwayModel;

@Repository
public interface JpaRunwayRepository extends JpaRepository<RunwayModel, Long> {

}
