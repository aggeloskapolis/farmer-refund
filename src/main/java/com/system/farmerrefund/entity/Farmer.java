package com.system.farmerrefund.entity;

import jakarta.persistence.*;

@Entity
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer Id;

    @Column
    private String fullName;
    @Column
    public String farmersNumber;

    @Column
    private String email;

    public Farmer() {

    }

    public Integer getId() {
        return Id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }


    public void setId(Integer id) {
        Id = id;
    }

    public void setFullName(String firstName) {
        this.fullName = firstName;
    }

    public void setFarmersNumber(String farmersNumber) {
        this.farmersNumber = farmersNumber;
    }



    public Farmer(Integer currentFarmerId) {
    }

    public Farmer(String fullName, String email, String farmersNumber){
        this.fullName=fullName;
        this.email=email;
        this.farmersNumber=farmersNumber;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "Id=" + Id +
                ", fullName='" + fullName + '\'' +
                ", farmersNumber='" + farmersNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}