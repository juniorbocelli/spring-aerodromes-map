package com.juniorbocelli.xmobotscase.runway.data.models;

import java.util.List;
import java.util.stream.Collectors;

import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

public class RunwayResponseModel {
    private Long id;
    private String designation;
    private Long width;
    private Long length;

    public RunwayResponseModel() {

    }

    public RunwayResponseModel(Long id, String designation, Long width, Long length) {
        this.id = id;
        this.designation = designation;
        this.width = width;
        this.length = length;
    }

    public static RunwayResponseModel toRunwayResponseModel(Runway runway) {
        RunwayResponseModel runwayResponseModel = new RunwayResponseModel();
        runwayResponseModel.setId(runway.getId());
        runwayResponseModel.setDesignation(runway.getDesignation());
        runwayResponseModel.setWidth(runway.getWidth());
        runwayResponseModel.setLength(runway.getLength());

        return runwayResponseModel;
    };

    public static List<RunwayResponseModel> toRunwayResponseModelList(List<Runway> runways) {
        return runways.stream().map(temp -> {
            RunwayResponseModel runwayResponseModel = RunwayResponseModel.toRunwayResponseModel(temp);

            return runwayResponseModel;
        }).collect(Collectors.toList());
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
