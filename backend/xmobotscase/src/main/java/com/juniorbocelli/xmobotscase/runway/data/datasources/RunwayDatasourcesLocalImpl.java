package com.juniorbocelli.xmobotscase.runway.data.datasources;

import java.util.List;
import java.util.Optional;

import com.juniorbocelli.xmobotscase.runway.data.models.RunwayModel;

public class RunwayDatasourcesLocalImpl implements RunwayDatasourcesLocal {
    final JpaRunwayRepository jpaRunwayRepository;

    public RunwayDatasourcesLocalImpl(JpaRunwayRepository jpaRunwayRepository) {
        this.jpaRunwayRepository = jpaRunwayRepository;
    }

    public void createRunway(RunwayModel runwayModel) {
        jpaRunwayRepository.save(runwayModel);
    }

    public void deleteRunway(Long id) {
        jpaRunwayRepository.deleteById(id);
    }

    public RunwayModel getRunway(Long id) {
        Optional<RunwayModel> op = jpaRunwayRepository.findById(id);

        return op.get();
    }

    public List<RunwayModel> getRunways() {
        return jpaRunwayRepository.findAll();
    };
};