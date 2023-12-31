package com.juniorbocelli.xmobotscase.aerodrome.data.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.runway.data.models.RunwayModel;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aerodromes")
public class AerodromeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "city", nullable = false, length = 100)
    private String city;
    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "dms", nullable = false, length = 22)
    private String dms;

    @OneToMany(mappedBy = "aerodrome", cascade = CascadeType.ALL)
    private List<RunwayModel> runways = new ArrayList<>();

    @Column(name = "created_at", nullable = false, length = 10)
    private String createdAt;

    public AerodromeModel(Long id, String name, String city, String description, String dms, List<RunwayModel> runways,
            String createdAt) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
        this.dms = dms;

        this.runways = runways;
        this.createdAt = createdAt;
    }

    public AerodromeModel() {
        super();
    }

    public Aerodrome toAerodrome(AerodromeModel aerodromeModel) {
        Aerodrome aerodrome = new Aerodrome();
        aerodrome.setId(aerodromeModel.getId());
        aerodrome.setName(aerodromeModel.getName());
        aerodrome.setCity(aerodromeModel.getCity());
        aerodrome.setDescription(aerodromeModel.getDescription());
        aerodrome.setDms(aerodromeModel.getDms());
        aerodrome.setCreatedAt(aerodromeModel.getCreatedAt());
        aerodrome.setRunways(aerodromeModel.getRunways().stream().map(temp -> {
            Runway runway = new Runway();
            runway.setId(temp.getId());
            runway.setDesignation(temp.getDesignation());
            runway.setWidth(temp.getWidth());
            runway.setLength(temp.getLength());

            return runway;
        }).collect(Collectors.toList()));
        aerodrome.setCreatedAt(aerodromeModel.getCreatedAt());

        return aerodrome;
    }

    public AerodromeModel toAerodromeModel(Aerodrome aerodrome) {
        AerodromeModel aerodromeModel = new AerodromeModel();
        aerodromeModel.setId(aerodrome.getId());
        aerodromeModel.setName(aerodrome.getName());
        aerodromeModel.setCity(aerodrome.getCity());
        aerodromeModel.setDescription(aerodrome.getDescription());
        aerodromeModel.setDms(aerodrome.getDms());
        aerodromeModel.setCreatedAt(aerodrome.getCreatedAt());
        aerodromeModel.setRunways(aerodrome.getRunways().stream().map(temp -> {
            RunwayModel runwayModel = new RunwayModel();
            runwayModel.setId(temp.getId());
            runwayModel.setDesignation(temp.getDesignation());
            runwayModel.setLength(temp.getLength());
            runwayModel.setWidth(temp.getWidth());

            return runwayModel;
        }).collect(Collectors.toList()));
        aerodromeModel.addRunways();
        aerodromeModel.setCreatedAt(aerodrome.getCreatedAt());

        return aerodromeModel;
    }

    public List<Aerodrome> toAerodromeList(List<AerodromeModel> aerodromeModels) {
        return aerodromeModels.stream().map(temp -> {
            Aerodrome objAerodrome = new Aerodrome();
            objAerodrome.setId(temp.getId());
            objAerodrome.setName(temp.getName());
            objAerodrome.setCity(temp.getCity());
            objAerodrome.setDescription(temp.getDescription());
            objAerodrome.setDms(temp.getDms());
            objAerodrome.setCreatedAt(temp.getCreatedAt());
            objAerodrome.setRunways(temp.getRunways().stream().map(obj -> {
                Runway runway = new Runway();
                runway.setId(obj.getId());
                runway.setDesignation(obj.getDesignation());
                runway.setLength(obj.getLength());
                runway.setWidth(obj.getWidth());

                return runway;
            }).collect(Collectors.toList()));

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

    public String getDms() {
        return dms;
    }

    public void setDms(String dms) {
        this.dms = dms;
    }

    public List<RunwayModel> getRunways() {
        return runways;
    }

    public void setRunways(List<RunwayModel> runways) {
        this.runways = runways;
    }

    public void addRunways() {
        this.runways.forEach(t -> t.setAerodrome(this));
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
