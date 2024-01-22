package com.system.farmerrefund.controller;

import com.system.farmerrefund.entity.Inspector;
import com.system.farmerrefund.service.InspectorService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class InspectorController {

    @Autowired
    private InspectorService inspectorService;

    @GetMapping("/inspectors")
    public String showInspectors(Model model) {
        List<Inspector> inspectors = inspectorService.getAllInspectors();
        model.addAttribute("inspectors", inspectors);
        return "inspectors";
    }

    @GetMapping("/addinspector")
    public String addInspector(Model model) {
        Inspector inspector = new Inspector();
        model.addAttribute("inspector", inspector);
        return "new_inspector";
    }

    @GetMapping("/{inspectorId}")
    public String editInspector(@PathVariable Integer inspectorId, Model model) {
        Inspector inspector = inspectorService.getInspectorById(inspectorId);
        model.addAttribute("inspector", inspector);
        return "add_inspector";
    }

    @PostMapping("/saveinspector")
    public String saveInspector(@ModelAttribute("inspector") Inspector inspector, Model model) {
        inspectorService.saveInspector(inspector);
        model.addAttribute("inspectors", inspectorService.getAllInspectors());
        return "inspectors";
    }

    @DeleteMapping("/{inspectorId}")
    public String deleteInspector(@PathVariable Integer inspectorId) {
        inspectorService.deleteInspector(inspectorId);
        return "inspectors";
    }
}