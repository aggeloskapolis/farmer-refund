package com.system.farmerrefund.entity;

import jakarta.persistence.*;

@Entity
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer Id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private String farmersNumber;

    @Column
    private String email;

    public Farmer() {

    }

    public Integer getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFarmersNumber() {
        return farmersNumber;
    }

    public String getEmail() {
        return email;
    }


    public void setId(Integer id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFarmersNumber(String farmersNumber) {
        this.farmersNumber = farmersNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Farmer(Integer currentFarmerId) {
    }

    public Farmer(String firstName, String lastName, String email, String farmersNumber){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.farmersNumber=farmersNumber;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", farmersNumber='" + farmersNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}