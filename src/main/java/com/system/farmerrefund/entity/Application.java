package com.system.farmerrefund.entity;

import jakarta.persistence.*;

import java.net.Inet4Address;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name  ="applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String productionDetails;
    @Column
    private String location;
    @Column
    private String description;
    @Column
    private boolean approved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    public Application() {
    }

    public Application(String title, String productionDetails, String location, String description, boolean approved) {
        this.title = title;
        this.productionDetails = productionDetails;
        this.location = location;
        this.description = description;
        this.approved = approved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductionDetails() {
        return productionDetails;
    }

    public void setProductionDetails(String productionDetails) {
        this.productionDetails = productionDetails;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "farmer_application",
            joinColumns = @JoinColumn(name = "farmer_id"),
            inverseJoinColumns = @JoinColumn(name = "application_id"))
    private Set<Application> applications = new HashSet<>();
}

