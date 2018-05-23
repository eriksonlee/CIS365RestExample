package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "PLANETVISIT")
public class PlanetVisit {



    public PlanetVisit(){}

    @Id
    @Column(name = "PLANETID")
    private String id;



}
