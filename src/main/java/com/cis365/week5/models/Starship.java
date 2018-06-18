package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "STARSHIP")
public class Starship {



    public Starship(){}

    @Id
    @Column(name = "STARSHIPID")
    private String starshipId;

    @Column(name = "NAME")
    private String starshipName;

    @Column(name = "CREWSIZE")
    private int starshipCrewsize;

    @Column(name = "SHIPCLASS")
    private String starshipClass;

    @Column(name = "LAUNCHSTARDATE")
    private int starshipLaunchStarDate;



    public String getStarshipId() {
        return starshipId;
    }

    public void setStarshipId(String id) {
        this.starshipId = id;
    }

    public String getStarshipName() {
        return starshipName;
    }

    public void setStarshipName(String name) {
        this.starshipName = name;
    }

    public int getStarshipCrewsize() {
        return starshipCrewsize;
    }

    public void setStarshipCrewsize(int size) {
        this.starshipCrewsize = size;
    }

    public int getStarshipLaunchStarDate() {
        return starshipLaunchStarDate;
    }

    public void setStarshipLaunchStarDate(int date) {
        this.starshipLaunchStarDate = date;
    }



}
