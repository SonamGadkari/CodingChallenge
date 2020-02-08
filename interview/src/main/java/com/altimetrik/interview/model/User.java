package com.altimetrik.interview.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class User {

	private String name;
	private String email;
	private String gender;
	private int age;
	public User() {		
	}
	
	public User(String name, String email, String gender, int age) {
		//super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString()
	{
		String str=this.name+" "+this.email+" "+this.gender+" "+this.age;
		return str;
	}
	
	
}
