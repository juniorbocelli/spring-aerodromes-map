package com.juniorbocelli.xmobotscase.runway.data.repositories;

import java.util.List;

import com.juniorbocelli.xmobotscase.runway.data.datasources.RunwayDatasourcesLocal;
import com.juniorbocelli.xmobotscase.runway.data.models.RunwayModel;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;
import com.juniorbocelli.xmobotscase.runway.domain.repositories.RunwayRepository;

public class RunwayRepositoryImpl implements RunwayRepository {
    final RunwayDatasourcesLocal runwayDatasourcesLocal;

    public RunwayRepositoryImpl(RunwayDatasourcesLocal runwayDatasourcesLocal) {
        this.runwayDatasourcesLocal = runwayDatasourcesLocal;
    }

    public void createRunway(Runway runway) {
        RunwayModel runwayModel = new RunwayModel();
        this.runwayDatasourcesLocal.createRunway(runwayModel.toRunwayModel(runway));
    }

    public void deleteRunway(Long id) {
        runwayDatasourcesLocal.deleteRunway(id);
    }

    public Runway getRunway(Long id) {
        RunwayModel runwayModel = new RunwayModel();

        return runwayModel.toRunway(runwayDatasourcesLocal.getRunway(id));
    }

    public List<Runway> getRunways() {
        RunwayModel runwayModel = new RunwayModel();

        return runwayModel.toRunwayList(runwayDatasourcesLocal.getRunways());
    }
}