package com.fares.learning.spring.redis.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

	public StudentController() {

	}

	@GetMapping()
	public ResponseEntity getAllStudents() {
		LOG.info("Getting all students");

		List<String> studentsList = new ArrayList<>();
		studentsList.add("a");
		studentsList.add("b");

		return ResponseEntity.status(HttpStatus.OK).body(studentsList);
	}
}
