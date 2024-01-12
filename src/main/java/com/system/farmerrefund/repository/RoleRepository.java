package com.system.farmerrefund.repository;

import com.system.farmerrefund.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String roleName);
    //Role findByName(String roleName);
    //Optional<Object> findByName(String roleUser);
}

