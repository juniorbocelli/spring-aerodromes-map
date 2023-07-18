package com.juniorbocelli.xmobotscase.aerodrome.data.models;

import java.util.List;
import java.util.stream.Collectors;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.utils.CoordenateTools;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

public class AerodromeJsonRequestModel {
    private String name;
    private String city;
    private String description;
    private String dms;
    private List<Runway> runways;
    private String created_at;

    public AerodromeJsonRequestModel(String name, String city, String description, List<Runway> runways,
            String created_at) {
        this.name = name;
        this.city = city;
        this.description = description;
        this.setDmsFromDescription();
        this.runways = runways;
        this.created_at = created_at;
    }

    public static Aerodrome toAerodrome(AerodromeJsonRequestModel aerodromeJsonRequestModel) {
        Aerodrome aerodrome = new Aerodrome();
        aerodrome.setName(aerodromeJsonRequestModel.getName());
        aerodrome.setCity(aerodromeJsonRequestModel.getCity());
        aerodrome.setDescription(aerodromeJsonRequestModel.getDescription());
        aerodrome.setDms(aerodromeJsonRequestModel.getDms());
        aerodrome.setRunways(aerodromeJsonRequestModel.getRunways().stream().map(temp -> {
            Runway runway = new Runway();
            runway.setId(temp.getId());
            runway.setDesignation(temp.getDesignation());
            runway.setWidth(temp.getWidth());
            runway.setLength(temp.getLength());

            return runway;
        }).collect(Collectors.toList()));
        aerodrome.setCreatedAt(aerodromeJsonRequestModel.getCreated_at());

        return aerodrome;
    }

    private void setDmsFromDescription() {
        CoordenateTools coordenateTools = new CoordenateTools(this.description);
        this.dms = coordenateTools.getDmsString();
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

    public String getDms() {
        return dms;
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
