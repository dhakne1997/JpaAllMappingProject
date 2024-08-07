package com.service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Department;
import com.entity.Student;
import com.repo.StudentRepository;
import com.zaxxer.hikari.util.ClockSource.Factory;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    SessionFactory factory;

    public Student save(Student student) {
    	
    	Session session=factory.openSession();
    	session.beginTransaction();
    	
    	
    	Department department=student.getDepartment();
    	
    	
    	
        if (student.getDepartment() != null && student.getDepartment().getId() != null) {
//            Department department = departmentService.findById(student.getDepartment().getId());
//            student.setDepartment(department);
        	session.save(department);
        }
        session.save(student);
        session.getTransaction().commit();
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
//        return studentRepository.findById(id).orElse(null);
    	
    	Session session=factory.openSession();
    	Student student=session.get(Student.class, id);
    	session.close();
    	return student;
    	
    }
}
