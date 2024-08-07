package com.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CollegeDepStaff;


@Repository
public interface CollegeDepStaffRepository extends JpaRepository<CollegeDepStaff, Long> {
}
