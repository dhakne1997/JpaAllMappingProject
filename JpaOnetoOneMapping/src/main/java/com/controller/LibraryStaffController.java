package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.LibraryStaff;
import com.service.LibraryStaffService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libraryStaff")
public class LibraryStaffController {

	   @Autowired
	    private LibraryStaffService libraryStaffService;

    @PostMapping("/libraryStaff")
    public LibraryStaff createLibraryStaff(@RequestBody LibraryStaff libraryStaff) {
        return libraryStaffService.saveLibraryStaff(libraryStaff);
    }

    @GetMapping("/libraryStaff")
    public List<LibraryStaff> getAllLibraryStaff() {
        return libraryStaffService.getAllLibraryStaff();
    }

    @GetMapping("/libraryStaff/{id}")
    public ResponseEntity<LibraryStaff> getLibraryStaffById(@PathVariable Long id) {
        Optional<LibraryStaff> libraryStaff = libraryStaffService.getLibraryStaffById(id);
        return libraryStaff.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/libraryStaff/{id}")
    public ResponseEntity<LibraryStaff> updateLibraryStaff(@PathVariable Long id, @RequestBody LibraryStaff libraryStaffDetails) {
        LibraryStaff updatedLibraryStaff = libraryStaffService.updateLibraryStaff(id, libraryStaffDetails);
        return ResponseEntity.ok(updatedLibraryStaff);
    }

    @DeleteMapping("/libraryStaff/{id}")
    public ResponseEntity<Void> deleteLibraryStaff(@PathVariable Long id) {
        libraryStaffService.deleteLibraryStaff(id);
        return ResponseEntity.noContent().build();
    }
}


