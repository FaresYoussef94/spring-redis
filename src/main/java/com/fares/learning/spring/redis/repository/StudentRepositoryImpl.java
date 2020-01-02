package com.fares.learning.spring.redis.repository;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.fares.learning.spring.redis.model.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	private static final Logger LOG = LoggerFactory.getLogger(StudentRepositoryImpl.class);
	private RedisTemplate<String, Student> redisTemplate;

	private HashOperations hashOperations;

	public StudentRepositoryImpl(RedisTemplate<String, Student> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = this.redisTemplate.opsForHash();
	}

	@Override
	public void save(Student student) {
		LOG.info("Saving student: {}", student);
		hashOperations.put("STUDENT", student.getId(), student);
	}

	@Override
	public Map<String, Student> findAll() {
		LOG.info("Getting all the available");
		return hashOperations.entries("STUDENT");
	}

	@Override
	public void update(Student student) {
		LOG.info("Updating student: {}", student);
		hashOperations.put("STUDENT", student.getId(), student);
	}

	@Override
	public Student findById(String id) {
		LOG.info("Finding student by id: {}", id);
		return (Student) hashOperations.get("STUDENT", id);
	}

	@Override
	public void deleteById(String id) {
		LOG.info("Deleting student by id: {}", id);
		hashOperations.delete("STUDENT", id);
	}

}
