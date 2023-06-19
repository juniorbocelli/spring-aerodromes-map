package com.juniorbocelli.xmobotscase.aerodrome.data.models;

import java.util.List;
import java.util.stream.Collectors;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aerodromes")
public class AerodromeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String description;

    @OneToMany
    @JoinColumn(name = "runway_id")
    private List<Runway> runways;

    private String positionX;
    private String positionY;

    public AerodromeModel(Long id, String name, String city, String description, List<Runway> runways, String positionX,
            String positionY) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
        this.runways = runways;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public AerodromeModel() {

    }

    public Aerodrome toAerodrome(AerodromeModel aerodromeModel) {
        Aerodrome aerodrome = new Aerodrome();
        aerodrome.setId(aerodromeModel.getId());
        aerodrome.setName(aerodromeModel.getName());
        aerodrome.setCity(aerodromeModel.getCity());
        aerodrome.setDescription(aerodromeModel.getDescription());
        aerodrome.setRunways(aerodromeModel.getRunways());
        aerodrome.setPositionX(aerodromeModel.getPositionX());
        aerodrome.setPositionY(aerodromeModel.getPositionY());

        return aerodrome;
    }

    public AerodromeModel toAerodromeModel(Aerodrome aerodrome) {
        AerodromeModel aerodromeModel = new AerodromeModel();
        aerodromeModel.setId(aerodrome.getId());
        aerodromeModel.setName(aerodrome.getName());
        aerodromeModel.setCity(aerodrome.getCity());
        aerodromeModel.setDescription(aerodrome.getDescription());
        aerodromeModel.setRunways(aerodrome.getRunways());
        aerodromeModel.setPositionX(aerodrome.getPositionX());
        aerodromeModel.setPositionY(aerodrome.getPositionY());

        return aerodromeModel;
    }

    public List<Aerodrome> toAerodromeList(List<AerodromeModel> aerodromeModels) {
        return aerodromeModels.stream().map(temp -> {
            Aerodrome objAerodrome = new Aerodrome();
            objAerodrome.setId(temp.getId());
            objAerodrome.setName(temp.getName());
            objAerodrome.setCity(temp.getCity());
            objAerodrome.setDescription(temp.getDescription());
            objAerodrome.setRunways(temp.getRunways());
            objAerodrome.setPositionX(temp.getPositionX());
            objAerodrome.setPositionY(temp.getPositionY());

            return objAerodrome;
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
        this.positionX = positionY;
    }
}
