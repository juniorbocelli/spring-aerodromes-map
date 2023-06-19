package com.juniorbocelli.xmobotscase.runway.domain.usecases;

import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;
import com.juniorbocelli.xmobotscase.runway.domain.repositories.RunwayRepository;

public class CreateRunway {
    final RunwayRepository runwayRepository;

    public CreateRunway(RunwayRepository runwayRepository) {
        this.runwayRepository = runwayRepository;
    }

    public void call(Runway runway) {
        runwayRepository.createRunway(runway);
    }
}
