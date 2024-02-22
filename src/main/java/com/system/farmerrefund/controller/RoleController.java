package com.system.farmerrefund.controller;

import com.system.farmerrefund.entity.Role;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("roles")
public class RoleController {

    private List<Role> roles = new ArrayList<>();

    @PostConstruct
    public void setup() {
        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");
        Role role3 = new Role("ROLE_FARMER");
        Role role4 = new Role("ROLE_INSPECTOR");
        roles.add(role1);
        roles.add(role2);
        roles.add(role3);
        roles.add(role4);
    }

    @GetMapping
    @ResponseBody
    public List<Role> getAllRoles() {
        return roles;
    }

    @GetMapping("/{roleName}")
    @ResponseBody
    public Role getRoleByName(@PathVariable String roleName) {
        return roles.stream()
                .filter(role -> role.getName().equals(roleName))
                .findFirst()
                .orElse(null);
    }
}

