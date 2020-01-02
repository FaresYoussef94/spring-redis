package com.fares.learning.spring.redis.repository;

import java.util.Map;

import com.fares.learning.spring.redis.model.Student;

public interface StudentRepository {

	void save(Student student);

	Map<String, Student> findAll();

	void update(Student student);

	Student findById(String id);

	void deleteById(String id);

}
