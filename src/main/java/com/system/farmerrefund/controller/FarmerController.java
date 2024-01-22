package com.system.farmerrefund.controller;

import com.system.farmerrefund.entity.Farmer;
import com.system.farmerrefund.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/farmers")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @GetMapping("")
    public String showFarmers(Model model) {
        List<Farmer> farmers = farmerService.getAllFarmers();
        model.addAttribute("farmers", farmers);
        return "farmers"; // Assuming "farmers.html" is the Thymeleaf template
    }

    @GetMapping("/new")
    public String addFarmer(Model model, Integer currentFarmerId) {
        Farmer farmer = new Farmer(currentFarmerId);
        model.addAttribute("farmer", farmer);
        return "add_farmer";
    }

   /* @GetMapping("/{farmerId}")
    public String editFarmer(@PathVariable Integer farmerId, Model model) {
        Farmer farmer = FarmerService.getFarmerById(farmerId);
        model.addAttribute("farmer", farmer);
        return "add_farmer";
    }
*/
    @PostMapping("/new")
    public String saveFarmer(@ModelAttribute("farmer") Farmer farmer, Model model) {
        farmerService.saveFarmer(farmer);
        model.addAttribute("farmers", farmerService.getAllFarmers());
        return "farmers";
    }

    @DeleteMapping("/{farmerId}")
    public String deleteFarmer(@PathVariable Integer farmerId) {
        farmerService.deleteFarmer(farmerId);
        return "farmers";
    }
}