package com.fares.learning.spring.redis.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fares.learning.spring.redis.model.Student;

@Service
public class StudentServcieImpl implements StudentServcie {

	private static final Logger LOG = LoggerFactory.getLogger(StudentServcieImpl.class);
	private final RedisTemplate<String, Student> redisTemplate;

	public StudentServcieImpl(RedisTemplate<String, Student> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public Student createStudent(Student student) {
		LOG.info("Saving student: {}", student);
//		return studentRepository.save(student);
		return null;
	}

	@Override
	public Student getStudent(String id) {
		LOG.info("Getting student by id: {}", id);
//		return studentRepository.findById(id).get();
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		LOG.info("Updating student: {}", student);
//		return studentRepository.save(student);
		return null;
	}

	@Override
	public void deleteStudent(String id) {
		LOG.info("Deleting student by id: {}", id);
//		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		LOG.info("Getting all students");
		List<Student> studentsList = new ArrayList<>();

		redisTemplate.opsForValue().get("name");
//		studentRepository.findAll().forEach(studentsList::add);
		return studentsList;
	}

}
