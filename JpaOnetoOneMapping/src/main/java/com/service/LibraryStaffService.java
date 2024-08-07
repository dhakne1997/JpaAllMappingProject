package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.LibraryStaff;
import com.repo.LibraryStaffRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryStaffService {

    @Autowired
    private LibraryStaffRepository libraryStaffRepository;

    public LibraryStaff saveLibraryStaff(LibraryStaff libraryStaff) {
        return libraryStaffRepository.save(libraryStaff);
    }

    public List<LibraryStaff> getAllLibraryStaff() {
        return libraryStaffRepository.findAll();
    }

    public Optional<LibraryStaff> getLibraryStaffById(Long id) {
        return libraryStaffRepository.findById(id);
    }

    public LibraryStaff updateLibraryStaff(Long id, LibraryStaff libraryStaffDetails) {
        LibraryStaff libraryStaff = libraryStaffRepository.findById(id).orElseThrow();
        libraryStaff.setName(libraryStaffDetails.getName());
        libraryStaff.setEmail(libraryStaffDetails.getEmail());
        libraryStaff.setPhone(libraryStaffDetails.getPhone());
        libraryStaff.setRole(libraryStaffDetails.getRole());
        return libraryStaffRepository.save(libraryStaff);
    }

    public void deleteLibraryStaff(Long id) {
        libraryStaffRepository.deleteById(id);
    }
}


