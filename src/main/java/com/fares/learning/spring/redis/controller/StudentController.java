package com.fares.learning.spring.redis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fares.learning.spring.redis.model.Student;
import com.fares.learning.spring.redis.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
	private StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping("/all")
	public ResponseEntity getAllStudents() {
		LOG.info("Getting all students");
		Map<String, Student> studentsList = studentRepository.findAll();
		List<Student> students = new ArrayList<>();

		for (String key : studentsList.keySet()) {
			students.add(studentsList.get(key));
		}

		return ResponseEntity.status(HttpStatus.OK).body(students);
	}

	@GetMapping
	public ResponseEntity getStudentById(@RequestParam("studentId") String studentId) {
		LOG.info("Getting student by id: {}", studentId);
		Student student = studentRepository.findById(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}

	@PostMapping
	public ResponseEntity createStudent(@RequestBody Student student) {
		LOG.info("Creating student: {}", student);
		studentRepository.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}

	@DeleteMapping
	public ResponseEntity deleteStudentById(@RequestParam("studentId") String studentId) {
		LOG.info("Deleting student by id: {}", studentId);
		studentRepository.deleteById(studentId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/{studentId}")
	public ResponseEntity updateStudent(@RequestPart("studentId") String studentId, @RequestBody Student student) {
		LOG.info("Updating student for id:{}", studentId);
		studentRepository.update(student);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
}
