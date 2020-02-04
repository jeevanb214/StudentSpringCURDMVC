package com.jeevan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeevan.dao.Impl.StudentDaoImpl;
import com.jeevan.model.StudentDetails;
import com.jeevan.service.StudentService;

@Service		// annotation is used in your service layer and annotates classes that perform service tasks, often you don't use it but in many case you use this annotation to represent a best practice. For example, you could directly call a DAO class to persist an object to your database but this is horrible. It is pretty good to call a service class that calls a DAO. This is a good thing to perform the separation of concerns pattern
public class StudentServiceImpl implements StudentService {

	
	StudentDaoImpl dao;
	
	
	@Autowired
	public StudentServiceImpl(StudentDaoImpl dao) {
		this.dao = dao;
	}

	public int addStudent(StudentDetails student) {
		// TODO Auto-generated method stub
		
		System.out.println("dao obj = "+dao);
		
		dao.addStudent(student);
		
		
		return 0;
	}

	//@Transactional(readOnly = true)
	public List<StudentDetails> listAllStudents() {
		// TODO Auto-generated method stub
		
		List<StudentDetails> list = new ArrayList();
		
		list = dao.listAllStudents();
		
		return list;
	}

	public int updateStudent(StudentDetails student) {
		// TODO Auto-generated method stub
		
		dao.updateStudent(student);
		return 0;
	}

	public int deleteStudent(int primary) {
		// TODO Auto-generated method stub
		
		dao.deleteStudent(primary);
		return 0;
	}

	public StudentDetails getStudentObject(int primary) {
		// TODO Auto-generated method stub
		
		StudentDetails student = dao.getStudentObject(primary);
		return student;
	}

}
