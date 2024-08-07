package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.LibraryStaff;

@Repository
public interface LibraryStaffRepository extends JpaRepository<LibraryStaff, Long> {
}

