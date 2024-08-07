package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Role;
import com.repo.UserRoleRepository;

import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    
    public Role saveUserRole(Role userRole) {
        return userRoleRepository.save(userRole);
    }
    
    public List<Role> getUserRoles() {
        return userRoleRepository.findAll();
    }
    
    public Role getUserRole(Long id) {
        return userRoleRepository.findById(id).orElse(null);
    }
    
    public Role updateUserRole(Long id, Role userRole) {
    	Role existingUserRole = getUserRole(id);
        if (existingUserRole != null) {
            existingUserRole.setName(userRole.getName());
           existingUserRole.setPost(userRole.getPost());
           existingUserRole.setIsActive(userRole.getIsActive());
            return userRoleRepository.save(existingUserRole);
        }
        return null;
    }
    
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}