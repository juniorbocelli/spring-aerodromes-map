package com.juniorbocelli.xmobotscase.aerodrome.data.models;

import java.util.List;
import java.util.stream.Collectors;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Coordinates;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;
import com.juniorbocelli.xmobotscase.user.data.models.UserResponseModel;

public class AerodromeResponseModel {
    private Long id;
    private String name;
    private String city;
    private String description;

    private List<Runway> runways;

    private String positionX;
    private String positionY;

    private String createdAt;

    public AerodromeResponseModel() {

    }

    public AerodromeResponseModel(Long id, String name, String city, String description, List<Runway> runways,
            String positionX, String positionY, String createdAt) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
        this.runways = runways;
        this.positionX = positionX;
        this.positionY = positionY;
        this.createdAt = createdAt;
    }

    public static AerodromeResponseModel toAerodromeResponseModel(Aerodrome aerodrome) {
        AerodromeResponseModel aerodromeResponseModel = new AerodromeResponseModel();
        aerodromeResponseModel.setId(aerodrome.getId());
        aerodromeResponseModel.setName(aerodrome.getName());
        aerodromeResponseModel.setCity(aerodrome.getCity());
        aerodromeResponseModel.setDescription(aerodrome.getDescription());
        aerodromeResponseModel.setRunways(aerodrome.getRunways());
        aerodromeResponseModel.setPositionX(aerodrome.getCoordinates().getPositionX());
        aerodromeResponseModel.setPositionY(aerodrome.getCoordinates().getPositionY());
        aerodromeResponseModel.setCreatedAt(aerodrome.getCreatedAt());

        return aerodromeResponseModel;
    }

    public static List<AerodromeResponseModel> toAerodromeResponseModelList(List<Aerodrome> aerodromes) {
        return aerodromes.stream().map(temp -> {
            AerodromeResponseModel aerodromeResponseModel = AerodromeResponseModel.toAerodromeResponseModel(temp);

            return aerodromeResponseModel;
        }).collect(Collectors.toList());
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
