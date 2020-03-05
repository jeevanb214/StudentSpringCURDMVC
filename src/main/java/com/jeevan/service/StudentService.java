package com.jeevan.service;

import java.util.List;

import com.jeevan.model.StudentDetails;

public interface StudentService {
	
	public int addStudent(StudentDetails student);
	
	public List<StudentDetails> listAllStudents();
	
	public int updateStudent(StudentDetails student);
	
	public int deleteStudent(int primary);
	
	public StudentDetails getStudentObject(int primary);
	
	public int removeStudentWithNoName();  

}
