package com.juniorbocelli.xmobotscase.aerodrome.data.models;

import java.util.List;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Coordinates;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

public class AerodromeJsonRequestModel {
    private String name;
    private String city;
    private String description;
    private List<Runway> runways;
    private String created_at;

    public static Aerodrome toAerodrome(AerodromeJsonRequestModel aerodromeJsonRequestModel) {

    }

    private Coordinates coordinatesFromDescription() {

    };

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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
