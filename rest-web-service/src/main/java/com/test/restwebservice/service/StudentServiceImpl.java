package com.test.restwebservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.restwebservice.Exception.StudentNotFoundException;
import com.test.restwebservice.entity.Student;
import com.test.restwebservice.model.StudentModel;
import com.test.restwebservice.repo.StudentRepository;
import com.test.restwebservice.util.AppConstants;

@Component
public class StudentServiceImpl implements StudentService {
	
	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public Student saveStudent(StudentModel studentDto) {
		log.info("inside saveStudent serviceImpl..studentName: " + studentDto.getName());
		Student stuEnt = new Student();
		// dummy exception blocks
		if (studentDto.getAge() < 0) {
			throw new ArithmeticException("Age can not be negetive");
		}
		if (studentDto.getName().equalsIgnoreCase("santu")) {
			int remainder = 5/0;
		}
		BeanUtils.copyProperties(studentDto, stuEnt);
		Student savedStudent = studentRepo.save(stuEnt);
		log.info("student saved successfully!!");
		return savedStudent;
	}

	@Override
	public StudentModel getStudent(String studentName) {
		log.info("inside getStudent serviceImpl..studentName: " + studentName);
		Student resprespEnt = studentRepo.findByName(studentName);
		if (resprespEnt != null) {
			StudentModel respModel = new StudentModel();
			log.info("studentId is : " + resprespEnt.getId());
			BeanUtils.copyProperties(resprespEnt, respModel);
			return respModel;
		} else {
			throw new StudentNotFoundException("Student not found for the name: " + studentName);
		}
	}

	@Override
	public StudentModel getStudentById(Long id) {
		log.info("inside getStudentById serviceImpl.");
		Optional<Student> respEntOpt = studentRepo.findById(id);
		if (respEntOpt.isPresent()) {
			StudentModel respModel = new StudentModel();
			BeanUtils.copyProperties(respEntOpt.get(), respModel);
			return respModel;
		} else {
			throw new StudentNotFoundException("Student not found for the ID: " + id);
		}
	}

	@Override
	public String deleteStudent(Long id) {
		studentRepo.deleteById(id);
		log.info("student deleted successFully..");
		return AppConstants.SUCCESS_MSG;
	}

}
