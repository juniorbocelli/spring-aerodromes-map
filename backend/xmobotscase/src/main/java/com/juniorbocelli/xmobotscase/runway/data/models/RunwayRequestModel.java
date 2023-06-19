package com.juniorbocelli.xmobotscase.runway.data.models;

import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

public class RunwayRequestModel {
    private Long id;
    private String designation;
    private Long width;
    private Long length;

    public static Runway toRunway(RunwayRequestModel runwayRequestModel) {
        Runway runway = new Runway();
        runway.setId(runwayRequestModel.getId());
        runway.setDesignation(runwayRequestModel.getDesignation());
        runway.setWidth(runwayRequestModel.getLength());
        runway.setWidth(runwayRequestModel.getLength());

        return runway;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }
}
