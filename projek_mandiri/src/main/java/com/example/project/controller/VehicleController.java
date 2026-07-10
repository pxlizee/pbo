package com.example.project.controller;

import com.example.project.model.Vehicle;
import com.example.project.repository.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        model.addAttribute("vehicles", vehicles);
        model.addAttribute("newVehicle", new Vehicle());
        return "index";
    }

    @PostMapping("/add")
    public String addVehicle(@ModelAttribute("newVehicle") Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "redirect:/";
    }
}
