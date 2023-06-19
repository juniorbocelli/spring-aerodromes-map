package com.juniorbocelli.xmobotscase.runway.data.datasources;

import java.util.List;

import com.juniorbocelli.xmobotscase.runway.data.models.RunwayModel;

public interface RunwayDatasourcesLocal {
    public void createRunway(RunwayModel runwayModel);

    public void deleteRunway(Long id);

    public RunwayModel getRunway(Long id);

    public List<RunwayModel> getRunways();
}
