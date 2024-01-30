package com.test.restwebservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.restwebservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findByName(String studentName);
	
	int deleteByName(String studentName);
	
}
