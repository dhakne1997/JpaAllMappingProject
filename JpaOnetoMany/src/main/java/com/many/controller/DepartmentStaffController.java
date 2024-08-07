package com.many.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.many.entity.DepartmentStaff;
import com.many.service.DepartmentStaffService;

@RestController
@RequestMapping("/department-staff")
public class DepartmentStaffController {

    @Autowired
    private DepartmentStaffService departmentStaffService;

    @PostMapping("/create")
    public DepartmentStaff createDepartmentStaff(@RequestBody DepartmentStaff departmentStaff) {
    	
 
        return departmentStaffService.createDepartmentStaff(departmentStaff);
    }

    @GetMapping("/{id}")
    public DepartmentStaff getDepartmentStaff(@PathVariable Long id) {
        return departmentStaffService.getDepartmentStaff(id);
    }

    @GetMapping
    public List<DepartmentStaff> getAllDepartmentStaff() {
        return departmentStaffService.getAllDepartmentStaff();
    }

    @PutMapping("/{id}")
    public DepartmentStaff updateDepartmentStaff(@PathVariable Long id, @RequestBody DepartmentStaff departmentStaff) {
        return departmentStaffService.updateDepartmentStaff(id, departmentStaff);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentStaff(@PathVariable Long id) {
        departmentStaffService.deleteDepartmentStaff(id);
    }
}