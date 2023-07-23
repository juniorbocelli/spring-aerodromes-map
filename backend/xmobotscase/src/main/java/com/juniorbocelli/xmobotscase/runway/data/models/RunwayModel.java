package com.juniorbocelli.xmobotscase.runway.data.models;

import java.util.List;
import java.util.stream.Collectors;

import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeModel;
import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "runways")
public class RunwayModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "designation")
    private String designation;
    @Column(name = "width")
    private Long width;
    @Column(name = "length")
    private Long length;
    @ManyToOne
    @JoinColumn(name = "aerodrome_id", nullable = false)
    private 
    AerodromeModel aerodrome;

    public RunwayModel(Long id, String designation, Long width, Long length) {
        this.id = id;
        this.designation = designation;
        this.width = width;
        this.length = length;
    }

    public RunwayModel() {

    }

    public Runway toRunway(RunwayModel runwayModel) {
        Runway runway = new Runway();
        runway.setId(runwayModel.getId());
        runway.setDesignation(runwayModel.getDesignation());
        runway.setWidth(runwayModel.getWidth());
        runway.setLength(runwayModel.getLength());

        return runway;
    }

    public RunwayModel toRunwayModel(Runway runway) {
        RunwayModel runwayModel = new RunwayModel();
        runwayModel.setId(runway.getId());
        runwayModel.setDesignation(runway.getDesignation());
        runwayModel.setWidth(runway.getWidth());
        runwayModel.setLength(runway.getLength());

        return runwayModel;
    }

    public List<Runway> toRunwayList(List<RunwayModel> runwayModels) {
        return runwayModels.stream().map(temp -> {
            Runway objRunway = new Runway();
            objRunway.setId(temp.getId());
            objRunway.setDesignation(temp.getDesignation());
            objRunway.setWidth(temp.getWidth());
            objRunway.setLength(temp.getLength());

            return objRunway;
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
