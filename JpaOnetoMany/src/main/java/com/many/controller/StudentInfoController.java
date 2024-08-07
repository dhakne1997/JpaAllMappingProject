package com.many.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.many.entity.StudentInfo;
import com.many.service.StudentInfoService;

@RestController
@RequestMapping("/student-info")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    @PostMapping
    public StudentInfo createStudentInfo(@RequestBody StudentInfo studentInfo) {
        return studentInfoService.createStudentInfo(studentInfo);
    }

    @GetMapping("/{id}")
    public StudentInfo getStudentInfo(@PathVariable Long id) {
        return studentInfoService.getStudentInfo(id);
    }

    @GetMapping
    public List<StudentInfo> getAllStudentInfo() {
        return studentInfoService.getAllStudentInfo();
    }

    @PutMapping("/{id}")
    public StudentInfo updateStudentInfo(@PathVariable Long id, @RequestBody StudentInfo studentInfo) {
        return studentInfoService.updateStudentInfo(id, studentInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentInfo(@PathVariable Long id) {
        studentInfoService.deleteStudentInfo(id);
    }
}
