package com.juniorbocelli.xmobotscase.aerodrome.data.models;

import java.util.List;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

public class AerodromeRequestModel {
    private Long id;
    private String name;
    private String city;
    private String description;

    private List<Runway> runways;

    private String positionX;
    private String positionY;

    public static Aerodrome toAerodrome(AerodromeRequestModel aerodromeRequestModel) {
        Aerodrome aerodrome = new Aerodrome();
        aerodrome.setId(aerodromeRequestModel.getId());
        aerodrome.setName(aerodromeRequestModel.getName());
        aerodrome.setCity(aerodromeRequestModel.getCity());
        aerodrome.setDescription(aerodromeRequestModel.getDescription());
        aerodrome.setRunways(aerodromeRequestModel.getRunways());
        aerodrome.setPositionX(aerodromeRequestModel.getPositionX());
        aerodrome.setPositionY(aerodromeRequestModel.getPositionY());

        return aerodrome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public void setRunways(List<Runway> runways) {
        this.runways = runways;
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }

}
