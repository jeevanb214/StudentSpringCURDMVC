package com.jeevan.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeevan.dao.StudentDao;
import com.jeevan.model.StudentDetails;

@Repository //Spring @Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
public class StudentDaoImpl implements StudentDao {

	
	@Autowired
    SessionFactory sessionFactory;
	
	//Session se = null;
	
	public int addStudent(StudentDetails student) {
		// TODO Auto-generated method stub
		
		System.out.println("sessionFactory obj = "+sessionFactory);
		Session session = sessionFactory.openSession();
		Transaction trnx = session.beginTransaction();
		
		session.save(student);
		
		trnx.commit();
		session.close();
		return 0;
	}
	
	public List<StudentDetails> listAllStudents() {
		// TODO Auto-generated method stub
		
		Session session = null;
		session = sessionFactory.openSession();
		
		
		List<StudentDetails> list = new ArrayList();
		
		Query query = session.createQuery("from StudentDetails");
		
		list = query.list();
		
		session.flush();
		session.close();
		
		
		return list;
	}
	public int updateStudent(StudentDetails student) {
		// TODO Auto-generated method stub
		
		Session session = null;
		session = sessionFactory.openSession();
		
		Transaction trnx = session.beginTransaction();
		
		session.update(student);
		
		trnx.commit();
		
		session.flush();
		session.close();
	
		
		
		
		return 0;
	}
	public int deleteStudent(int primary) {
		// TODO Auto-generated method stub
		
		Session session = null;
		session = sessionFactory.openSession();

		Transaction trnx = session.beginTransaction();
		
		StudentDetails student =   (StudentDetails) session.load(StudentDetails.class, primary); //here we are getting the particular student object by using id from database 
		
		session.delete(student);
		
		trnx.commit();
		
		session.flush();
		session.close();
		return 0;
	}
	public StudentDetails getStudentObject(int primary) {
		// TODO Auto-generated method stub
		
		Session session = null;
		session = sessionFactory.openSession();					
		
		StudentDetails student = (StudentDetails) session.load(StudentDetails.class, primary); //here we are getting the particular student object by using id from database 
		session.flush();
		//session.close();
		return student;
	}

}
