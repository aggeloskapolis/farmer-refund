package com.system.farmerrefund.service;

import com.system.farmerrefund.entity.Application;
import com.system.farmerrefund.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private static ApplicationRepository applicationRepository;

    public List <Application> getApplicationsByFarmersId(Integer farmerId){
        return  applicationRepository.findByFarmerId(farmerId);
    }

    public void saveApplication(Application application){
        applicationRepository.save(application);

    }

    public void deleteApplication(Integer id){
        applicationRepository.deleteById(id);
    }

    public Optional<Application> getApplicationById(Integer applicationId) {
        return applicationRepository.findById(applicationId);
    }
}