package com.system.farmerrefund.repository;


import com.system.farmerrefund.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
    // **Custom query method to find farmers by Last Name
    List<Farmer> findByLastName(String lastname);
}