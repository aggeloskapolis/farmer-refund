package com.system.farmerrefund.repository;


import com.system.farmerrefund.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
    List<Farmer> findByFullName(String fullname);
}