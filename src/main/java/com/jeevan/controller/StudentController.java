package com.jeevan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeevan.model.StudentDetails;
import com.jeevan.service.impl.StudentServiceImpl;

@Controller
public class StudentController {
	
	
	
	 //this value is given in the spring-servlet.xml so that  value is directly injected to the service 
	StudentServiceImpl service;
	
	
	@Autowired
	public StudentController(StudentServiceImpl service) {
		this.service = service;
	}

	@RequestMapping("/RegisterStudent")
	public String registerStudents(Model model)
	{
		model.addAttribute("student", new StudentDetails());  
		return "addStudent.jsp";
	}
	
	@RequestMapping(value="/registerSuccess", method=RequestMethod.POST)
	public String registerSuccess(@ModelAttribute("student") StudentDetails student1) {
		
		System.out.println("hello");
		System.out.println(student1.getsName());
		System.out.println(student1.getDept());
		System.out.println("StudentService obj = "+service);

		service.addStudent(student1);
		
		//userService.createUser(student);
		return "redirect:/listStudents";
	}
	
	
	
	
	@RequestMapping(value="/listStudents", method=RequestMethod.GET) //here we will get the data from DB so the method is method=RequestMethod.GET
	public String listStudents(Model model)
	{
		//ModelAndView model = new ModelAndView();
		List<StudentDetails> studentList = new ArrayList<StudentDetails>();
		
		studentList = service.listAllStudents();
		
	
		/*
		model.addObject("list", student);
	
		model.setViewName("listStudents.jsp");
		*/
		
		model.addAttribute("list", studentList);
		
		
		return "listStudents.jsp";
		
	}
	
	@RequestMapping(value="/updateOrDelete", method=RequestMethod.POST)
	public String updateOrDelete(HttpServletRequest req , Model model) //we use HttpServletRequest to get the type of action button we used 
	{
		int primary = Integer.parseInt(req.getParameter("key")); //here we get the id 
		
		String actionname =  req.getParameter("action"); // by doing this we will get the action name whether it is submit or update button used 
		
		System.out.println("primary id = "+primary);
		
		System.out.println("Action = "+actionname);
		
		if(actionname.equals("update"))
		{
			StudentDetails student = service.getStudentObject(primary);
			
			/*
			System.out.println(student.getId());
			System.out.println(student.getsName());
			System.out.println(student.getAge());
			System.out.println(student.getGender());
			System.out.println(student.getDept());
			*/
			model.addAttribute("student", student);
			
			return "updateStudentDetails.jsp";
		}
		else
		{
			service.deleteStudent(primary);
			return "redirect:/listStudents";
		}
		
		
		
		
	}
	
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.POST)
   public String updateStudent(HttpServletRequest req , @ModelAttribute("student") StudentDetails student)
   {
		int primary = Integer.parseInt(req.getParameter("id"));
		
		//System.out.println("primary id = "+primary);
		student.setId(primary);
		/*
		System.out.println("id = "+student.getId());
		System.out.println(student.getId());
		System.out.println(student.getsName());
		System.out.println(student.getAge());
		System.out.println(student.getGender());
		System.out.println(student.getDept());
		*/
		service.updateStudent(student);
		
		
		return "redirect:/listStudents";
	   
   }
	


}
