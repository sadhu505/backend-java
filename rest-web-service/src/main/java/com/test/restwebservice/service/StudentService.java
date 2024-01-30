package com.test.restwebservice.service;

import org.springframework.stereotype.Service;

import com.test.restwebservice.entity.Student;
import com.test.restwebservice.model.StudentModel;

@Service
public interface StudentService {
	Student saveStudent(StudentModel studentDto);
	StudentModel getStudent(String studentName);
	StudentModel getStudentById(Long id);
	String deleteStudent(Long id);
}
