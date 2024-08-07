package com.many.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.many.entity.DepartmentStaff;

public interface DepartmentStaffRepository extends JpaRepository<DepartmentStaff, Long> {
}
