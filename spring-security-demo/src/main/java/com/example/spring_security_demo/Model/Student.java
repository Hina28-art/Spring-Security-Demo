package com.example.spring_security_demo.Model;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Student {

	private  Integer id;
	private  String Name; 
	private  Integer marks;
	
	
	public Student() {}
	
	public Student(Integer id, String Name,  Integer marks) {
		super();
		this.id = id!=null? id : 0;
		this.Name = Name;
		this.marks = marks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", marks=" + marks + "]";
	}
	
	

	
}
