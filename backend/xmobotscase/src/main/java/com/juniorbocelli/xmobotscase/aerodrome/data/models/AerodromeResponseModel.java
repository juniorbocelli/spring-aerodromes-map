package com.juniorbocelli.xmobotscase.aerodrome.data.models;

import java.util.List;
import java.util.stream.Collectors;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

public class AerodromeResponseModel {
    private Long id;
    private String name;
    private String city;
    private String description;
    private String dms;

    private List<Runway> runways;

    private String createdAt;

    public AerodromeResponseModel() {

    }

    public AerodromeResponseModel(Long id, String name, String city, String description, String dms,
            List<Runway> runways, String createdAt) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
        this.dms = dms;
        this.runways = runways;
        this.createdAt = createdAt;
    }

    public static AerodromeResponseModel toAerodromeResponseModel(Aerodrome aerodrome) {
        AerodromeResponseModel aerodromeResponseModel = new AerodromeResponseModel();
        aerodromeResponseModel.setId(aerodrome.getId());
        aerodromeResponseModel.setName(aerodrome.getName());
        aerodromeResponseModel.setCity(aerodrome.getCity());
        aerodromeResponseModel.setDescription(aerodrome.getDescription());
        aerodromeResponseModel.setDms(aerodrome.getDms());
        aerodromeResponseModel.setRunways(aerodrome.getRunways());
        aerodromeResponseModel.setCreatedAt(aerodrome.getCreatedAt());

        return aerodromeResponseModel;
    };

    public static List<AerodromeResponseModel> toAerodromeResponseModelList(List<Aerodrome> aerodromes) {
        return aerodromes.stream().map(temp -> {
            AerodromeResponseModel aerodromeResponseModel = AerodromeResponseModel.toAerodromeResponseModel(temp);

            return aerodromeResponseModel;
        }).collect(Collectors.toList());
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
