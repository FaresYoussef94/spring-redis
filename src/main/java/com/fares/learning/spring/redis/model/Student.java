package com.fares.learning.spring.redis.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
public class Student implements Serializable {

	private String id;
	private String name;
	private String gender;
	private int grade;

	public Student(String id, String name, String gender, int grade) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", gender=" + gender + ", grade=" + grade
				+ '}';
	}

}
