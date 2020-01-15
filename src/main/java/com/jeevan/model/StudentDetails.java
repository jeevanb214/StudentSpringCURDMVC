package com.jeevan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  //@Entity is useful with model classes to denote that this is the entity or table
@Table  //@Table is used to provide any specific name to your table if you want to provide any different name
public class StudentDetails {
				//Note: if you don't use @Table then hibernate consider that @Entity is your table name by default and @Entity must

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String sName;
	
	@Column
	private int age;
	
	@Column
	private String gender;
	
	@Column
	private String dept;

	@OneToMany(fetch = FetchType.EAGER)// want to develop more didn't developed so there is no use of this tag
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
 
	@OneToMany(fetch = FetchType.EAGER)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

}
