package com.system.farmerrefund.repository;

import com.system.farmerrefund.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findByFarmerId(Integer farmerId);
    // **You can add more query methods based on your requirements
}
