package com.paromita.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ComponentSystemEvent;
import javax.persistence.PreRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.paromita.model.Student;
import com.paromita.service.StudentService;

@Component
@Scope("session")
public class StudentBean {
	
	@Autowired
	StudentService service;

	private int studentId;
	private String firstName;
	private String lastName;
	private int yearLevel;
	private List allStudents;
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}
	
	public void add(){
		Student newStudent = new Student();
		newStudent.setFirstName(getFirstName());
		newStudent.setLastName(getLastName());
		newStudent.setYearLevel(getYearLevel());
		service.add(newStudent);
		updateNewStudent();
	}
	
	private void updateNewStudent(){
		allStudents = service.getAllStudents();
	}
	
	public void edit(Student student){
		service.edit(student);
	}
	public void delete(){
		service.delete(getStudentId());
	}
	public Student getStudent(int studentId){
		return service.getStudent(studentId);
	}
	
	public List getAllStudents(){
		return allStudents;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Init Called!");
		//allStudents = service.getAllStudents();
	}
	
	
	public void initView(ComponentSystemEvent event){
		System.out.println("Init View called!");
		allStudents = service.getAllStudents();
	}
}
