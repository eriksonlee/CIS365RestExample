package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "PLANETVISIT")
public class PlanetVisit {



    public PlanetVisit(){}

    @Id
    @Column(name = "PLANETID")
    private String planetId;

    @Id
    @Column(name = "STARSHIPID")
    private String starshipId;

    @Column(name = "ARRIVALSTARDATE")
    private int arrivalStarDate;

    @Column(name = "DEPARTURESTARDATE")
    private int departureStarDate;



    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String id) {
        this.planetId = id;
    }

    public String getStarshipId() {
        return starshipId;
    }

    public void setStarshipId(String name) {
        this.starshipId = name;
    }

    public int getArrivalStarDate() {
        return arrivalStarDate;
    }

    public void setArrivalStarDate(int date) {
        this.arrivalStarDate = date;
    }

    public int getDepartureStarDate() {
        return departureStarDate;
    }

    public void setDepartureStarDate(int date) {
        this.departureStarDate = date;
    }



}
