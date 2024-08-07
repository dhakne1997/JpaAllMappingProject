package com.many.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.many.entity.DepartmentStaff;
import com.many.entity.StudentInfo;
import com.many.repo.DepartmentStaffRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentStaffService {

    @Autowired
    private DepartmentStaffRepository departmentStaffRepository;

    public DepartmentStaff createDepartmentStaff(DepartmentStaff departmentStaff) {
    	
    	List<StudentInfo> students = departmentStaff.getStudents();
    	for(StudentInfo s:students)
    	{
    		s.setDepartmentStaff(departmentStaff);
    	}
        return departmentStaffRepository.save(departmentStaff);
    }

    public DepartmentStaff getDepartmentStaff(Long id) {
        return departmentStaffRepository.findById(id).orElseThrow();
    }

    public List<DepartmentStaff> getAllDepartmentStaff() {
        return departmentStaffRepository.findAll();
    }

    public DepartmentStaff updateDepartmentStaff(Long id, DepartmentStaff departmentStaff) {
        DepartmentStaff existingDepartmentStaff = getDepartmentStaff(id);
        existingDepartmentStaff.setName(departmentStaff.getName());
        existingDepartmentStaff.setRole(departmentStaff.getRole());
        existingDepartmentStaff.setDepartment(departmentStaff.getDepartment());
        existingDepartmentStaff.setSalary(departmentStaff.getSalary());
        existingDepartmentStaff.setStudents(departmentStaff.getStudents());
        return departmentStaffRepository.save(existingDepartmentStaff);
    }

    public void deleteDepartmentStaff(Long id) {
        departmentStaffRepository.deleteById(id);
    }
}
