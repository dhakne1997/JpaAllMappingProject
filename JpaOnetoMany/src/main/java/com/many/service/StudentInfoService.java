package com.many.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.many.entity.StudentInfo;
import com.many.repo.StudentInfoRepository;

@Service
public class StudentInfoService {

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    public StudentInfo createStudentInfo(StudentInfo studentInfo) {
        return studentInfoRepository.save(studentInfo);
    }

    public StudentInfo getStudentInfo(Long id) {
        return studentInfoRepository.findById(id).orElseThrow();
    }

    public List<StudentInfo> getAllStudentInfo() {
        return studentInfoRepository.findAll();
    }

    public StudentInfo updateStudentInfo(Long id, StudentInfo studentInfo) {
        StudentInfo existingStudentInfo = getStudentInfo(id);
        existingStudentInfo.setName(studentInfo.getName());
        existingStudentInfo.setAge(studentInfo.getAge());
        existingStudentInfo.setEmail(studentInfo.getEmail());
        existingStudentInfo.setAddress(studentInfo.getAddress());
        existingStudentInfo.setDepartmentStaff(studentInfo.getDepartmentStaff());
        return studentInfoRepository.save(existingStudentInfo);
        
    }

	public void deleteStudentInfo(Long id) {
		studentInfoRepository.deleteById(id);
		
	}
    
    
    
}
       