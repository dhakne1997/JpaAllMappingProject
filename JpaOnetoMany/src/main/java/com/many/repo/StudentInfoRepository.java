package com.many.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.many.entity.DepartmentStaff;
import com.many.entity.StudentInfo;

import jakarta.transaction.Transactional;
@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {
	
}
