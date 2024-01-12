package com.system.farmerrefund.entity;

import jakarta.persistence.*;

@Entity
public class Inspector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer Id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String inspectorNumber;



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInspectorNumber() {
        return inspectorNumber;
    }

    public void setInspectorNumber(String inspectorNumber) {
        this.inspectorNumber = inspectorNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Inspector() {
    }

    public Inspector(String firstName, String lastName, String inspectorNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.inspectorNumber = inspectorNumber;
        this.email = email;
    }
}
