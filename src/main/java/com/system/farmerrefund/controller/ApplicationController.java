package com.system.farmerrefund.controller;

import com.system.farmerrefund.entity.Application;
import com.system.farmerrefund.entity.Farmer;
import com.system.farmerrefund.entity.User;
import com.system.farmerrefund.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/applications")
    public String showApplications(Model model) {
        List<Application> applications = applicationService.getAllApplications();
        model.addAttribute("applications", applications);
        return "applications";
    }

    @GetMapping("/myapplication")
    public String showMyApplications(Model model) {
        List<Application> applications = applicationService.getApplicationsByFarmersId(getCurrentFarmerId());
        model.addAttribute("applications", applications);
        return "myapplication";
    }

    @GetMapping("/newapplication")
    public String addApplication(Model model) {
        Application application = new Application();
        Integer currentFarmerId = getCurrentFarmerId();
        Farmer currentFarmer = new Farmer();
        currentFarmer.setId(currentFarmerId);
        application.setId(new Farmer(currentFarmerId).getId());
        model.addAttribute("application", application);
        return "new_application";
    }

    @GetMapping("/{applicationId}")
    public String editApplication(@PathVariable Integer applicationId, Model model) {
        Optional<Application> application = applicationService.getApplicationById(applicationId);
        model.addAttribute("application", application);
        return "edit_application";
    }

    @PostMapping("/saveApp")
    public String saveApplication(@ModelAttribute("application") Application application, Model model) {
        Integer currentFarmerId = getCurrentFarmerId();
        application.setFarmerId(currentFarmerId);
        applicationService.saveApplication(application);
        // Assuming you have a way to determine the current farmer (maybe from authentication)
        List<Application> applications = applicationService.getApplicationsByFarmersId(currentFarmerId);
        model.addAttribute("applications", applications);
        return "myapplication";
    }

    @DeleteMapping("/{applicationId}")
    public String deleteApplication(@PathVariable Integer applicationId) {
        applicationService.deleteApplication(applicationId);
        return "applications";
    }

    // Helper method to simulate getting the current farmer ID (replace it with actual logic)
    private Integer getCurrentFarmerId() {
        // Get the current authentication information from the SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // Get the principal object from the authentication
            Object principal = authentication.getPrincipal();

            // Check if the principal object is an instance of UserDetails
            if (principal instanceof Farmer) {
                // Cast the principal to UserDetails and retrieve the farmer ID
                return ((Farmer) principal).getId();
            }
        }

        // Default value or handle the case when the farmer ID is not available
        return 1; // Assuming a default farmer ID for the example
    }
}