package com.system.farmerrefund.service;

import com.system.farmerrefund.entity.Farmer;
import com.system.farmerrefund.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

    public Farmer getFarmerById(Integer id) {
        return farmerRepository.findById(id).orElse(null);
    }

    public List<Farmer> getFarmersByName(String name) {
        return farmerRepository.findByFullName(name);
    }

    public void saveFarmer(Farmer farmer) {
        farmerRepository.save(farmer);
    }

    public void deleteFarmer(Integer id) {
        farmerRepository.deleteById(id);
    }
}
