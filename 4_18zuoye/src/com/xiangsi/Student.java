package com.xiangsi;

public class Student implements Comparable {
	private String name;
	private int age;
	private int gender;
	public Student(String name,int age,int gender){
		this.name=name;
		this.age=age;
		this.gender=gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int compareTo(Object o){
		Student s = (Student) o;
		if(this.age<s.getAge()){
			return -1;
		}
		if(this.age>s.getAge()){
			return 1;
		}
		return 0;
	}
	
}
