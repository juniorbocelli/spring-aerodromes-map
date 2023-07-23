package com.juniorbocelli.xmobotscase.aerodrome.data.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

public class AerodromeRequestModel {
    private Long id;
    private String name;
    private String city;
    private String description;
    private String dms;

    private List<Runway> runways;

    public static Aerodrome toAerodrome(AerodromeRequestModel aerodromeRequestModel) {
        Aerodrome aerodrome = new Aerodrome();
        aerodrome.setId(aerodromeRequestModel.getId());
        aerodrome.setName(aerodromeRequestModel.getName());
        aerodrome.setCity(aerodromeRequestModel.getCity());
        aerodrome.setDescription(aerodromeRequestModel.getDescription());

        if (aerodromeRequestModel.getDms() != null)
            aerodrome.setDms(aerodromeRequestModel.getDms());
        else
            aerodrome.setDmsFromDescription(aerodromeRequestModel.getDescription());

        aerodrome.setRunways(aerodromeRequestModel.getRunways());
        aerodrome.setCreatedAt(aerodromeRequestModel.getStringLocalDate());

        return aerodrome;
    }

    public String getStringLocalDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return formatter.format(date);
    };

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

    public String getDms() {
        return dms;
    }

    public void setDms(String dms) {
        this.dms = dms;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public void setRunways(List<Runway> runways) {
        this.runways = runways;
    }
}
