package com.juniorbocelli.xmobotscase.runway.domain.repositories;

import java.util.List;

import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

public interface RunwayRepository {
    public void createRunway(Runway runway);

    public void deleteRunway(Long id);

    public Runway getRunway(Long id);

    public List<Runway> getRunways();
}
