package com.system.farmerrefund.repository;

import com.system.farmerrefund.entity.Inspector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectorRepository extends JpaRepository<Inspector, Integer> {
    // **You can add custom query methods here if needed
}
