package com.fares.learning.spring.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fares.learning.spring.redis.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
