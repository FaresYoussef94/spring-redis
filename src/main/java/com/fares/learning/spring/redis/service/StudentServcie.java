package com.fares.learning.spring.redis.service;

import java.util.List;

import com.fares.learning.spring.redis.model.Student;

public interface StudentServcie {

	Student createStudent(Student student);

	Student getStudent(String id);

	Student updateStudent(Student student);

	void deleteStudent(String id);

	List<Student> getAllStudents();

}
