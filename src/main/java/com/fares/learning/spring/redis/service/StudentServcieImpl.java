package com.fares.learning.spring.redis.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fares.learning.spring.redis.model.Student;
import com.fares.learning.spring.redis.repository.StudentRepository;

@Service
public class StudentServcieImpl implements StudentServcie {

	private static final Logger LOG = LoggerFactory.getLogger(StudentServcieImpl.class);
	private final StudentRepository studentRepository;

	public StudentServcieImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student createStudent(Student student) {
		LOG.info("Saving student: {}", student);
		return studentRepository.save(student);
	}

	@Override
	public Student getStudent(String id) {
		LOG.info("Getting student by id: {}", id);
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		LOG.info("Updating student: {}", student);
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(String id) {
		LOG.info("Deleting student by id: {}", id);
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		LOG.info("Getting all students");
		List<Student> studentsList = new ArrayList<>();
		studentRepository.findAll().forEach(studentsList::add);
		return studentsList;
	}

}
