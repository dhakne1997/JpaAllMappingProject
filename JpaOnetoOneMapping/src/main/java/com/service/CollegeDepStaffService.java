package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CollegeDepStaff;
import com.repo.CollegeDepStaffRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeDepStaffService {

    @Autowired
    private CollegeDepStaffRepository collegeDepStaffRepository;

    public CollegeDepStaff saveCollegeDepStaff(CollegeDepStaff collegeDepStaff) {
        return collegeDepStaffRepository.save(collegeDepStaff);
    }

    public List<CollegeDepStaff> getAllCollegeDepStaff() {
        return collegeDepStaffRepository.findAll();
    }

    public Optional<CollegeDepStaff> getCollegeDepStaffById(Long id) {
        return collegeDepStaffRepository.findById(id);
    }

    public CollegeDepStaff updateCollegeDepStaff(Long id, CollegeDepStaff collegeDepStaffDetails) {
        CollegeDepStaff collegeDepStaff = collegeDepStaffRepository.findById(id).orElseThrow();
        collegeDepStaff.setName(collegeDepStaffDetails.getName());
        collegeDepStaff.setDepartment(collegeDepStaffDetails.getDepartment());
        collegeDepStaff.setPosition(collegeDepStaffDetails.getPosition());
        collegeDepStaff.setEmail(collegeDepStaffDetails.getEmail());
        collegeDepStaff.setPhone(collegeDepStaffDetails.getPhone());
        collegeDepStaff.setLibraryStaff(collegeDepStaffDetails.getLibraryStaff());
        return collegeDepStaffRepository.save(collegeDepStaff);
    }

    public void deleteCollegeDepStaff(Long id) {
        collegeDepStaffRepository.deleteById(id);
    }
}

