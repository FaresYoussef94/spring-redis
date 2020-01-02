package com.fares.learning.spring.redis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fares.learning.spring.redis.model.Student;
import com.fares.learning.spring.redis.service.StudentServcie;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
	private final StudentServcie studentServcie;

	public StudentController(StudentServcie studentServcie) {
		this.studentServcie = studentServcie;
	}

	@GetMapping()
	public ResponseEntity getAllStudents() {
		LOG.info("Getting all students");
		List<Student> studentsList = studentServcie.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(studentsList);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity getStudentById(@RequestPart("studentId") String studentId) {
		LOG.info("Getting student by id: {}", studentId);
		Student student = studentServcie.getStudent(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}

	@PostMapping
	public ResponseEntity createStudent(@RequestBody Student student) {
		LOG.info("Creating student: {}", student);
		Student createdStudent = studentServcie.createStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity deleteStudentById(@RequestPart("studentId") String studentId) {
		LOG.info("Deleting student by id: {}", studentId);
		studentServcie.deleteStudent(studentId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
