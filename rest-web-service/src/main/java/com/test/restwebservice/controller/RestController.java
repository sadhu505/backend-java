package com.test.restwebservice.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.restwebservice.entity.Student;
import com.test.restwebservice.model.StudentModel;
import com.test.restwebservice.service.StudentService;
import com.test.restwebservice.util.AppResponse;

import jakarta.validation.Valid;

@org.springframework.web.bind.annotation.RestController()
@RequestMapping("student")
@Validated
public class RestController {
	
	@Autowired
	StudentService service;
	
	@Autowired
	MessageSource msgSource;
	
	private static final Logger log = LoggerFactory.getLogger(RestController.class);
	
	@GetMapping("/health-check")
	public ResponseEntity<AppResponse<?>> healthCheck(){
		log.info("health check success...");
		AppResponse<Student> respObj = new AppResponse<>();
		respObj.setMessage("Health Check success");
		respObj.setStatusCode(200);
		respObj.setData(null);
		return new ResponseEntity<>(respObj, HttpStatus.OK);
		
	}
	
	@GetMapping("/i18n")
	public String goodMorning(@RequestHeader(name="Accept-Language", required = false) Locale locale){
		log.info("goodMorning controller...");
		return msgSource.getMessage("good.morning.message", null, locale);
		
	}
	
	@PostMapping("/save-student")
	public ResponseEntity<AppResponse<?>> saveFruit(@RequestBody @Valid StudentModel reqModel){
		log.info("inside save-student controller..");
		Student resp = service.saveStudent(reqModel);
		AppResponse<Student> respObj = new AppResponse<>();
		respObj.setMessage("Student successfully saved");
		respObj.setStatusCode(200);
		respObj.setData(resp);
		return new ResponseEntity<>(respObj, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete-student/{id}")
	public ResponseEntity<AppResponse<?>> deleteStudent(@PathVariable Long id){
		log.info("inside get-student controller..studentId: {}", id);
		String resp = service.deleteStudent(id);
		AppResponse<String> respObj = new AppResponse<>();
		respObj.setMessage("Student deleted successfully!");
		respObj.setStatusCode(200);
		respObj.setData(resp);
		return new ResponseEntity<>(respObj, HttpStatus.OK);
	}
	
	@GetMapping("/get-student")
	public ResponseEntity<AppResponse<?>> saveStudent(@RequestParam String studentName){
		log.info("inside get-student controller..studentName: {}", studentName);
		StudentModel respModel = service.getStudent(studentName);
		AppResponse<StudentModel> respObj = new AppResponse<>();
		respObj.setMessage("Student details found");
		respObj.setStatusCode(200);
		respObj.setData(respModel);
		return new ResponseEntity<>(respObj, HttpStatus.OK);
	}
	
	@GetMapping("/get-student-by-id/{id}")
	public ResponseEntity<AppResponse<?>> getStudentById(@PathVariable Long id){
		log.info("inside getStudentById controller..studentId: {}", id);
		StudentModel respModel = service.getStudentById(id);
		AppResponse<StudentModel> respObj = new AppResponse<>();
		respObj.setMessage("Student details found");
		respObj.setStatusCode(200);
		respObj.setData(respModel);
		return new ResponseEntity<>(respObj, HttpStatus.OK);
	}
}
