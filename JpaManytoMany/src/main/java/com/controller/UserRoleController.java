package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.Role;
import com.service.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;
    
    @PostMapping
    public Role createUserRole(@RequestBody Role userRole) {
        return userRoleService.saveUserRole(userRole);
    }
    
    @GetMapping
    public List<Role> getUserRoles() {
        return userRoleService.getUserRoles();
    }
    
    @GetMapping("/{id}")
    public Role getUserRole(@PathVariable Long id) {
        return userRoleService.getUserRole(id);
    }
    
    @PutMapping("/{id}")
    public Role updateUserRole(@PathVariable Long id, @RequestBody Role userRole) {
        return userRoleService.updateUserRole(id, userRole);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRole(id);
    }
}