package com.paromita.service;

import java.util.List;

import com.paromita.model.Student;

public interface StudentService {
	
	public void add(Student student);
	public void edit(Student student);
	public void delete(int studentId);
	public Student getStudent(int studentId);
	public List getAllStudents();

}
