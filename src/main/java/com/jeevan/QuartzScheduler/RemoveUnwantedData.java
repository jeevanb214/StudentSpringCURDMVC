package com.jeevan.QuartzScheduler;

import java.util.Date;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class RemoveUnwantedData {
	
	public void printMe()
	{
		Date d=new Date();
		System.out.println(d);
		System.out.println("I am PRinting");
	}

}
