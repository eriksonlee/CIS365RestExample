package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "PLANET")
public class Planet {

    public Planet(){}

    @Id
    @Column(name = "PLANETID")
    private String planetId;

    @Column(name = "NAME")
    private String planetName;

    @Column(name = "RADIUS")
    private int planetRadius;

    @Column(name = "ATMOSPHERE")
    private String planetAtmosphere;



    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String id) {
        this.planetId = id;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String name) {
        this.planetName = name;
    }

    public int getPlanetRadius() {
        return planetRadius;
    }

    public void setPlanetRadius(int radius) {
        this.planetRadius = radius;
    }

    public String getPlanetAtmosphere() {
        return planetAtmosphere;
    }

    public void setPlanetAtmosphere(String atmosphere) {
        this.planetAtmosphere = atmosphere;
    }


}
