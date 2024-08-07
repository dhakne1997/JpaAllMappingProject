package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.CollegeDepStaff;
import com.service.CollegeDepStaffService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/collegeDeptStaff")
public class CollegeDeptStaffController {

	@Autowired
    private CollegeDepStaffService collegeDepStaffService;


    // CollegeDepStaff Endpoints

    @PostMapping("/collegeDepStaff")
    public CollegeDepStaff createCollegeDepStaff(@RequestBody CollegeDepStaff collegeDepStaff) {
        return collegeDepStaffService.saveCollegeDepStaff(collegeDepStaff);
    }

    @GetMapping("/collegeDepStaff")
    public List<CollegeDepStaff> getAllCollegeDepStaff() {
        return collegeDepStaffService.getAllCollegeDepStaff();
    }

    @GetMapping("/collegeDepStaff/{id}")
    public ResponseEntity<CollegeDepStaff> getCollegeDepStaffById(@PathVariable Long id) {
        Optional<CollegeDepStaff> collegeDepStaff = collegeDepStaffService.getCollegeDepStaffById(id);
        return collegeDepStaff.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/collegeDepStaff/{id}")
    public ResponseEntity<CollegeDepStaff> updateCollegeDepStaff(@PathVariable Long id, @RequestBody CollegeDepStaff collegeDepStaffDetails) {
        CollegeDepStaff updatedCollegeDepStaff = collegeDepStaffService.updateCollegeDepStaff(id, collegeDepStaffDetails);
        return ResponseEntity.ok(updatedCollegeDepStaff);
    }

    @DeleteMapping("/collegeDepStaff/{id}")
    public ResponseEntity<Void> deleteCollegeDepStaff(@PathVariable Long id) {
        collegeDepStaffService.deleteCollegeDepStaff(id);
        return ResponseEntity.noContent().build();
    }
    
}

