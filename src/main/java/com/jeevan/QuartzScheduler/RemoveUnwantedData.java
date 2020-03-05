package com.jeevan.QuartzScheduler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.jeevan.controller.StudentController;
import com.jeevan.service.impl.StudentServiceImpl;

@ComponentScan
public class RemoveUnwantedData {

	@Autowired
	StudentServiceImpl service;
	
	
	@Autowired
	public RemoveUnwantedData(StudentServiceImpl service) {
		this.service = service;
	}

	
	public void printMe() {
		Date d = new Date();
		try {
			int num = service.removeStudentWithNoName();
			System.out.println("Time:" + d + "****" + num + " Num Of Sudents deleted with no name");
		} catch (Exception e) {
			System.err.println("Exception while getting values from the DB");
		}
		}

}
