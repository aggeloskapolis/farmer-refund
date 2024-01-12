package com.system.farmerrefund.service;

import com.system.farmerrefund.entity.Inspector;
import com.system.farmerrefund.repository.InspectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectorService {

    @Autowired
    private InspectorRepository inspectorRepository;

    public List<Inspector> getAllInspectors() {
        return inspectorRepository.findAll();
    }

    public Inspector getInspectorById(Integer id) {
        return inspectorRepository.findById(id).orElse(null);
    }

    public void saveInspector(Inspector inspector) {
        inspectorRepository.save(inspector);
    }

    public void deleteInspector(Integer id) {
        inspectorRepository.deleteById(id);
    }
}
